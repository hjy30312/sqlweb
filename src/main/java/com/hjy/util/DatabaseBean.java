package com.hjy.util;

import oracle.jdbc.pool.OracleDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hjy
 * @create 2017/11/12
 **/
public class DatabaseBean {
    public static Properties sqlProperties = new Properties();
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Connection connection = null;
    private static OracleDataSource ds= null;

    /**
     * 静态加载
     */
    static {
        try {
            //加载配置文件
            InputStream in = DatabaseBean.class.getResourceAsStream("/jdbc.properties");
            Properties prop = new Properties();
            prop.load(in);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

            //创建数据源
            ds = new OracleDataSource();

            ds.setURL(url);

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据源中获取数据库连接
     * @return 
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection(user,password);
    }

    /**
     * 释放资源
     * 释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，
     * 存储查询结果的ResultSet对象
     * @param rs
     * @param psmt
     * @param conn
     */
    public static void release(ResultSet rs, PreparedStatement psmt,
                               Connection conn) {
        try {
            //关闭存储查询结果的ResultSet对象
            if (rs != null) {
                rs.close();
            }
            //关闭负责执行SQL命令的Statement对象
            if (psmt != null) {
                psmt.close();
            }
            //将Connection连接对象还给数据库连接池
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DatabaseBean.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}