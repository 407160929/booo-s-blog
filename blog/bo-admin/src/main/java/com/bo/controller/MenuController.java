package com.bo.controller;


import com.bo.domain.ResponseResult;
import com.bo.domain.entity.Menu;
import com.bo.enums.AppHttpCodeEnum;
import com.bo.service.MenuService;
import com.bo.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;

@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/list")
    public ResponseResult getMenulist(String status,String menuName){
        return menuService.getMenuList(status,menuName);
    }

    @PostMapping
    public ResponseResult postMenu(@RequestBody Menu menu){
        menuService.save(menu);
        return ResponseResult.okResult();
    }

    @GetMapping("/{id}")
    public ResponseResult getMenu(@PathVariable(value = "id") Long id){
        return menuService.getMenu(id);
    }

    @PutMapping
    public ResponseResult putMenu(@RequestBody Menu menu){
        Long parentId = menu.getParentId();
        Long id = menu.getId();
        if(!parentId.equals(id)){
            menuService.updateById(menu);
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.CORRECT_ERROR);
    }

    @DeleteMapping("/{menuId}")
    public ResponseResult deleteMenu(@PathVariable(value = "menuId") Long id){
        return menuService.deleteMenu(id);
    }

    @GetMapping("/treeselect")
    public ResponseResult treeSelect(){
        return menuService.treeSelect();
    }

    @GetMapping("/roleMenuTreeselect/{id}")
    public ResponseResult roleMenuTreeSelect(@PathVariable(value = "id")Long id){
        return menuService.roleMenuTreeSelect(id);
    }
}
