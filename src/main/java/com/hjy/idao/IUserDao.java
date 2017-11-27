package com.hjy.idao;


import com.hjy.model.User;

import java.util.List;

/**
 * @author hjy
 * @create 2017/11/27
 **/
public interface IUserDao {
    public void insert(User user);
    public void delete(int id);
    public void updatePassword(User user);
    public List<User> selectAllUsers();
    public User selectUser(String username, String password);
    public boolean usernameCheck(String username);
}
