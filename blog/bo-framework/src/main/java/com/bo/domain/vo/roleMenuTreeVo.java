package com.bo.domain.vo;

import com.bo.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class roleMenuTreeVo {
    private List<MenuTreeSelectVo> menus;

    private List<Long> checkedKeys;
}
