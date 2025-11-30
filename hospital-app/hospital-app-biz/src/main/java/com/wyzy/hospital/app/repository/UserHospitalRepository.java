package com.wyzy.hospital.app.repository;


import com.wyzy.hospital.app.entity.UserHospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author aqie
 * Date on 2021/6/4  17:21
 * @Function: 用户收藏医院
 */
public interface UserHospitalRepository extends MongoRepository<UserHospital, String> {

	/**
	 * 根据会员id 医院id 查询收藏
	 * @param memberId
	 * @param hospitalId
	 * @return
	 */
	UserHospital findByMemberIdAndHospitalId(Long memberId, Long hospitalId);
	/**
	 * 根据会员id 医院id 删除收藏
	 * @param memberId
	 * @param hospitalId
	 * @return
	 */
	int deleteByMemberIdAndHospitalId(Long memberId, Long hospitalId);

	/**
	 * 根据会员id 查询用户收藏列表
	 */
	Page<UserHospital> findByMemberId(Long memberId, Pageable pageable);
}
