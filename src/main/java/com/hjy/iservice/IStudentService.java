package com.hjy.iservice;

import com.hjy.model.Student;
import com.hjy.util.Pagination;
import com.hjy.util.ServiceException;

import java.util.List;

/**
 * @author hjy
 * @create 2017/11/15
 **/
public interface IStudentService {
    public void addStudent(Student stu) throws ServiceException;
    public void editStudent(Student stu) throws ServiceException;
    public void editStudentPassword(Student stu, String newpw) throws ServiceException;
    public void deleteStudent(String sno) throws ServiceException;
    public void deleteSelectedStudents(String[] snos) throws ServiceException;
    public Student findStudentBySno(String sno) throws ServiceException;
    public Student findStudentBySnoPassword(String sno, String password) throws ServiceException;
    public List<Student> findStudents(Pagination pagination) throws ServiceException;
    public List<Student> findStudentsBySno(String sno, Pagination pagination) throws ServiceException;
}
