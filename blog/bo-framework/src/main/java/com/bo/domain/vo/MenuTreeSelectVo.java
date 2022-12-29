package com.bo.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuTreeSelectVo {

    private Long id;
    //菜单名称
    private String label;
    //父菜单ID
    private Long parentId;

    private List<MenuTreeSelectVo> children;
}
