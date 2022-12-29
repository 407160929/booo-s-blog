package com.bo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bo.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-26 17:40:13
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleKeyByUserId(Long id);
}

