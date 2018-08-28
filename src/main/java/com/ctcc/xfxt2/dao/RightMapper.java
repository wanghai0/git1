package com.ctcc.xfxt2.dao;

import com.ctcc.xfxt2.entity.Right;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RightMapper {
	
    int insert(Right record);

    List<Right> selectAll();
    
    List<Right> selectRightByUserId(@Param("userId") int userId);
    
}