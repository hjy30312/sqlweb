package com.hjy.iservice;

import com.hjy.model.Category;

import javax.xml.rpc.ServiceException;
import java.util.List;

/**
 * @author hjy
 * @create 2017/11/13
 **/

public interface ICategoryService {
    public void addCategory(Category category) throws ServiceException;
    public void editCategory(Category category) throws ServiceException;
    public void deleteCategory(int cid) throws ServiceException;
    public Category findCategoryByCid(int cid) throws ServiceException;
    public List<Category> findAllCategory() throws ServiceException;
}

