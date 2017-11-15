package com.hjy.dao;

import com.hjy.idao.IStudentDao;
import com.hjy.model.Student;
import com.hjy.util.DaoException;
import com.hjy.util.DatabaseBean;
import com.hjy.util.Pagination;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生数据访问类实现
 * @author hjy
 * @create 2017/11/15
 **/
public class StudentDao implements IStudentDao {

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public static Student stuSet(ResultSet rs) {
        Student stu = new Student();
        try {
            if (rs.next()) {
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPassword(rs.getString("password"));
                stu.setSavgGrade(rs.getDouble("savgGrade"));
                stu.setPhoto_url(rs.getString("photo_url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return stu;
        }
    }

    @Override
    public void insert(Student stu) {
        try {
            conn = DatabaseBean.getConnection();
            if (stu.getPhoto().available() > 0) {
                String sql = "insert into tb_student(sno,sname,ssex,sage,sdept,spicture,photo_url) values(?,?,?,?,?,?,?)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, stu.getSno());
                psmt.setString(2, stu.getSname());
                psmt.setString(3, stu.getSsex());
                psmt.setInt(4, stu.getSage());
                psmt.setString(5, stu.getSdept());
                psmt.setBinaryStream(6, stu.getPhoto(), stu.getPhoto().available());
                psmt.setString(7, stu.getPhoto_url());
            } else {
                String sql = "insert into tb_student(sno,sname,ssex,sage,sdept,photo_url) values(?,?,?,?,?,?)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, stu.getSno());
                psmt.setString(2, stu.getSname());
                psmt.setString(3, stu.getSsex());
                psmt.setInt(4, stu.getSage());
                psmt.setString(5, stu.getSdept());
                psmt.setString(6, stu.getPhoto_url());
            }
            psmt.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(psmt, conn);
        }
    }

    @Override
    public void update(Student stu) {
        try {
            conn = DatabaseBean.getConnection();
            if (stu.getPhoto().available() > 0) {
                String sql = "update tb_student set sname=?,ssex=?,sage=?,sdept=?,password=?,spicture=?,photo_url=? where sno=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, stu.getSname());
                psmt.setString(2, stu.getSsex());
                psmt.setInt(3, stu.getSage());
                psmt.setString(4, stu.getSdept());
                psmt.setString(5, stu.getPassword());
                psmt.setBinaryStream(6, stu.getPhoto(), stu.getPhoto().available());
                psmt.setString(7, stu.getPhoto_url());
                psmt.setString(8, stu.getSno());
            } else {
                String sql = "update tb_student set sname=?,ssex=?,sage=?,sdept=?,password=? where sno=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, stu.getSname());
                psmt.setString(2, stu.getSsex());
                psmt.setInt(3, stu.getSage());
                psmt.setString(4, stu.getSdept());
                psmt.setString(5, stu.getPassword());
                psmt.setString(6, stu.getSno());
            }
            psmt.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(psmt, conn);
        }
    }

    @Override
    public void delete(String sno) {

        try {
            conn = DatabaseBean.getConnection();
            String sql = "delete from tb_student where sno=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, sno);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
    }

    @Override
    public Student selectOneBySno(String sno) {
        Student stu = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_student where sno=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, sno);
            rs = psmt.executeQuery();
            //stu = stuSet(rs);
            if (rs.next()) {
                stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPassword(rs.getString("password"));
                stu.setSavgGrade(rs.getDouble("savgGrade"));
                stu.setPhoto_url(rs.getString("photo_url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return stu;
    }

    @Override
    public List<Student> selectSome(Pagination pagination) {
        List<Student> students = new ArrayList<Student>();

        try {
            //统计总记录数
            conn = DatabaseBean.getConnection();
            String sql = "select count(*) as counts from tb_student";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
            //求指定显示的记录数
            int perPage = pagination.getPageSize();
            int start = (pagination.getPageNo() - 1) * perPage + 1;
            int end = pagination.getPageNo() * perPage;
            //小于等于该页最大条数，大于等于该页最小条数
            sql = "SELECT * FROM(SELECT ROWNUM NO,s.* FROM "
                    + "(SELECT * FROM tb_student ORDER BY sno ASC) s "
                    + "WHERE ROWNUM<=?) WHERE NO >=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPassword(rs.getString("password"));
                stu.setSavgGrade(rs.getDouble("savgGrade"));
                stu.setPhoto_url(rs.getString("photo_url"));
                students.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return students;
    }

    @Override
    public List<Student> selectSomeBySno(String sno, Pagination pagination) {
        List<Student> students = new ArrayList<Student>();
        String sql;

        try {
            //统计总记录数
            conn = DatabaseBean.getConnection();
            sql = "select count(*) as counts from tb_student where sno like ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + sno + "%");
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
            //求指定显示的记录数
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;
            int perPage = pagination.getPageSize();
            int end = pagination.getPageNo() * perPage;
            sql = "SELECT * FROM(SELECT ROWNUM NO,s.* FROM "
                    + "(SELECT * FROM tb_student WHERE sno like ? ORDER BY sno ASC) s "
                    + "WHERE ROWNUM<=?) WHERE NO >=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + sno + "%");
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPassword(rs.getString("password"));
                stu.setSavgGrade(rs.getDouble("savgGrade"));
                stu.setPhoto_url(rs.getString("photo_url"));
                students.add(stu);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
    }

    @Override
    public void deleteSelected(String[] snos) {
        try {
            conn = DatabaseBean.getConnection();
            StringBuilder sb = new StringBuilder("delete from tb_student where sno in(");
            for (String s : snos) {
                sb.append("'").append(s).append("',");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            psmt = conn.prepareStatement(sb.toString());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
    }

    @Override
    public Student selectOneBySnoPassword(String sno, String password) {
        Student stu = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from tb_student where sno=? and password=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, sno);
            psmt.setString(2, password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setSno(rs.getString("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSage(rs.getInt("sage"));
                stu.setSdept(rs.getString("sdept"));
                stu.setPassword(rs.getString("password"));
                stu.setSavgGrade(rs.getDouble("savgGrade"));
                stu.setPhoto_url(rs.getString("photo_url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(rs, psmt, conn);
        }
        return stu;
    }

    @Override
    public void updatePassword(Student stu, String newpw) {
        try {
            conn = DatabaseBean.getConnection();
            String sql = "update tb_student set password=? where sno=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, newpw);
            psmt.setString(2, stu.getSno());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("数据库操作异常，请稍后重试!", e);
        } finally {
            DatabaseBean.release(psmt, conn);
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        IStudentDao studentDao = new StudentDao();
        Student student = new Student();
        studentDao.insert(student);
    }

}
