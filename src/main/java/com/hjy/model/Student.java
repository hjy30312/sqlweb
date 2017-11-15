package com.hjy.model;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author hjy
 * @create 2017/11/15
 **/
public class Student implements Serializable{

    private String sno;
    private String sname;
    private String ssex;
    private int sage;
    private String sdept;
    private double savgGrade;
    private InputStream photo;
    private String password;
    private String photo_url;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public double getSavgGrade() {
        return savgGrade;
    }

    public void setSavgGrade(double savgGrade) {
        this.savgGrade = savgGrade;
    }

    public InputStream getPhoto() {
        return photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
