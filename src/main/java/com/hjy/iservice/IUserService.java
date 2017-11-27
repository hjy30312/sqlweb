package com.hjy.iservice;

import javax.xml.registry.infomodel.User;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/27
 **/
public interface IUserService {
    public void addUser(User user);

    /**
     * 通过id删除
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 更新密码
     * @param user
     */
    public void updateUserPassword(User user);

    /**
     * 找到所有User的信息
     * @return
     */
    public List<User> findAlUsers();

    /**
     * 通过用户名和密码找到User并返回
     * @param username
     * @param password
     * @return
     */
    public User findUser(String username, String password);

    /**
     * 查看是否有这用户名
     * @param username
     * @return
     */
    public boolean usernameExist(String username);
}
