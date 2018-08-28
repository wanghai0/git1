package com.ctcc.xfxt2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctcc.xfxt2.entity.JhkHs;

public interface JhkHsMapper {
    
    int insert(JhkHs record);

    List<JhkHs> selectAll();
    
    List<JhkHs> selectJhkHsByYxdhAndZydh(@Param("yxdh")String yxdh,@Param("zydh") String zydh);
}