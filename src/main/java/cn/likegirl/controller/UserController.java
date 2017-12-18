package cn.likegirl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HD on 2017/8/1.
 */
@Controller
@RequestMapping("/userApp")
public class UserController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String home(){
        return "list";
    }
}
