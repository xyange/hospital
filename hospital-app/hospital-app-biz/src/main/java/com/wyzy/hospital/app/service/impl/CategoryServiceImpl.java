
package com.wyzy.hospital.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.app.api.entity.Category;
import com.wyzy.hospital.app.mapper.CategoryMapper;
import com.wyzy.hospital.app.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 电子书分类
 *
 * @author aqie
 * @date 2021-05-27 08:33:57
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
