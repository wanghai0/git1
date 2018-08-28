/**   
* @Title: LqkBoMapper.java 
* @Package com.ctcc.xfxt2.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月16日 上午10:09:21 
* @version V1.0   
*/
package com.ctcc.xfxt2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctcc.xfxt2.entity.LqkBO;

/** 
* @ClassName: LqkBoMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author whn
* @date 2018年7月16日 上午10:09:21 
*  
*/
public interface LqkBOMapper {

	List<LqkBO> selectLqkBoByKsh(@Param("ksh")String ksh);
}
