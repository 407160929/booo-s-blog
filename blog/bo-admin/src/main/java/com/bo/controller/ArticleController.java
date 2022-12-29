package com.bo.controller;

import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddArticleDto;
import com.bo.domain.dto.ArticleListDto;
import com.bo.domain.vo.ArticleGetVo;
import com.bo.domain.vo.PageVo;
import com.bo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }

    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, ArticleListDto articleListDto){
        return articleService.pageArticleList(pageNum, pageSize, articleListDto);
    }

    @GetMapping("/{id}")
    public ResponseResult<ArticleGetVo> getArticleById(@PathVariable(value = "id") Long id){
        return articleService.getArticleById(id);
    }

    @PutMapping
    public ResponseResult putArticle(@RequestBody AddArticleDto AddArticleDto){
        return articleService.put(AddArticleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteArticle(@PathVariable(value = "id") Long id){
        return articleService.deleteArticleById(id);
    }


}
