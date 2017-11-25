package com.hjy.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * * 上下文监听程序,用于初始化访问人数和在线人数,
 * 并将访问人数和在线人数保存在上下文环境对象中
 * @author hjy
 * @create 2017/11/25
 **/
@WebListener
public class InitListener implements ServletContextListener {
    /**
     * Receives notification that the web application initialization
     * process is starting.
     * <p>
     * <p>All ServletContextListeners are notified of context
     * initialization before any filters or servlets in the web
     * application are initialized.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("totalcount", 0);//访问总数
        sc.setAttribute("accesscount", 0);//在线用户数
    }

    /**
     * Receives notification that the ServletContext is about to be
     * shut down.
     * <p>
     * <p>All servlets and filters will have been destroyed before any
     * ServletContextListeners are notified of context
     * destruction.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being destroyed
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //保存进文件或数据库
    }
}
