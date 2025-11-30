

package com.wyzy.hospital.common.core.constant;

/**
 * @author wyzy
 * @date 2018年06月22日16:41:01 服务名称
 */
public interface ServiceNameConstants {

	/**
	 * 认证中心
	 */
	String AUTH_SERVICE = "hospital-auth";

	/**
	 * UMPS模块
	 */
	String UPMS_SERVICE = "hospital-upms-biz";

	/**
	 * 分布式事务协调服务
	 */
	String TX_MANAGER = "hospital-tx-manager";

	/**
	 * 科室微服务
	 */
	String DEPARTMENT_HOSPITAL = "hospital-department-biz";

	/**
	 * 医生微服务
	 */
	String DOCTOR_HOSPITAL = "hospital-doctor-biz";

	/**
	 * 患者微服务
	 */
	String PATIENTS_HOSPITAL = "hospital-patients-biz";

	/**
	 * 医院微服务
	 */
	String HOSPITAL_HOSPITAL = "hospital-hospital-biz";

	/**
	 * app微服务
	 */
	String APP_HOSPITAL = "hospital-app-biz";

	/**
	 * quartz 定时任务
	 */
	String QUARTZ_HOSPITAL = "hospital-daemon-quartz";

}
