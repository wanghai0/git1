package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.Role;
import java.util.List;

public interface RoleMapper {
    int insert(Role record);

    List<Role> selectAll();
}