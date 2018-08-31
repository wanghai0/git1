package com.ctcc.xfxt2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ctcc.xfxt2.entity.Right;
import com.ctcc.xfxt2.entity.User;
import com.ctcc.xfxt2.service.impl.RightServiceImpl;
import com.ctcc.xfxt2.service.impl.UserServiceImpl;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RightServiceImpl rightServiceImpl;

    // 生成验证码
    @RequestMapping("/generateVerficationCode")
    @ResponseBody
    public void generateVerficationCode(HttpServletRequest request, HttpServletResponse response) {
        String validationCode = "";// 验证码
        int codeLength = 4;// 验证码的长度
        char[] selectChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };// 所有候选组成验证码的字符，也可以用中文
        for (int i = 0; i < codeLength; i++) {
            int charIndex = (int) (Math.floor(Math.random() * 36));
            validationCode += selectChar[charIndex];
        }
        if ("".equals(validationCode)) {
            return;
        }
        try {
            response.getWriter().print(validationCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        if (request.getParameter("user_account") == null || request.getParameter("user_account").length() == 0) {
            return "error";
        }
        String account = request.getParameter("user_account").trim();
        if (request.getParameter("user_password") == null || request.getParameter("user_password").length() == 0) {
            return "error";
        }
        String password = request.getParameter("user_password").trim();
        User user = userServiceImpl.getUser(account, password);
        if (user == null) {
            return "error";
        }
        request.getSession().setAttribute("user", user);
        return "smsLogin";
    }

    @RequestMapping("/sendSMSCode")
    @ResponseBody
    public void sendSMSCode(HttpServletRequest request, HttpServletResponse response) {
       User user = (User) request.getSession().getAttribute("user");
       if(user==null){
           return;
       }
       String mobile = user.getMobile().trim();
       String smsCode = userServiceImpl.sendSMSCode(mobile);
       request.getSession().setAttribute("smsCode", smsCode);
       System.out.println(smsCode);
    }

    @RequestMapping("/checkUserSMSCode")
    @ResponseBody
    public void checkUserSMSCode(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("user_SMSCode") == null) {
            return;
        }
        String user_SMSCode = request.getParameter("user_SMSCode").trim();
        if (request.getSession().getAttribute("smsCode") == null) {
            return;
        }
        String sessionSMSCode = request.getSession().getAttribute("smsCode").toString();
        try {
            if (sessionSMSCode.equals(user_SMSCode)) {
                response.getWriter().print("true");
            } else {
                response.getWriter().print("false");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/SMSLogin")
    public String SMSLogin(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryScore";
    }

    @RequestMapping("/queryMenu")
    @ResponseBody
    public void menu(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("user") == null) {
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        List<Right> rightList = rightServiceImpl.listRightByUser(user);
        if (rightList == null || rightList.size() == 0) {
            return;
        }
        String jsonStrRightList = JSONObject.toJSONString(rightList);
        try {
            response.getWriter().print(jsonStrRightList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/toForgetPassword")
    public String toForgetPassword() {
        return "forgetPassword";
    }

    @RequestMapping("/resetPwd_sendSMSCode")
    @ResponseBody
    public void resetPwd_sendSMSCode(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("user_account") == null) {
            return;
        }
        String account = request.getParameter("user_account").trim();
        User user = userServiceImpl.getUserByAccount(account);
        if (user == null) {
            return;
        }
        String userAccount=user.getLoginName();
        request.getSession().setAttribute("userAccount", userAccount);
        String mobile = user.getMobile().trim();
        if(mobile==null||mobile==""){
            return;
        }
        String smsCode = userServiceImpl.sendSMSCode(mobile);
        request.getSession().setAttribute("smsCode", smsCode);
        System.out.println(smsCode);
        try {
            response.getWriter().print(smsCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping("/resetPassword")
    @ResponseBody
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) {
        if(request.getSession().getAttribute("userAccount")==null){
            return;
        }
        String account = request.getSession().getAttribute("userAccount").toString();
        if (request.getParameter("password") == null) {
            return;
        }
        String password = request.getParameter("password").trim();
        int res = userServiceImpl.updatePassword(account, password);
        try {
            response.getWriter().print(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/toQueryScore")
    public String toMain(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryScore";
    }

    @RequestMapping("/toQueryEnroll")
    public String toQueryEnroll(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryEnroll";
    }

    @RequestMapping("/toQueryReturn")
    public String toQueryTdk(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryReturn";
    }

    @RequestMapping("/toQueryWish")
    public String toQueryWish(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryWish";
    }

    @RequestMapping("/toQueryOfficer")
    public String toQueryOfficer(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryOfficer";
    }

    @RequestMapping("/toQueryIndependent")
    public String toQueryIndependent(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryIndependent";
    }

    @RequestMapping("/toUpdateDatebase")
    public String toUpdateDatebase(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "updateDatebase";
    }

    @RequestMapping("/toQueryBatch")
    public String toQueryBatch(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "error";
        }
        return "queryBatch";
    }
}
