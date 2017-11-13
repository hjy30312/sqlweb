package com.hjy.idao;

import com.hjy.model.Article;
import com.hjy.util.Pagination;

import java.util.List;

/**
 * @author hjy
 * @create 2017/11/13
 **/
public interface IArticleDao {
    public void insert(Article article);
    public void update(Article article);
    public void delete(int id);
    public void deleteSelected(int[] ids);
    public Article selectOneById(int id);
    public Article selectPrevOneById(int id, int cid);
    public Article selectNextOneById(int id, int cid);
    public List<Article> selectSome(Pagination pagination);
    public List<Article> selectSomeByCid(int cid, Pagination pagination);
    public List<Article> selectSomeByTitle(String title, Pagination pagination);
    public void updateHints(int id);

}
