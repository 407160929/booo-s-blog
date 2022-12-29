package com.bo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddLinkDto;
import com.bo.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-12-23 00:42:37
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();

    ResponseResult getLinkList(Integer pageNum, Integer pageSize, String name, String status);

    ResponseResult addLink(AddLinkDto addLinkDto);

    ResponseResult getLinkById(Long id);
}
