/**   
* @Title: IUserService.java 
* @Package com.ctcc.xfxt2.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月2日 上午8:57:56 
* @version V1.0   
*/
package com.ctcc.xfxt2.service;

import com.ctcc.xfxt2.entity.User;

/**
 * @ClassName: IUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author whn
 * @date 2018年7月2日 上午8:57:56
 * 
 */
public interface IUserService {

    User getUser(String account, String password);

    User getUserByAccount(String account);

    String sendSMSValidationCode(String phone);

    int updatePassword(String account, String password);

}
