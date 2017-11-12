package com.hjy.util;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author hjy
 * @create 2017/11/12
 **/
public class StartServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            InputStream inputStream = StartServlet.class.getResourceAsStream("jdbc.properties");
            JdbcUtils.sqlProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
