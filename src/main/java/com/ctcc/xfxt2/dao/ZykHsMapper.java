package com.ctcc.xfxt2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctcc.xfxt2.entity.ZykHs;

public interface ZykHsMapper {
    
    int insert(ZykHs record);

    List<ZykHs> selectAll();
    
    List<ZykHs> selectZykHsByKSH(@Param("ksh") String stuNum);
    
}