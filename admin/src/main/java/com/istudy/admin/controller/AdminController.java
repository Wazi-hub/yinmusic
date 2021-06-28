package com.istudy.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.istudy.admin.service.impl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@Controller
@CrossOrigin(allowCredentials="true")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    //    判断是否登录成功
     @ApiOperation(value = "/admin/login/status",notes = "登录验证")
     @ApiImplicitParams({
             @ApiImplicitParam(paramType = "query",name="name",value = "用户名",dataType = "str"),
             @ApiImplicitParam(paramType = "query",name="password",value = "密码",dataType = "str")
     })
    @ResponseBody
    @RequestMapping(value = "/admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest req, HttpSession session){
        JSONObject jsonObject = new JSONObject();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        boolean res = adminService.veritypasswd(name, password);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "登录成功");
            session.setAttribute("name", name);
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }

    }
}
