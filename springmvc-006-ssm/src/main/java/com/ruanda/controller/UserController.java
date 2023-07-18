package com.ruanda.controller;

import com.ruanda.pojo.User;
import com.ruanda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin    //在服务器端支持跨域访问
@RestController //如果此类中全部都是ajax请求，则使用此注解，方法上的@ResponseBody可不写
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public static final int PAGE_SIZE = 5;

    @RequestMapping("/queryUserPage")
    public List<User> queryUserPage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize*(pageNow-1);
        return userService.queryUserPage(startRows);
    }

    @RequestMapping("/selectUserPage")
    @ResponseBody
    public List<User> selectUserPage(String userName,String userSex,Integer page){
        //根据页码计算起始行
        int starRow = 0;
        if (page != null) {
            starRow = (page - 1) * PAGE_SIZE;
        }
        return userService.selectUserPage(userName,userSex,starRow);
    }

    @RequestMapping("/getRowCount")
    public int getRowCount(String userName,String userSex){
        return userService.getRowCount(userName, userSex);
    }

    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }

    @RequestMapping("/createUser")
    public int createUser(User user){
        String userId = System.currentTimeMillis()+"";
        user.setUserId(userId);
        return userService.createUser(user);
    }

    @RequestMapping( "/deleteUserByIdList")
    public Integer deleteUserByIdList(String userIdList) {
        String userIdListSub = userIdList.substring(0, userIdList.length()-1);
        //String[] userIds = userIdList.split(",");
        List userIds = new ArrayList();
        for (String userIdStr: userIdListSub.split(",")){
            userIds.add(userIdStr.trim());
        }
        return userService.deleteUserByIdList(userIds);
    }

    @RequestMapping("/updateUserById")
    public Integer updateUserById(User user, Date date) {
        return userService.updateUserById(user);
    }
}
