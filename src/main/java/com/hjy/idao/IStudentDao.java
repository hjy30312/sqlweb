package com.hjy.idao;

import com.hjy.model.Student;
import com.hjy.util.Pagination;

import java.util.List;

/**
 * 学生数据访问层接口
 * @author hjy
 * @create 2017/11/15
 **/
public interface IStudentDao {
    /**
     * 添加学生
     * @param stu
     */
    public void insert(Student stu);

    /**
     * 更新学生信息
     * @param stu
     */
    public void update(Student stu);

    /**
     * 修改密码
     * @param stu
     * @param newpw
     */
    public void updatePassword(Student stu, String newpw);

    /**
     * 通过学号sno删除学生
     * @param sno
     */
    public void delete(String sno);

    /**
     * 通过学号sno删除学生(批量)
     * @param snos
     */
    public void deleteSelected(String[] snos);
    public Student selectOneBySno(String sno);
    public Student selectOneBySnoPassword(String sno, String password);
    public List<Student> selectSome(Pagination pagination);
    public List<Student> selectSomeBySno(String sno, Pagination pagination);
}
