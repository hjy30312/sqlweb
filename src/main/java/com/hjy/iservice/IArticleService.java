package com.hjy.iservice;

import com.hjy.model.Article;
import com.hjy.util.Pagination;

import javax.xml.rpc.ServiceException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/13
 **/
public interface IArticleService {
    public void addArticle(Article article) throws ServiceException;
    public void editArticle(Article article) throws ServiceException;
    public void deleteArticle(int id) throws ServiceException;
    public void deleteSelectedArticles(int[] ids) throws ServiceException;
    public Article findArticleById(int id) throws ServiceException;
    public Article findPrevArticleById(int id, int cid) throws ServiceException;
    public Article findNextArticleById(int id, int cid) throws ServiceException;
    public List<Article> findArticle(Pagination pagination) throws ServiceException;
    public List<Article> findArticleByCid(int cid, Pagination pagination) throws ServiceException;
    public List<Article> findArticleByTitle(String title, Pagination pagination) throws ServiceException;
    public void editHints(int id);
}
