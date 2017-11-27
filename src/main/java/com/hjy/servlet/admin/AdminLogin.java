package com.hjy.servlet.admin;

import com.hjy.iservice.IStudentService;
import com.hjy.iservice.IUserService;
import com.hjy.model.Student;
import com.hjy.util.MD5Util;
import com.hjy.util.MyFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hjy
 * @create 2017/11/27
 **/
public class AdminLogin extends HttpServlet{

    private final IUserService userService =
            (IUserService) MyFactory.getObject("userService");

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        String username = request.getParameter("username").trim();
        String password = MD5Util.md5Encode(request.getParameter("password").trim());
//        Student student = userService
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
