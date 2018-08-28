/**   
* @Title: QueryController.java 
* @Package com.ctcc.xfxt2.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author whn
* @date 2018年7月12日 上午8:52:38 
* @version V1.0   
*/
package com.ctcc.xfxt2.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ctcc.xfxt2.entity.Ksfs;
import com.ctcc.xfxt2.entity.Kssj;
import com.ctcc.xfxt2.entity.LqkBO;
import com.ctcc.xfxt2.entity.Tdk;
import com.ctcc.xfxt2.service.IQueryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: QueryController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author whn
 * @date 2018年7月12日 上午8:52:38
 * 
 */
@Controller
public class QueryController {

    @Autowired
    private IQueryService queryService;

    @RequestMapping("/queryScore")
    @ResponseBody
    public void queryScore(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("stuNum") == null || "".equals(request.getParameter("stuNum"))) {
            return;
        }
        String stuNum = request.getParameter("stuNum").trim();
        Ksfs ksfs = queryService.getScore(stuNum);
        if (ksfs == null) {
            return;
        }
        String jsonKsfs = JSONObject.toJSONString(ksfs);
        try {
            response.getWriter().print(jsonKsfs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryEnroll")
    @ResponseBody
    public void queryEnroll(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("stuNum") == null || "".equals(request.getParameter("stuNum"))) {
            return;
        }
        String stuNum = request.getParameter("stuNum").trim();
        LqkBO lqkBo = queryService.getLqkBO(stuNum);
        if (lqkBo == null) {
            return;
        }
        String jsonLqkBo = JSONObject.toJSONString(lqkBo);
        try {
            response.getWriter().print(jsonLqkBo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryReturn")
    @ResponseBody
    public void queryReturn(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("stuNum") == null || "".equals(request.getParameter("stuNum"))) {
            return;
        }
        String stuNum = request.getParameter("stuNum").trim();
        Tdk tdk = queryService.getReturn(stuNum);
        if (tdk == null) {
            return;
        }
        String jsonTdk = JSONObject.toJSONString(tdk);
        try {
            response.getWriter().print(jsonTdk);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryWish")
    @ResponseBody
    public void queryWish(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("stuNum") == null || "".equals(request.getParameter("stuNum"))) {
            return;
        }
        String stuNum = request.getParameter("stuNum");
        Kssj kssj = queryService.getKssj(stuNum);
        if (kssj == null) {
            return;
        }
        Map<String, Object> zykListMap = queryService.listWishZyk(stuNum);
        if (zykListMap == null || zykListMap.size() == 0) {
            return;
        }
        Map<String, Object> wishMap = new HashMap<String, Object>();
        wishMap.put("kssj", kssj);
        wishMap.put("zykListMap", zykListMap);
        String jsonWishMap = JSONObject.toJSONString(wishMap);
        System.out.println(jsonWishMap);
        try {
            response.getWriter().print(jsonWishMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryOfficerWish")
    @ResponseBody
    public void queryOfficerWish(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("stuNum") == null || "".equals(request.getParameter("stuNum"))) {
            return;
        }
        String stuNum = request.getParameter("stuNum");
        Kssj kssj = queryService.getKssj(stuNum);
        if (kssj == null) {
            return;
        }
        Map<String, Object> zykHsListMap = queryService.listWishZykHs(stuNum);
        if (zykHsListMap == null || zykHsListMap.size() == 0) {
            return;
        }
        Map<String, Object> wishMap = new HashMap<String, Object>();
        wishMap.put("kssj", kssj);
        wishMap.put("zykHsListMap", zykHsListMap);
        String jsonWishMap = JSONObject.toJSONString(wishMap);
        System.out.println(jsonWishMap);
        try {
            response.getWriter().print(jsonWishMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryIndependent")
    @ResponseBody
    public void queryIndependent(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("stuNum") == null || "".equals(request.getParameter("stuNum"))) {
            return;
        }
        String stuNum = request.getParameter("stuNum");
        Kssj kssj = queryService.getKssj(stuNum);
        if (kssj == null) {
            return;
        }
        Map<String, Object> zzzsZykListMap = queryService.listWishZzzsZyk(stuNum);
        if (zzzsZykListMap == null || zzzsZykListMap.size() == 0) {
            return;
        }
        Map<String, Object> wishMap = new HashMap<String, Object>();
        wishMap.put("kssj", kssj);
        wishMap.put("zzzsZykListMap", zzzsZykListMap);
        String jsonWishMap = JSONObject.toJSONString(wishMap);
        System.out.println(jsonWishMap);
        try {
            response.getWriter().print(jsonWishMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryBatch")
    @ResponseBody
    public void queryBatch(HttpServletRequest request, HttpServletResponse response) {
        if(request.getParameter("pageNum") == null){
            return;
        }
        int pageNum=Integer.parseInt(request.getParameter("pageNum"));
        PageHelper.startPage(pageNum, 10);
        List<Tdk> tdkList=queryService.findTdkBatch2();
        PageInfo pageInfo=new PageInfo(tdkList);
        String jsonPageInfo = JSONObject.toJSONString(pageInfo);
        System.out.println(jsonPageInfo);
        try {
            response.getWriter().print(jsonPageInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping("/queryBatch2")
    @ResponseBody
    public void queryBatch2(HttpServletRequest request,HttpServletResponse response){
        PageHelper.startPage(1, 10);
        List<Tdk> tdkList=queryService.findTdkBatch2();
        PageInfo page=new PageInfo(tdkList);
        int pageNum=page.getPageNum();
        int pageSize=page.getPageSize();
        long total=page.getTotal();
        System.out.println("pageNum:"+pageNum);
        System.out.println("pageSize:"+pageSize);
        System.out.println("total:"+total);
        String jsonPageList = JSONObject.toJSONString(page);
        System.out.println(jsonPageList);
        try {
            response.getWriter().print(jsonPageList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
