package com.hjy.service;

import com.hjy.idao.ICategoryDao;
import com.hjy.iservice.ICategoryService;
import com.hjy.model.Category;
import com.hjy.util.MyFactory;

import javax.xml.rpc.ServiceException;
import java.util.List;


/**
 * 文章分类业务逻辑处理层实现类
 * @author qixin
 */
public class CategoryService implements ICategoryService {
    
    private final ICategoryDao categoryDao = (ICategoryDao) MyFactory.getObject("categoryDao");

    @Override
    public void addCategory(Category category) throws ServiceException {
        try {
            categoryDao.insert(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCategory(Category category) throws ServiceException {
        try {
            categoryDao.update(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int cid) throws ServiceException {
        try {
            categoryDao.delete(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category findCategoryByCid(int cid) throws ServiceException {
        Category category = null;
        try {
            category = categoryDao.selectOneByCid(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> findAllCategory() throws ServiceException {
        List<Category> categoryList = null;
        try {
            categoryList = categoryDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
