package com.alsocity.user.controller;

import com.alsocity.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : 小凡
 * @date : create in 2021/7/19 12:54
 * description :
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /***
     * Test
     * @param id id
     * @return name
     */
    @GetMapping("test/{id}")
    public String getNameById(@PathVariable("id") Integer id) {
        return userService.getName(id);
    }
}
