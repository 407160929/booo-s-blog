package com.bo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bo.constants.SystemConstants;
import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddRoleDto;
import com.bo.domain.dto.PutRoleDto;
import com.bo.domain.dto.RoleStatusDto;
import com.bo.domain.entity.ArticleTag;
import com.bo.domain.entity.Role;
import com.bo.domain.entity.RoleMenu;
import com.bo.domain.entity.Tag;
import com.bo.domain.vo.PageVo;
import com.bo.domain.vo.RoleGetVo;
import com.bo.mapper.RoleMapper;
import com.bo.service.RoleMenuService;
import com.bo.service.RoleService;
import com.bo.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2022-12-26 17:40:14
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    RoleMenuService roleMenuService;

    @Override
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员 如果是返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }
        //否则查询用户所具有的角色信息
        return getBaseMapper().selectRoleKeyByUserId(id);
    }

    @Override
    public ResponseResult<PageVo> getList(Integer pageNum, Integer pageSize, String roleName, String status) {
        //分页查询
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(roleName),Role::getRoleName,roleName);
        queryWrapper.eq(StringUtils.hasText(status),Role::getStatus,status);
        queryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据返回
        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult changeStatus(RoleStatusDto roleStatusDto) {
        Long roleId = roleStatusDto.getRoleId();
        LambdaUpdateWrapper<Role> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Role::getId,roleId);
        updateWrapper.set(Role::getStatus,roleStatusDto.getStatus());
        update(updateWrapper);
        return ResponseResult.okResult();
    }

    @Override
    @Transactional
    public ResponseResult addRole(AddRoleDto addRoleDto) {
        Role role = BeanCopyUtils.copyBean(addRoleDto, Role.class);
        save(role);

        List<Long> menuIds = addRoleDto.getMenuIds();
        List<RoleMenu> roleMenus = menuIds.stream()
                .map(menuId -> new RoleMenu(role.getId(), menuId)).collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenus);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getRoleById(Long id) {
        Role role = getById(id);
        RoleGetVo roleGetVo = BeanCopyUtils.copyBean(role, RoleGetVo.class);
        return ResponseResult.okResult(roleGetVo);
    }

    @Override
    @Transactional
    public ResponseResult putRole(PutRoleDto putRoleDto) {
        Role role = BeanCopyUtils.copyBean(putRoleDto, Role.class);
        updateById(role);

        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId,role.getId());
        roleMenuService.getBaseMapper().delete(queryWrapper);

        List<Long> menuIds = putRoleDto.getMenuIds();
        List<RoleMenu> roleMenus = menuIds.stream()
                .map(menuId -> new RoleMenu(role.getId(), menuId)).collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenus);
        return ResponseResult.okResult();

    }

    @Override
    public ResponseResult deleteRole(Long id) {
        getBaseMapper().deleteById(id);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult listAllRole() {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Role::getStatus, SystemConstants.NORMAL);
        List<Role> roles = list(queryWrapper);
        return ResponseResult.okResult(roles);
    }


}
