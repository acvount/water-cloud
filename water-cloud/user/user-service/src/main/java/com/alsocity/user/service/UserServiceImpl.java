package com.alsocity.user.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author : 小凡
 * @date : create in 2021/7/19 14:27
 * description :
 **/
@DubboService
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String getName(int id) {
        return String.format("ID : %s Name %s", id ^ 334, id * 12);
    }
}
