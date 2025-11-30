

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.EnArticles;

import java.util.List;

/**
 * 文章表
 *
 * @author hospital code generator
 * @date 2021-04-20 17:06:46
 */
public interface EnArticlesService extends IService<EnArticles> {
    //通过articleName模糊查询并随机查询3条文章表信息

    List<EnArticles> queryLikeName(String articleName);
}
