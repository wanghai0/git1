/**   
* @Title: IRightService.java 
* @Package com.ctcc.xfxt2.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月11日 下午3:15:16 
* @version V1.0   
*/
package com.ctcc.xfxt2.service;

import java.util.List;

import com.ctcc.xfxt2.entity.Right;
import com.ctcc.xfxt2.entity.User;

/** 
* @ClassName: IRightService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author whn
* @date 2018年7月11日 下午3:15:16 
*  
*/
public interface IRightService {

	List<Right> listRightByUser(User user);
}
