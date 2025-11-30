package com.wyzy.hospital.psychology.Kit.impl;

import cn.hutool.core.date.DateUtil;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.api.feign.RemotePsychologyDoctorService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.psychology.Kit.PsychologistRecommendDetailKitService;
import com.wyzy.hospital.psychology.Kit.PsychologistRecommendKitService;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.api.entity.MonthDate;
import com.wyzy.hospital.psychology.service.PsychologistRecommendDetailService;
import com.wyzy.hospital.psychology.service.PsychologistRecommendService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.wyzy.hospital.common.core.util.DayUtil.getWeek;

/**
 * 查图片实现类
 *
 * @author wrk
 * @date 2021/05/08 09:39
 **/
@Service
@AllArgsConstructor
public class PsychologistRecommendDetailKitServiceImpl implements PsychologistRecommendDetailKitService {

	@Resource
	private RemotePsychologyDoctorService remotePsychologyDoctorService;
	@Resource
	private PsychologistRecommendDetailService psychologistRecommendDetailService;

	/**
	 * 心理医生详情
	 * @param doctorId
	 * @return
	 */
	@Override
	public PsychologistRecommendDetailDTO getRecommendDoctorParticulars(Long doctorId,String year,String month) {
		R<Doctor> doctorR = remotePsychologyDoctorService.getPsychologyByDoctorId(doctorId);
		if (doctorR.getData() == null){return null;}

		/**
		 * 推荐医生详情
		 * @return
		 */
		PsychologistRecommendDetailDTO psychologistRecommendDetailDTO= psychologistRecommendDetailService.getRecommendDoctorParticulars(doctorId);
		if (psychologistRecommendDetailDTO == null){
			return null;
		}
		psychologistRecommendDetailDTO.setDoctorName(doctorR.getData().getDoctorName());
		psychologistRecommendDetailDTO.setAvatar(doctorR.getData().getAvatar());
		psychologistRecommendDetailDTO.setWorkYears(doctorR.getData().getWorkYears());
		psychologistRecommendDetailDTO.setPhone(doctorR.getData().getPhone());
		/**
		 * 查询每月挂号情况
		 * year 年
		 * month 月
		 */
		String format;
		if (year == null || month == null){
			//当前时间
			Date date = DateUtil.date();
			//结果 2017/03/
			format = DateUtil.format(date, "yyyy-MM");
		}else {
			format = year+"-"+month;
		}
		List<MonthDate> monthDateList= psychologistRecommendDetailService.getDatime(doctorId,format);
		if (monthDateList != monthDateList || monthDateList.size() != 0){
			for (MonthDate monthDate:monthDateList){
				String weekOfDate = getWeekOfDate(monthDate.getDateTime());
				monthDate.setWeek(weekOfDate);
				psychologistRecommendDetailDTO.setMonthDateList(monthDateList);
			}
		}else {
			return null;
		}
		return psychologistRecommendDetailDTO;
	}

	/**
	 * 获取指定日期是星期几<br>
	 * @return 指定日期是星期几
	 */
	public static String getWeekOfDate(String dateStr) {
		Date date = DateUtil.parse(dateStr);
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0){
			w = 0;
		}
		return weekDays[w];
	}
}
