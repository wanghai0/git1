package com.ctcc.xfxt2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctcc.xfxt2.dao.UserMapper;
import com.ctcc.xfxt2.entity.User;
import com.ctcc.xfxt2.service.IUserService;
import com.ctcc.xfxt2.util.SmsRun;
import com.ctcc.xfxt2.util.RandomCode;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String account, String password) {
        List<User> userList = userMapper.selectUser(account, password);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User getUserByAccount(String account) {
        List<User> userList = userMapper.selectUserByAccount(account);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public String sendSMSValidationCode(String mobile) {
        String validationCode = RandomCode.randomCheckcode(6);
        try {
            SmsRun sms = new SmsRun(mobile, validationCode);
            Thread t1 = new Thread(sms);
            t1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validationCode;
    }

    @Override
    public int updatePassword(String account, String password) {
       int res =userMapper.updatePassword(account, password);
       return res;
    }

}
