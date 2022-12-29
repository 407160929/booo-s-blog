package com.bo.controller;

import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddLinkDto;
import com.bo.domain.entity.Link;
import com.bo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/link")
public class LinkController {
    @Autowired
    private LinkService linkService;
    @GetMapping("/list")
    public ResponseResult getLinkList(Integer pageNum, Integer pageSize,String name,String status){
        return linkService.getLinkList(pageNum,pageSize,name,status);
    }
    @PostMapping
    public ResponseResult addLink(@RequestBody AddLinkDto addLinkDto){
        return linkService.addLink(addLinkDto);
    }

    @GetMapping("/{id}")
    public ResponseResult getLinkById(@PathVariable(value = "id") Long id){
        return linkService.getLinkById(id);
    }

    @PutMapping
    public ResponseResult putLink(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteLink(@PathVariable(value = "id") Long id){
        linkService.getBaseMapper().deleteById(id);
        return ResponseResult.okResult();
    }

    @PutMapping("/changeLinkStatus")
    public ResponseResult changeLink(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }
}
