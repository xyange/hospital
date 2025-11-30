package com.wyzy.hospital.app.controller;

import com.alibaba.fastjson.JSON;
import com.wyzy.hospital.app.api.entity.ElasticEntity;
import com.wyzy.hospital.app.service.ElasticsearchHighLevelService;
import com.wyzy.hospital.app.utils.ElasticUtil;
import com.wyzy.hospital.app.api.vo.ElasticDataVo;
import com.wyzy.hospital.app.api.vo.IdxVo;
import com.wyzy.hospital.app.api.vo.QueryVo;
import com.wyzy.hospital.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author aqie
 * Date on 2021/5/18  10:15
 * @Function:
 */
@Slf4j
@RestController
@RequestMapping("es")
public class ElasticsearchController {



	@Autowired
	private ElasticsearchHighLevelService esService;

	/**
	 * @Description 创建Elastic索引
	 * @param idxVo
	 * @throws
	 * @date 2019/11/19 11:07
	 */
	@PostMapping(value = "/createIndex")
	public R<String> createIndex(@RequestBody IdxVo idxVo){
		try {
			String idxSql = JSON.toJSONString(idxVo.getIdxSql());
			log.info("idxName={}, idxSql={}",idxVo.getIdxName(),idxSql);
			boolean isCreate = esService.createIndex(idxVo.getIdxName(), idxSql);
			if (isCreate){
				return R.ok();
			} else {
				return R.failed("创建失败");
			}

		} catch (Exception e) {
			log.error("ERROR", e.getCause());
			return  R.failed(e.getMessage());
		}

	}


	/**
	 * @Description 判断索引是否存在；存在-TRUE，否则-FALSE
	 * @param index
	 * @throws
	 * @date 2019/11/19 18:48
	 */
	@GetMapping(value = "/exist/{index}")
	public R<String> indexExist(@PathVariable(value = "index") String index){

		try {
			if(!esService.indexExist(index)){
				return R.failed("索引不存在");
			} else {
				return R.ok("索引存在");
			}
		} catch (Exception e) {
			log.error("ERROR", e);
			return  R.failed(e.getMessage());
		}

	}

	@DeleteMapping(value = "/del/{index}")
	public R<String> indexDel(@PathVariable(value = "index") String index){
		try {
			esService.deleteIndex(index);
			return R.ok();
		} catch (Exception e) {
			log.error("ERROR", e);
			return R.failed(e.getMessage());
		}
	}

	/**
	 * 新增数据
	 * @param elasticDataVo
	 * @return
	 */
	@PostMapping("/add")
	public R<String> add(@RequestBody ElasticDataVo elasticDataVo){

		try {
			if(!StringUtils.isNotEmpty(elasticDataVo.getIdxName())){
				return R.failed("索引为空，不允许提交");
			}
			ElasticEntity elasticEntity = new ElasticEntity();
			elasticEntity.setId(elasticDataVo.getElasticEntity().getId());
			elasticEntity.setData(elasticDataVo.getElasticEntity().getData());

			esService.insertOrUpdateOne(elasticDataVo.getIdxName(), elasticEntity);

		} catch (Exception e) {
			log.error("插入数据异常，metadataVo={},异常信息={}", elasticDataVo.toString(),e.getMessage());
			return  R.failed(e.getMessage());

		}
		return R.ok();
	}

	@GetMapping("/get")
	public R<List<?>> get(@RequestBody QueryVo queryVo){

		if(!StringUtils.isNotEmpty(queryVo.getIdxName())){
			return R.failed("索引为空，不允许提交");
		}

		try {
			Class<?> clazz = ElasticUtil.getClazz(queryVo.getClassName());
			Map<String,Object> params = queryVo.getQuery().get("match");
			Set<String> keys = params.keySet();
			MatchQueryBuilder queryBuilders=null;
			for(String ke:keys){
				queryBuilders = QueryBuilders.matchQuery(ke, params.get(ke));
			}
			if(null!=queryBuilders){
				SearchSourceBuilder searchSourceBuilder = ElasticUtil.initSearchSourceBuilder(queryBuilders);
				List<?> data = esService.search(queryVo.getIdxName(),searchSourceBuilder,clazz);
				return R.ok(data);
			}
			return R.ok();
		} catch (Exception e) {
			log.error("查询数据异常，metadataVo={},异常信息={}", queryVo.toString(),e.getMessage());
			return  R.failed(e.getMessage());
		}

	}


	@PostMapping(value = "/delete")
	public R<String> delete(@RequestBody ElasticDataVo elasticDataVo){
		try {
			if(!StringUtils.isNotEmpty(elasticDataVo.getIdxName())){
				return R.failed("索引为空，不允许提交");
			}
			esService.deleteOne(elasticDataVo.getIdxName(),elasticDataVo.getElasticEntity());
		} catch (Exception e) {
			log.error("ERROR", e);
			return  R.failed(e.getMessage());
		}
		return R.ok();
	}


}
