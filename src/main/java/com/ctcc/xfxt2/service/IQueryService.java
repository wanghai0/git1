/**   
* @Title: IQueryService.java 
* @Package com.ctcc.xfxt2.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月12日 上午8:53:25 
* @version V1.0   
*/
package com.ctcc.xfxt2.service;

import java.util.List;
import java.util.Map;

import com.ctcc.xfxt2.entity.Ksfs;
import com.ctcc.xfxt2.entity.Kssj;
import com.ctcc.xfxt2.entity.LqkBO;
import com.ctcc.xfxt2.entity.Tdk;

/** 
* @ClassName: IQueryService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author whn
* @date 2018年7月12日 上午8:53:25 
*  
*/
public interface IQueryService {

	Ksfs getScore(String stuNum);
	
	LqkBO getLqkBO(String stuNum);
	
	Tdk getReturn(String stuNum);
	
	Kssj getKssj(String stuNum);
	
	Map<String,Object> listWishZyk(String stuNum);
	
	Map<String,Object> listWishZykHs(String stuNum);
	
	Map<String,Object> listWishZzzsZyk(String stuNum);
	
	List<Tdk> findTdkBatch(int start,int limit);
	
	List<Tdk> findTdkBatch2();
	
}
