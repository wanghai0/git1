package com.ctcc.xfxt2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctcc.xfxt2.entity.Yxdh;

public interface YxdhMapper {
    int insert(Yxdh record);

    List<Yxdh> selectAll();
    
    List<Yxdh> selectYxdhByYxdh(@Param("yxdh")String yxdh);
}