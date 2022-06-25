package Morries_Wu.Dao.IMPL;

import Morries_Wu.Bean.Student;
import Morries_Wu.Dao.StudentDao;
import Morries_Wu.QueryParam.QueryParam;
import Morries_Wu.Utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StudentDaoIMPL implements StudentDao {
    @Override
    public Student selectById(Integer id) throws IOException {
        SqlSession session = MybatisUtil.getsqlsession();
        String sqlId = "Morries_Wu.Dao.StudentDao" + "." + "selectById";
        Student student = session.selectOne(sqlId, id);
        session.commit();
        return student;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MybatisUtil.getsqlsession();
        String sqlId = "Morries_Wu.Dao.StudentDao" + "." + "insertStudent";
        int insert = session.insert(sqlId, student);
        session.commit();
        session.close();
        return insert;
    }

    @Override
    public List<Student> selectStudents() {
        return null;
    }

    @Override
    public Student selectByEmail(String email) {
        return null;
    }

    @Override
    public List<Student> selectByNameOrAge(String name, Integer age) {
        return null;
    }

    @Override
    public List<Student> selectByObject(Student student) {
        return null;
    }

    @Override
    public List<Student> selectByQueryParam(QueryParam param) {
        return null;
    }

    @Override
    public List<Student> selectByPosition(String name, Integer age) {
        return null;
    }

    @Override
    public List<Student> selectStudentByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }

    @Override
    public List<Student> queryStudent(String name) {
        return null;
    }

    @Override
    public List<Student> queryStudentOrById() {
        return null;
    }

    @Override
    public List<Student> queryStudentOrByName() {
        return null;
    }

    @Override
    public List<Student> queryStudentOrByColName(String name) {
        return null;
    }

    @Override
    public int countStudent() {
        return 0;
    }

    @Override
    public Map<Object, Object> selectMap(Integer id) {
        return null;
    }
}
