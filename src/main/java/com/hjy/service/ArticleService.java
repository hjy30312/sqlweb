package com.hjy.service;

import com.hjy.idao.IArticleDao;
import com.hjy.iservice.IArticleService;
import com.hjy.model.Article;
import com.hjy.util.MyFactory;
import com.hjy.util.Pagination;

import javax.xml.rpc.ServiceException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/13
 **/
public class ArticleService implements IArticleService {

    private final IArticleDao articleDao = (IArticleDao) MyFactory.getObject("articleDao");

    @Override
    public void addArticle(Article article) throws ServiceException {

    }

    @Override
    public void editArticle(Article article) throws ServiceException {

    }

    @Override
    public void deleteArticle(int id) throws ServiceException {

    }

    @Override
    public void deleteSelectedArticles(int[] ids) throws ServiceException {

    }

    @Override
    public Article findArticleById(int id) throws ServiceException {
        return null;
    }

    @Override
    public Article findPrevArticleById(int id, int cid) throws ServiceException {
        return null;
    }

    @Override
    public Article findNextArticleById(int id, int cid) throws ServiceException {
        return null;
    }

    @Override
    public List<Article> findArticle(Pagination pagination) throws ServiceException {
        List<Article> articleList = null;
        articleList = articleDao.selectSome(pagination);
        return articleList;
    }

    @Override
    public List<Article> findArticleByCid(int cid, Pagination pagination) throws ServiceException {
        return null;
    }

    @Override
    public List<Article> findArticleByTitle(String title, Pagination pagination) throws ServiceException {
        return null;
    }

    @Override
    public void editHints(int id) {

    }
}
