package com.kk.user.controller;


import com.kk.user.bean.Message;
import com.kk.user.bean.User;
import com.kk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login/{name}/{pwd}",method = RequestMethod.GET)
    @ResponseBody
    public Message login(@PathVariable("name") String name,@PathVariable("pwd") String pwd){
        User user = userService.findByUsernameAndPassword(name,pwd);
        Message msg = new Message();
        msg.setCode(0);
        if (user!=null){
            msg.setMessage("登陆成功");
        }else {
            msg.setMessage("登陆失败");
        }
        return msg;

    }



    @RequestMapping(value = "/reg/{name}/{pwd}",method = RequestMethod.GET)
    @ResponseBody
    public String reg(@PathVariable("name") String name,@PathVariable("pwd") String pwd){
        User user = new User();
        user.setUsername(name);
        user.setPassword(pwd);
        user.setMail("www.kk.com");
        userService.save(user);
        if (user!=null){
            return "注册成功!";
        }else {
            return "注册失败!";
        }

    }


    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable("id") Integer id){

        return userService.findOne(id);

    }
}
