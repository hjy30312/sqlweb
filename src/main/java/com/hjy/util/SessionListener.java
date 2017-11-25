package com.hjy.util;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author hjy
 * @create 2017/11/25
 **/
@WebListener
public class SessionListener implements HttpSessionListener {
    /**
     * Receives notification that a session has been created.
     *
     * @param se the HttpSessionEvent containing the session
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        ServletContext sc = se.getSession().getServletContext();
        Integer totalcount = (Integer) sc.getAttribute("totalcount");
        Integer accesscount = (Integer) sc.getAttribute("accesscount");
        sc.setAttribute("totalcount", ++totalcount);
        sc.setAttribute("accesscount", ++accesscount);
    }

    /**
     * Receives notification that a session is about to be invalidated.
     *
     * @param se the HttpSessionEvent containing the session
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        Integer accesscount = (Integer) sc.getAttribute("accesscount");
        sc.setAttribute("accesscount", --accesscount);
    }
}
