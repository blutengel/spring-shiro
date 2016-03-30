package com.demo.controller;

import com.demo.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by zb1209144 on 2016/3/23.
 */
@Controller
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session) {

        logger.warn("login");
        logger.warn(user.toString());

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());


        try {
            subject.login(token);
            session.setAttribute("user", user.getUsername());
            return "redirect:home.jsp";
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return "forward:login.jsp";
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:index.jsp";
    }
}
