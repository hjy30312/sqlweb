package com.hjy.model;

import java.io.Serializable;

/**
 * 资料分类实体类
 * @author hjy
 * @create 2017/11/13
 **/
public class Category implements Serializable{
    private int cid;
    private String catename;
    private String description;
    private int count;

    public Category() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
