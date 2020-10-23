package com.org.Controller;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession sesion ) {

        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            sesion.setAttribute("loginuser",username);

            return "redirect:/main.html";
        } else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
