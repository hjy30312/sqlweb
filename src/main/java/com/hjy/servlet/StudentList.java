package com.hjy.servlet;

import com.hjy.iservice.IStudentService;
import com.hjy.model.Student;
import com.hjy.util.MyFactory;
import com.hjy.util.Pagination;
import com.hjy.util.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/15
 **/
@WebServlet(name = "StudentList", urlPatterns = {"/StudentList"})
public class StudentList extends HttpServlet{
    private final IStudentService studentService =
            (IStudentService) MyFactory.getObject("studentService");


    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) {
        String style = request.getParameter("style");
        String sno = request.getParameter("sno");
        String pageNo = request.getParameter("pageNo");
        int page = 1;

        if (pageNo != null) {
            page = Integer.parseInt(pageNo);
        }
        if (style == null) {
            style = "table";
        }

        Pagination pagination = new Pagination();
        pagination.setPageNo(page);

        //传递分页信息，同时将模糊查询条件信息传递过去
        if(sno != null && !"".equals(sno)) {
            pagination.setUrl("StringList?style=" + style + "&sno=" + sno);
        } else {
            pagination.setUrl("StudentList?style=" + style);
        }
        //一页9个人
        if (style.equals("frame")) {
            pagination.setPageSize(9);
        }
        List<Student> students;


            try {
                if (sno != null && !"".equals(sno)) {
                    students = studentService.findStudentsBySno(sno, pagination);
                } else {
                    students = studentService.findStudents(pagination);
                }
                // 将学生记录信息转发到下一页
                request.setAttribute("students", students);
                // 将分页信息转发到下一页
                request.setAttribute("pagination", pagination);

                if ("frame".equals(style)) {
                    request.getRequestDispatcher("WEB-INF/student_frame.jsp").forward(request, response);
                }
            }  catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
