package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.Lqk;
import java.util.List;

public interface LqkMapper {
    int insert(Lqk record);

    List<Lqk> selectAll();
}