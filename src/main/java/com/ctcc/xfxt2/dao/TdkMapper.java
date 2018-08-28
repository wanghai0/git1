package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.Tdk;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TdkMapper {
	
    int insert(Tdk record);

    List<Tdk> selectAll();
    
    List<Tdk> selectTdkByKsh(@Param("ksh")String ksh);
    
    List<Tdk> selectTdkBatch(@Param("start")int start,@Param("limit")int limit);
    
    List<Tdk> selectTdkBatch2();
    
}