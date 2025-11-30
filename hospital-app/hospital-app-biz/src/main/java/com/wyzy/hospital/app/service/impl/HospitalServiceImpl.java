package com.wyzy.hospital.app.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.feign.RemoteHospitalService;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;
import com.wyzy.hospital.app.api.entity.HospitalEs;
import com.wyzy.hospital.app.repository.HospitalRepository;
import com.wyzy.hospital.app.service.HospitalService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author aqie
 * Date on 2021/5/20  14:32
 * @Function:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
	private final HospitalRepository hospitalRepository;

	private final RemoteHospitalService remoteUserService;


	private final ElasticsearchRestTemplate elasticsearchRestTemplate;

	@Override
	public void deleteAll() {
		hospitalRepository.deleteAll();
	}

	@Override
	public HospitalEs getById(Long id) {
		HospitalEs hospitalEs  = hospitalRepository.findById(id).orElse(null);
		return hospitalEs;
	}

	@Override
	public void saveAll(List<HospitalEs> list) {
		hospitalRepository.saveAll(list);
	}

	@Override
	public List<HospitalEs> getHospitalFromMysql(Query query, String hospitalName){
		R<Page<AppHospitalVO>> hospitalList = remoteUserService.getHospitalList(query.getCurrent(), query.getSize(),hospitalName);
		List<AppHospitalVO> records = hospitalList.getData().getRecords();
		List<HospitalEs> hospitalEs = records.stream().map(HospitalEs::new).collect(Collectors.toList());
		return hospitalEs;
	}

	@Override
	public HospitalEs createOrUpdate(HospitalEs hospitalVO) {
		HospitalEs save = hospitalRepository.save(hospitalVO);
		return save;
	}

	@Override
	public PageImpl<HospitalEs> searchHospital(String hospitalName, String registrationDate, Query query){
		// 这里比常规减一
		Pageable pageable = PageRequest.of(query.getCurrent() - 1,query.getSize());

		BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
		TermQueryBuilder termQuery = QueryBuilders.termQuery("registrationDate", registrationDate);
		MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("hospitalName", hospitalName);
		boolBuilder.must(matchQuery);
		boolBuilder.filter(termQuery);

		NativeSearchQuery nativeSearchQueryBuilder = new NativeSearchQuery(boolBuilder);
		nativeSearchQueryBuilder.setPageable(pageable);
		String dsl = Objects.requireNonNull(nativeSearchQueryBuilder.getQuery()).toString();
		log.info("DSL {}", dsl);
		SearchHits<HospitalEs> searchHits = elasticsearchRestTemplate.search(nativeSearchQueryBuilder, HospitalEs.class);
		if(searchHits.getTotalHits()<=0){
			return new PageImpl<>(Collections.emptyList(),pageable,0);
		}
		List<HospitalEs> searchProductList = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
		return new PageImpl<>(searchProductList,pageable,searchHits.getTotalHits());
	}


}
