package com.bo.domain.vo;


import com.bo.domain.entity.Role;
import com.bo.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetVo {
    private List<Long> roleIds;

    private List<Role> roles;

    private UserPutGetVo user;
}
