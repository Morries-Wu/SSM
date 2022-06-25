package Morries_Wu.Dao;


import Morries_Wu.Bean.Custom;
import Morries_Wu.Bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao02 {

    Custom selectById(@Param("stuid") Integer id);

    //like第一种方式
    List<Student> selectLikeOne(@Param("name") String name);

    //like第二种方式
    List<Student> selectLikeTwo(@Param("name") String name);

    //if
    List<Student> selectIf(Student student);

    //where
    List<Student> selectWhere(Student student);

    //foreach-1
    List<Student> selectForeachOne(List<Integer> IdList);

    //foreach-2
    List<Student> selectForeachTwo(List<Student> StudentList);

    List<Student> selectAllStudents();

}
