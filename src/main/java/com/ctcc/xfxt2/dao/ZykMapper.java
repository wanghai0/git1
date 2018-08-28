package com.ctcc.xfxt2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctcc.xfxt2.entity.Zyk;

public interface ZykMapper {
    int insert(Zyk record);

    List<Zyk> selectAll();
    
    List<Zyk> selectZykByKSH(@Param("ksh")String ksh);
}