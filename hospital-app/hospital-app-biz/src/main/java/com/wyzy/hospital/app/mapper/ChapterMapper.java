

package com.wyzy.hospital.app.mapper;

import com.wyzy.hospital.app.api.entity.Chapter;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 电子书章节
 *
 * @author aqie
 * @date 2021-05-25 16:08:50
 */
@Mapper
public interface ChapterMapper extends HospitalBaseMapper<Chapter> {

}
