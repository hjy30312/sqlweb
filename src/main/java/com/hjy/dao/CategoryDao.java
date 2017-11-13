package com.hjy.dao;

import com.hjy.idao.ICategoryDao;
import com.hjy.model.Category;
import com.hjy.util.DatabaseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 文章分类数据访问类
 * @author qixin
 */
public class CategoryDao implements ICategoryDao {
    
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    @Override
    public void insert(Category category) {
        try {
            conn = DatabaseBean.getConnection();

            String sql = "insert into tb_category(cid,catename,description) values(category_cid.nextval,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, category.getCatename());
            psmt.setString(2, category.getDescription());
            psmt.executeUpdate();
        } catch (SQLException e) {
            //throw new DaoException("数据库操作异常，请稍后重试!", e);

        } finally {
            DatabaseBean.release(rs,psmt, conn);
        }
    }

    @Override
    public void update(Category category) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "update tb_category set catename=?,description=? where cid=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, category.getCatename());
            psmt.setString(2, category.getDescription());
            psmt.setInt(3, category.getCid());
            psmt.executeUpdate();
        } catch (SQLException e) {
            //throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
    }

    @Override
    public void delete(int cid) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "delete from tb_category where cid=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, cid);
            psmt.executeUpdate();
        } catch (SQLException e) {
            // new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
    }

    @Override
    public Category selectOneByCid(int cid) {
        Category category = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_category where cid=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, cid);
            rs = psmt.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setCatename(rs.getString("catename"));
                category.setDescription(rs.getString("description"));
                category.setCount(rs.getInt("count"));
            }
        } catch (SQLException e) {
            //throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return category;
    }

    @Override
    public List<Category> selectAll() {
        List<Category> list = new ArrayList<Category>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_category";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setCatename(rs.getString("catename"));
                category.setDescription(rs.getString("description"));
                category.setCount(rs.getInt("count"));
                list.add(category);
            }
        } catch (SQLException e) {
            //throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return list;
    }
    
}
