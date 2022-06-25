package com.Items.Item01.Dao;

import com.Items.Item01.Bean.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    int insertStudent(Student student);

    Student selectById(@Param("studentId") Integer id);
}
