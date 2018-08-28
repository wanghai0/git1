package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.Zzzszyk;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ZzzszykMapper {
    
    int insert(Zzzszyk record);

    List<Zzzszyk> selectAll();
    
    List<Zzzszyk> selectZzzsZykByKSH(@Param("ksh")String stuNum);
}