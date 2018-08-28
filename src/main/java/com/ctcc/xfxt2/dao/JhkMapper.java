package com.ctcc.xfxt2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctcc.xfxt2.entity.Jhk;

public interface JhkMapper {
	
    int insert(Jhk record);

    List<Jhk> selectAll();
    
    List<Jhk> selectJhkByYxdhAndZydh(@Param("yxdh")String yxdh,@Param("zydh") String zydh);
    
}