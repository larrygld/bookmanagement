package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.Book;
import com.southwind.springboottest.entity.User;
import com.southwind.springboottest.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author larry
 * @date 2020/8/6 9:27
 * @creed: Talk is cheap, show me the code!
 */
@Controller
public class UserCon {

    @Autowired
    UserDao userDao;

    @PostMapping("/updateuser")
    @ResponseBody
    public String UpdateUser(@RequestBody User user){
        User result = userDao.save(user);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @PostMapping("/findbyname")
    @ResponseBody
    public User findByName(@RequestParam("username") String name){
        return userDao.findByUsername(name);
    }

    @PostMapping("/login")
    @ResponseBody
    public Map login(@RequestParam("username") String name, @RequestParam("password") String pwd){
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userDao.findByUsernameAndPassword(name, pwd);
        if(user == null){
            map.put("status", "error");

        }else {
            map.put("status", "success");
            map.put("name", name);
            map.put("url", user.getImg());
        }

        return map;
    }

}
