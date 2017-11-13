package com.hjy.test;

import com.hjy.idao.IArticleDao;
import com.hjy.util.MyFactory;

/**
 * @author hjy
 * @create 2017/11/13
 **/
public class JDBCtest {
    private final IArticleDao articleDao = (IArticleDao) MyFactory.getObject("articleDao");

    public static void main(String[] args) {





    }



}
