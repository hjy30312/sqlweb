package com.hjy.idao;


import com.hjy.model.Category;

import java.util.List;

public interface ICategoryDao {
    public void insert(Category category);
    public void update(Category category);
    public void delete(int cid);
    public Category selectOneByCid(int cid);
    public List<Category> selectAll();
    
}
