package com.bo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.domain.entity.ArticleTag;

import java.util.List;


/**
 * 文章标签关联表(ArticleTag)表服务接口
 *
 * @author makejava
 * @since 2022-12-27 01:11:13
 */
public interface ArticleTagService extends IService<ArticleTag> {

    void updateArticleTag(Long id,List<ArticleTag> articleTags);
}
