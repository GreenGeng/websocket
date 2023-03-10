package com.learnbyheart.demo1.web;

import com.learnbyheart.demo1.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @RequestMapping("/toLogin")
    public Result login(@RequestParam("user") String name,
            @RequestParam("pwd") String pwd,
                        HttpSession httpSession){
        Result result = new Result();
        if("gy".equals(name) && "123".equals(pwd)){
            result.setFlag(true);
            httpSession.setAttribute("user",name);
        }
        else if("hkn".equals(name) && "123".equals(pwd)){
            result.setFlag(true);
            httpSession.setAttribute("user",name);
        }
        else if("lmg".equals(name) && "123".equals(pwd)){
            result.setFlag(true);
            httpSession.setAttribute("user",name);
        }
        else{
            result.setFlag(false);
            result.setMsg("登陆失败");
        }

        return result;
    }

    @RequestMapping("/getUsername")
    public String getUserName(HttpSession session){

        return (String) session.getAttribute("user");
    }
}
