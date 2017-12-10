package com.learn.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.CustomException;

@Controller
public class LoginController {

	//登录提交地址，和application-shiro中配置的loginurl一致
    @RequestMapping("login")
    public String login(HttpServletRequest request) throws Exception
    {
        //如果登录失败从request中获取认证异常信息,shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName= (String) request.getAttribute("shiroLoginFailure");

        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                throw new CustomException("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                throw new CustomException("用户名/密码错误");
            } else if("randomCodeError".equals(exceptionClassName)){
                throw new CustomException("验证码错误");
            } else{
                throw new Exception();//最终在异常处理器生成未知错误
            }
        }

        //此方法不处理登录成功，shiro认证成功会自动跳转到上一个路径

        //登录失败返回到login页面
        return "login";
    }
}