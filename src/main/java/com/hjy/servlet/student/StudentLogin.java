package com.hjy.servlet.student;

import com.hjy.iservice.IStudentService;
import com.hjy.model.Student;

import com.hjy.util.MD5Util;
import com.hjy.util.MyFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 学生登录Servlet,对输入的密码加密与数据库中的密码进行比较
 * 成功重定向到/Student/Index
 * 否则重定向会到/Student/Login session带回失败信息message
 * @author hjy
 * @create 2017/11/27
 **/
@WebServlet(name = "StudentLogin", urlPatterns = {"/Student/StudentLogin"})
public class StudentLogin extends HttpServlet{

    private final IStudentService studentService =
            (IStudentService) MyFactory.getObject("studentService");

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
        throws ServletException,IOException {

        try {
            String sno = request.getParameter("sno").trim();
            String password = MD5Util.md5Encode( request.getParameter("password").trim());
            Student stu = studentService.findStudentBySnoPassword(sno,password);
            //没有会话则创建会话并返回  等同getSession(),   getSession(false)没有会话则返回null
            HttpSession session = request.getSession(true);

            if (stu != null) { //找到学生
                session.setAttribute("stu",stu);
                //重定向 不共享request
                response.sendRedirect(request.getContextPath()
                        + "/Student/Index");
            } else { //没有找到用户，可能用户名或密码错误！
                session.setAttribute("message", "学号或密码错误");
                response.sendRedirect(request.getContextPath()
                        + "/Student/Login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
