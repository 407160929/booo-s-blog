package com.bo.controller;


import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddRoleDto;
import com.bo.domain.dto.PutRoleDto;
import com.bo.domain.dto.RoleStatusDto;
import com.bo.domain.entity.Role;
import com.bo.domain.vo.PageVo;
import com.bo.service.RoleService;
import com.bo.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ResourceBundle;

@RestController
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public ResponseResult<PageVo> getList(Integer pageNum, Integer pageSize, String roleName, String status){
        return roleService.getList(pageNum,pageSize,roleName,status);
    }

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody RoleStatusDto roleStatusDto){
        return roleService.changeStatus(roleStatusDto);
    }

    @PostMapping
    public ResponseResult addRole(@RequestBody AddRoleDto addRoleDto){
        return roleService.addRole(addRoleDto);
    }

    @GetMapping("/{id}")
    public ResponseResult getRole(@PathVariable(value = "id") Long id){
        return roleService.getRoleById(id);
    }

    @PutMapping
    public ResponseResult putRole(@RequestBody PutRoleDto putRoleDto){
        return roleService.putRole(putRoleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteRole(@PathVariable(value = "id") Long id){
        return roleService.deleteRole(id);
    }

    @GetMapping("/listAllRole")
    public ResponseResult listAllRole(){
        return roleService.listAllRole();
    }
}
