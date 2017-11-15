package com.hjy.service;

import com.hjy.idao.IStudentDao;
import com.hjy.iservice.IStudentService;
import com.hjy.model.Student;
import com.hjy.util.DaoException;
import com.hjy.util.MyFactory;
import com.hjy.util.Pagination;
import com.hjy.util.ServiceException;

import java.util.List;

/**
 * 学生业务逻辑处理层实现类
 * @author hjy
 * @create 2017/11/15
 **/
public class StudentService implements IStudentService {


    private final IStudentDao studentDao = (IStudentDao) MyFactory.getObject("studentDao");

    @Override
    public void addStudent(Student stu) throws ServiceException {
        try {
            studentDao.insert(stu);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public void editStudent(Student stu) throws ServiceException {
        try {
            studentDao.update(stu);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteStudent(String sno) throws ServiceException {
        try {
            studentDao.delete(sno);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Student findStudentBySno(String sno) throws ServiceException {
        Student stu = null;
        try {
            stu = studentDao.selectOneBySno(sno);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return stu;
    }

    @Override
    public List<Student> findStudents(Pagination pagination) throws ServiceException {
        List<Student> list = null;
        try {
            list = studentDao.selectSome(pagination);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public List<Student> findStudentsBySno(String sno, Pagination pagination) throws ServiceException {
        List<Student> list = null;
        try {
            list = studentDao.selectSomeBySno(sno, pagination);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void deleteSelectedStudents(String[] snos) throws ServiceException {
        try {
            studentDao.deleteSelected(snos);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public Student findStudentBySnoPassword(String sno, String password) throws ServiceException {
        Student stu = null;
        try {
            stu = studentDao.selectOneBySnoPassword(sno, password);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return stu;
    }

    @Override
    public void editStudentPassword(Student stu, String newpw) throws ServiceException {
        try {
            studentDao.updatePassword(stu, newpw);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
