package com.Items.Item01.Service.Impl;

import com.Items.Item01.Bean.Student;
import com.Items.Item01.Dao.StudentDao;
import com.Items.Item01.Service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao;

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);
        return rows;
    }

    @Override
    public Student findStudentById(Integer id) {
        Student stu = dao.selectById(id);
        return stu;
    }
}
