package com.bo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutUserDto {
    private Long id;
    //用户名
    private String userName;
    //昵称
    private String nickName;
    //邮箱
    private String email;
    //性别
    private String sex;
    //手机号
    private String phonenumber;
    //账号状态（0正常 1停用）
    private String status;
    //角色列表
    private List<Long> roleIds;
}
