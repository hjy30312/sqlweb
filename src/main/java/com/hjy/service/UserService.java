package com.hjy.service;

import com.hjy.iservice.IUserService;
import com.hjy.util.MyFactory;

import javax.xml.registry.infomodel.User;
import java.util.List;

/**
 * 用户管理业务逻辑处理层实现类
 * @author hjy
 * @create 2017/11/27
 **/
public class UserService implements IUserService {

    private final IUserService userService=
            (IUserService) MyFactory.getObject("userService");

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void updateUserPassword(User user) {

    }

    @Override
    public List<User> findAlUsers() {
        return null;
    }

    @Override
    public User findUser(String username, String password) {
        return null;
    }

    @Override
    public boolean usernameExist(String username) {
        return false;
    }
}
