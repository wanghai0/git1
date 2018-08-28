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

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		if (request.getParameter("acct") == null || request.getParameter("acct").length() == 0) {
			return "error";
		}
		String account = request.getParameter("acct").trim();
		if (request.getParameter("pwd") == null || request.getParameter("pwd").length() == 0) {
			return "error";
		}
		String password = request.getParameter("pwd").trim();
		User user = userServiceImpl.getUser(account, password);
		if (user == null) {
			return "error";
		}
		request.getSession().setAttribute("user", user);
		return "smsLogin";
	}

	@RequestMapping("/sendSMSValidationCode")
	@ResponseBody
	public void sendSMSValidationCode(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("mobile") == null || request.getParameter("mobile").length() == 0) {
			return;
		}
		String mobile = request.getParameter("mobile").trim();
		String validationCode = userServiceImpl.sendSMSValidationCode(mobile);
		request.getSession().setAttribute("sessionValidationCode", validationCode);
		System.out.println(validationCode);
	}
	
	@RequestMapping("/checkValidationCode")
	@ResponseBody
	public void checkValidationCode(HttpServletRequest request,HttpServletResponse response){
	    if(request.getParameter("userValidationCode")==null){
	        return;
	    }
		String userValidationCode=request.getParameter("userValidationCode").trim();
		if(request.getSession().getAttribute("sessionValidationCode")==null){
		    return;
		}
		String sessionValidationCode=request.getSession().getAttribute("sessionValidationCode").toString();
		try{
			if(!sessionValidationCode.equals(userValidationCode)){
			    System.out.println("false");
				response.getWriter().print("false");
			}else{
			    System.out.println("true");
				response.getWriter().print("true");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/SMSLogin")
	public String SMSLogin(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")==null){
			return "error";
		}
		return "queryScore";
	}
	
	@RequestMapping("/queryMenu")
	@ResponseBody
	public void menu(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("user")==null){
			return;
		}
		User user = (User) request.getSession().getAttribute("user");
		List<Right> rightList = rightServiceImpl.listRightByUser(user);
		if(rightList==null||rightList.size()==0){
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

	@RequestMapping("/findUserMobileByAccount")
	@ResponseBody
	public void findUserByAccount(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("account") == null) {
			return;
		}
		String account = request.getParameter("account").trim();
		User user = userServiceImpl.getUserByAccount(account);
		if(user==null){
			return;
		}
		String mobile=user.getMobile().trim();
		if(mobile==null||mobile.length()==0){
			return;
		}
		try {
			response.getWriter().print(mobile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/resetPassword")
	@ResponseBody
	public void resetPassword(HttpServletRequest request,HttpServletResponse response) {
	    System.out.println("account:"+request.getParameter("account"));
	    System.out.println("password:"+request.getParameter("password"));
		if (request.getParameter("account") == null || request.getParameter("password") == null) {
			return;
		}
		String account = request.getParameter("account").trim();
		String password = request.getParameter("password").trim();
		int res=userServiceImpl.updatePassword(account, password);
		try {
            response.getWriter().print(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@RequestMapping("/toQueryScore")
	public String toMain(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")==null){
			return "error";
		}
		return "queryScore";
	}

	@RequestMapping("/toQueryEnroll")
	public String toQueryEnroll(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")==null){
			return "error";
		}
		return "queryEnroll";
	}

	@RequestMapping("/toQueryReturn")
	public String toQueryTdk(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")==null){
			return "error";
		}
		return "queryReturn";
	}

	@RequestMapping("/toQueryWish")
	public String toQueryWish(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")==null){
			return "error";
		}
		return "queryWish";
	}
	
	@RequestMapping("/toQueryOfficer")
    public String toQueryOfficer(HttpServletRequest request) {
        if(request.getSession().getAttribute("user")==null){
            return "error";
        }
        return "queryOfficer";
    }
	
	@RequestMapping("/toQueryIndependent")
	public String toQueryIndependent(HttpServletRequest request){
	    if(request.getSession().getAttribute("user")==null){
            return "error";
        }
	    return "queryIndependent";
	}
	
	@RequestMapping("/toUpdateDatebase")
    public String toUpdateDatebase(HttpServletRequest request){
        if(request.getSession().getAttribute("user")==null){
            return "error";
        }
        return "updateDatebase";
    }
	
	@RequestMapping("/toQueryBatch")
    public String toQueryBatch(HttpServletRequest request){
        if(request.getSession().getAttribute("user")==null){
            return "error";
        }
        return "queryBatch";
    }
}
