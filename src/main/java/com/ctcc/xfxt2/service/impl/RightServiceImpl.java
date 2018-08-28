/**   
* @Title: RightServiceImpl.java 
* @Package com.ctcc.xfxt2.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月11日 下午3:20:26 
* @version V1.0   
*/
package com.ctcc.xfxt2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctcc.xfxt2.dao.RightMapper;
import com.ctcc.xfxt2.entity.Right;
import com.ctcc.xfxt2.entity.User;
import com.ctcc.xfxt2.service.IRightService;

/** 
* @ClassName: RightServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author whn
* @date 2018年7月11日 下午3:20:26 
*  
*/
@Service("rightServiceImpl")
public class RightServiceImpl implements IRightService {
	
	@Resource
	private RightMapper rightMapper;
	/*
	* Title: findRightByUser
	*Description: 
	* @param user
	* @return 
	* @see com.ctcc.xfxt2.service.IRightService#findRightByUser(com.ctcc.xfxt2.entity.User) 
	*/
	@Override
	public List<Right> listRightByUser(User user) {
		List<Right> rightList=rightMapper.selectRightByUserId(user.getId());
		return rightList;
	}

}
