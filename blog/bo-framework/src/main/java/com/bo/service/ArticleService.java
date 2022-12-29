package com.bo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddArticleDto;
import com.bo.domain.dto.ArticleListDto;
import com.bo.domain.entity.Article;
import com.bo.domain.vo.PageVo;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);

    ResponseResult add(AddArticleDto article);

    ResponseResult<PageVo> pageArticleList(Integer pageNum, Integer pageSize, ArticleListDto articleListDto);

    ResponseResult getArticleById(Long id);

    ResponseResult put(AddArticleDto AddArticleDto);

    ResponseResult deleteArticleById(Long id);
}
