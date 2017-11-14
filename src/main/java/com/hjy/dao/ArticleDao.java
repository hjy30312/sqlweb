package com.hjy.dao;

import com.hjy.idao.IArticleDao;
import com.hjy.iservice.IArticleService;
import com.hjy.model.Article;
import com.hjy.util.DatabaseBean;
import com.hjy.util.Pagination;

import javax.xml.rpc.ServiceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/13
 **/
public class ArticleDao implements IArticleDao {


    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;


    @Override
    public void insert(Article article) {

    }

    @Override
    public void update(Article article) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteSelected(int[] ids) {

    }

    @Override
    public Article selectOneById(int id) {
        return null;
    }

    @Override
    public Article selectPrevOneById(int id, int cid) {
        return null;
    }

    @Override
    public Article selectNextOneById(int id, int cid) {
        return null;
    }

    @Override
    public List<Article> selectSome(Pagination pagination) {
        List<Article> articles = new ArrayList<Article>();

        try {
            //统计总记录数
            conn = DatabaseBean.getConnection();
            //返回tb_article表中的总行数
            String sql = "select count(*) as counts from tb_article";
            //预编译处理
            psmt = conn.prepareStatement(sql);
            psmt.executeQuery();
            rs.next();
            System.out.println(rs.getInt("counts"));
            pagination.setCountSize(rs.getInt("counts"));
            //求指定显示的记录数
            int perPage = pagination.getPageSize();
            int start = (pagination.getPageNo() - 1) * perPage + 1;
            int end = pagination.getPageNo() * perPage;
            //小于等于该页最大条数，大于等于该页最小条数
            sql = "SELECT * FROM(SELECT ROWNUM NO,s.* FROM "
                    + "(SELECT a.*,b.catename,b.description FROM tb_article a JOIN tb_category b ON a.cid=b.cid ORDER BY a.id DESC) s "
                    + "WHERE ROWNUM<=?) WHERE NO >=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,end);
            psmt.setInt(2,start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                /*Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setCatename(rs.getString("catename"));
                category.setDescription(rs.getString("description"));
                article.setCategory(category);*/
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setAuthor(rs.getString("author"));
                //article.setPosttime(DateUtil.timeStampToString(rs.getTimestamp("posttime")));
//                article.setPosttime(rs.getDate("posttime").toString());
                article.setHints(rs.getInt("hints"));
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseBean.release(rs,psmt,conn);
        }
        return null;
    }

    @Override
    public List<Article> selectSomeByCid(int cid, Pagination pagination) {
        return null;
    }

    @Override
    public List<Article> selectSomeByTitle(String title, Pagination pagination) {
        return null;
    }

    @Override
    public void updateHints(int id) {

    }
}
