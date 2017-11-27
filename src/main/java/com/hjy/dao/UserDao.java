package com.hjy.dao;

import com.hjy.idao.IUserDao;
import com.hjy.model.User;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/27
 **/
public class UserDao implements IUserDao {

    /**
     * 数据库的链接对象 conn
     * 预编译sql语句对象 psmt
     * 结果集 rs
     */
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public void insert(User user) {
        try {
            conn = DatabaseBean.getConnection();

            String sql = "insert into tb_users(id,username,password) " +
                    "values(users_id.nextval,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getUsername());
            psmt.setString(2, user.getPassword());
            psmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }
    }

    @Override
    public void delete(int id) {
        try {
            conn = DatabaseBean.getConnection();

            String sql = "delete tb_users where id = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,id);
            psmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }

    }

    @Override
    public void updatePassword(User user) {
        try {
            conn = DatabaseBean.getConnection();

            String sql = "update ub_users set password=? where id=?";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getPassword());
            psmt.setInt(2, user.getId());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(psmt,conn);
        }
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select id,username,password from tb_users";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return users;
    }

    @Override
    public User selectUser(String username, String password) {
        User user = null;

        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_users where username=? and password=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return null;
    }

    @Override
    public boolean usernameCheck(String username) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select username from tb_users where username=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            rs = psmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return false;
    }
}
