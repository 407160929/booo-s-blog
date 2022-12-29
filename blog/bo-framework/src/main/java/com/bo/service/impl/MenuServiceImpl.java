package com.bo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bo.constants.SystemConstants;
import com.bo.domain.ResponseResult;
import com.bo.domain.entity.Menu;
import com.bo.domain.entity.RoleMenu;
import com.bo.domain.vo.MenuTreeSelectVo;
import com.bo.domain.vo.MenuVo;
import com.bo.domain.vo.PageVo;
import com.bo.domain.vo.roleMenuTreeVo;
import com.bo.enums.AppHttpCodeEnum;
import com.bo.mapper.MenuMapper;
import com.bo.service.MenuService;
import com.bo.service.RoleMenuService;
import com.bo.utils.BeanCopyUtils;
import com.bo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单权限表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2022-12-26 17:34:22
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    RoleMenuService roleMenuService;

    @Override
    public List<String> selectPermsByUserId(Long id) {
        //如果是管理员，返回所有的权限
        if(SecurityUtils.isAdmin()){
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(Menu::getMenuType, SystemConstants.MENU,SystemConstants.BUTTON);
            wrapper.eq(Menu::getStatus,SystemConstants.STATUS_NORMAL);
            List<Menu> menus = list(wrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }
        //否则返回所具有的权限
        return getBaseMapper().selectPermsByUserId(id);
    }

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {
        MenuMapper menuMapper = getBaseMapper();
        List<Menu> menus = null;
        //判断是否是管理员
        if(SecurityUtils.isAdmin()){
            //如果是 获取所有符合要求的Menu
            menus = menuMapper.selectAllRouterMenu();
        }else{
            //否则  获取当前用户所具有的Menu
            menus = menuMapper.selectRouterMenuTreeByUserId(userId);
        }

        //构建tree
        //先找出第一层的菜单  然后去找他们的子菜单设置到children属性中
        List<Menu> menuTree = builderMenuTree(menus,0L);
        return menuTree;
    }

    @Override
    public ResponseResult getMenuList(String status, String menuName) {
        //	需要展示菜单列表，不需要分页。
        //	可以针对菜单名进行模糊查询
        //	也可以针对菜单的状态进行查询。
        //	菜单要按照父菜单id和orderNum进行排序
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(status),Menu::getStatus,status);
        queryWrapper.eq(StringUtils.hasText(menuName),Menu::getMenuName,menuName);
        queryWrapper.orderByAsc(Menu::getParentId,Menu::getOrderNum);
        List<Menu> menuList = list(queryWrapper);
        return ResponseResult.okResult(menuList);
    }

    @Override
    public ResponseResult getMenu(Long id) {
        Menu menu = getById(id);
        MenuVo menuVo = BeanCopyUtils.copyBean(menu, MenuVo.class);
        return ResponseResult.okResult(menuVo);
    }

    @Override
    public ResponseResult deleteMenu(Long id) {
//        Menu menu = getById(id);
//        List<Menu> menus=getBaseMapper().selectAllRouterMenu();
//        List<Menu> children = getChildren(menu, menus);
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getParentId,id);
        List<Menu> children = list(queryWrapper);
        if(!children.isEmpty()){
            return ResponseResult.errorResult(AppHttpCodeEnum.CONTAINS_CHILDREN_MENU);
        }else {
            getBaseMapper().deleteById(id);
            return ResponseResult.okResult();
        }

    }

    @Override
    public ResponseResult treeSelect() {
        //获取树结构，将menu封装到对应的vo中,但是有一个属性改变了对应的名字
        List<Menu> menus = getBaseMapper().selectAllRouterMenu();
        List<MenuTreeSelectVo> menuTreeSelectVos = menus.stream()
                .map(menu -> BeanCopyUtils.copyBean(menu, MenuTreeSelectVo.class).setLabel(menu.getMenuName()))
                .collect(Collectors.toList());
        //构建tree
        //先找出第一层的菜单  然后去找他们的子菜单设置到children属性中
        List<MenuTreeSelectVo> menuSelectTree = builderMenuSelectTree(menuTreeSelectVos,0L);
        return ResponseResult.okResult(menuSelectTree);

    }

    @Override
    public ResponseResult roleMenuTreeSelect(Long id) {
        roleMenuTreeVo roleMenuTreeVo=new roleMenuTreeVo();

        List<Menu> menus = getBaseMapper().selectAllRouterMenu();
        List<MenuTreeSelectVo> menuTreeSelectVos = menus.stream()
                .map(menu -> BeanCopyUtils.copyBean(menu, MenuTreeSelectVo.class).setLabel(menu.getMenuName()))
                .collect(Collectors.toList());
        //构建tree
        //先找出第一层的菜单  然后去找他们的子菜单设置到children属性中
        List<MenuTreeSelectVo> menuSelectTree = builderMenuSelectTree(menuTreeSelectVos,0L);
        roleMenuTreeVo.setMenus(menuSelectTree);

        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId,id);
        List<RoleMenu> roleMenus = roleMenuService.list(queryWrapper);
        List<Long> list = roleMenus.stream().map(roleMenu -> roleMenu.getMenuId()).collect(Collectors.toList());
        roleMenuTreeVo.setCheckedKeys(list);

        return ResponseResult.okResult(roleMenuTreeVo);
    }

    private List<MenuTreeSelectVo> builderMenuSelectTree(List<MenuTreeSelectVo> menuTreeSelectVos, Long parentId) {
        List<MenuTreeSelectVo> menuSelectTree = menuTreeSelectVos.stream()
                .filter(menuTreeSelectVo -> menuTreeSelectVo.getParentId().equals(parentId))
                .map(menuTreeSelectVo -> menuTreeSelectVo.setChildren(getSelectChildren(menuTreeSelectVo, menuTreeSelectVos)))
                .collect(Collectors.toList());
        return menuSelectTree;
    }

    private List<MenuTreeSelectVo> getSelectChildren(MenuTreeSelectVo menuTreeSelectVo, List<MenuTreeSelectVo> menuTreeSelectVos) {
        List<MenuTreeSelectVo> childrenList = menuTreeSelectVos.stream()
                .filter(m -> m.getParentId().equals(menuTreeSelectVo.getId()))
                .map(m->m.setChildren(getSelectChildren(m,menuTreeSelectVos)))
                .collect(Collectors.toList());
        return childrenList;
    }


    private List<Menu> builderMenuTree(List<Menu> menus, Long parentId) {
        List<Menu> menuTree = menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .map(menu -> menu.setChildren(getChildren(menu, menus)))
                .collect(Collectors.toList());
        return menuTree;
    }

    /**
     * 获取存入参数的 子Menu集合
     * @param menu
     * @param menus
     * @return
     */
    private List<Menu> getChildren(Menu menu, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                .filter(m -> m.getParentId().equals(menu.getId()))
                .map(m->m.setChildren(getChildren(m,menus)))
                .collect(Collectors.toList());
        return childrenList;
    }
}
