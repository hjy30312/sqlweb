package com.hjy.servlet;

import com.hjy.iservice.IArticleService;
import com.hjy.iservice.ICategoryService;
import com.hjy.model.Category;
import com.hjy.util.MyFactory;
import com.hjy.util.Pagination;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/12
 **/

@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet{


    //private final IArticleService articleService = (IArticleService) MyFactory.getObject("articleService");
    //private final ICategoryService categoryService = (ICategoryService) MyFactory.getObject("categoryService");


    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            /*
            Pagination pagination = new Pagination();

            pagination.setPageNo(1);

            List<Category> categories = categoryService.findAllCategory();


            req.setAttribute("categories", categories);*/
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
