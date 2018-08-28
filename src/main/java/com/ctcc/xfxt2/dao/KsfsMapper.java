package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.Ksfs;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface KsfsMapper {
	
    int insert(Ksfs record);

    List<Ksfs> selectAll();
    
    List<Ksfs> selectScoreByKSH(@Param("ksh") String ksh);
    
    List<Ksfs> selectScoreByZKZH(@Param("zkzh") String zkzh);
}