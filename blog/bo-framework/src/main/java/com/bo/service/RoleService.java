package com.bo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddRoleDto;
import com.bo.domain.dto.PutRoleDto;
import com.bo.domain.dto.RoleStatusDto;
import com.bo.domain.entity.Role;
import com.bo.domain.vo.PageVo;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2022-12-26 17:40:14
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long id);

    ResponseResult<PageVo> getList(Integer pageNum, Integer pageSize, String roleName, String status);

    ResponseResult changeStatus(RoleStatusDto roleStatusDto);

    ResponseResult addRole(AddRoleDto addRoleDto);

    ResponseResult getRoleById(Long id);

    ResponseResult putRole(PutRoleDto putRoleDto);

    ResponseResult deleteRole(Long id);

    ResponseResult listAllRole();
}
