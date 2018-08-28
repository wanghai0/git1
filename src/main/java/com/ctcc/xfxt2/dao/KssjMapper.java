package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.Kssj;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface KssjMapper {
    int insert(Kssj record);

    List<Kssj> selectAll();
    
    List<Kssj> selectKssjByKSH(@Param("ksh")String ksh);
}