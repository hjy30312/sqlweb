package com.hjy.util;

import com.hjy.iservice.IArticleService;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author hjy
 * @create 2017/11/12
 **/
public class MyFactory {
    public static Properties prop = new Properties();
    static {
        try {
            //加载配置文件
            InputStream in = DatabaseBean.class.getResourceAsStream("/config.properties");
            prop = new Properties();
            prop.load(in);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        IArticleService articleService = (IArticleService)MyFactory.getObject("articleService");

    }



    public static Object getObject(String name) {
        try {
            String className = prop.getProperty(name);
            Object obj = Class.forName(className).newInstance();
            return obj;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}
