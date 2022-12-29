package com.bo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddCommentDto;
import com.bo.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-12-24 18:17:53
 */
public interface CommentService extends IService<Comment> {


    ResponseResult addComment(Comment comment);

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);
}
