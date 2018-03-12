package cn.likegirl.controller;

import cn.likegirl.entities.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class AnnotationController {
    @RequiresRoles("admin")
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello1() {
        //SecurityUtils.getSubject().checkRole("admin");
        return "success";
    }

    @RequestMapping(value = "/commonality",method = RequestMethod.GET)
    @RequiresPermissions("user:commonality")
    public String Commonality() {
        //SecurityUtils.getSubject().checkRole("admin");
        return "success";
    }

    @RequiresRoles("user")
    @RequestMapping("/hello2")
    public String hello2() {
        return "success";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        subject.login(token);
        return "list";
    }

}
