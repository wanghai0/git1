package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.ZykZq;
import java.util.List;

public interface ZykZqMapper {
    int insert(ZykZq record);

    List<ZykZq> selectAll();
}