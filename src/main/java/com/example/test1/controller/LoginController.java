package com.example.test1.controller;
import com.example.test1.entity.User;
import com.example.test1.util.Result;
import com.example.test1.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.test1.service.ServiceImpl.UserServiceImpl;

import javax.servlet.http.HttpSession;

@SuppressWarnings({"all"})
@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/login/check")
    @ResponseBody
    public Result check(@RequestParam String number, @RequestParam String password,HttpSession session) {
        String msg = userServiceImpl.loginService(number, password);
        if (("SUCCESS").equals(msg)) {
            User user = new User();
            user.setNumber(number);
            user.setPassword(password);
            session.setAttribute("user", user);
            return ResultUtil.success("登录成功");
        } else {
            return ResultUtil.error(msg);
        }
    }
/*
    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String msg = userServiceImpl.registerService(user);
        if (("SUCCESS").equals(msg)) {
            return ResultUtil.success("注册成功");
        } else {
            return ResultUtil.error(msg);
        }
    }
*/
}
