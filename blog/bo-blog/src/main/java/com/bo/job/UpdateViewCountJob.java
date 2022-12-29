package com.bo.job;

import com.aliyun.oss.internal.ResponseParsers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bo.domain.entity.Article;
import com.bo.service.ArticleService;
import com.bo.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UpdateViewCountJob {

    @Autowired
    RedisCache redisCache;

    @Autowired
    private ArticleService articleService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void updateViewCount(){
        //获取redis中的浏览量
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");

        List<Article> articles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                .collect(Collectors.toList());
        //更新到数据库中
        for(Article article:articles){
            UpdateWrapper<Article> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id",article.getId());
            updateWrapper.set("view_count",article.getViewCount());
            articleService.update(null,updateWrapper);
        }
//        articleService.saveOrUpdateBatch(articles);
    }

    //for(Device device : devices){
    //            UpdateWrapper<Device> updateWrapper = new UpdateWrapper<>();
    //            updateWrapper.eq("id",device.getId());
    //            updateWrapper.set("view_count",device.getViewCount());
    //            deviceService.update(null,updateWrapper);
    //
    //        }
}
