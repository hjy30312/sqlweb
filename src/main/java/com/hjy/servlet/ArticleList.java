package com.hjy.servlet;

import com.hjy.iservice.IArticleService;
import com.hjy.model.Article;
import com.hjy.util.MyFactory;
import com.hjy.util.Pagination;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/14
 **/
public class ArticleList extends HttpServlet{

    private final IArticleService articleService = (IArticleService) MyFactory.getObject("articleService");


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String p = request.getParameter("pageNo");
        String cid = request.getParameter("cid");
        int page = 1;
        if (p != null) {
            page = Integer.parseInt(p);
        }
        Pagination pagination = new Pagination();
        pagination.setPageNo(page);
        //传递分页信息，同时将模糊查询条件信息传递过去
        List<Article> articles;
        //List<Category> categories;
        StringBuilder sb = new StringBuilder();
        sb.append("ArticleList?");
        try {
           // categories = categoryService.findAllCategory();
            if (title != null && !"".equals(title)) {
                articles = articleService.findArticleByTitle(title, pagination);
                sb.append("title=").append(title);
            } else {
                if(cid != null && !"".equals(cid)) {
                    articles = articleService.findArticleByCid(Integer.parseInt(cid), pagination);
                    sb.append("&cid=").append(cid);
                } else {
                    articles = articleService.findArticle(pagination);
                }
            }
            pagination.setUrl(sb.toString());
            // 将学生记录信息转发到下一页
            request.setAttribute("articles", articles);
           // request.setAttribute("categories", categories);
            // 将分页信息转发到下一页
            request.setAttribute("pagination", pagination);
            request.getRequestDispatcher("article.jsp").forward(request, response);

        } catch (Exception e) {
           e.printStackTrace();
        } /*catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("de", e);
            request.getRequestDispatcher("/daoException.jsp").forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
            request.setAttribute("se", e);
            request.getRequestDispatcher("/serviceException.jsp").forward(request, response);
        }*/

    }
}
