package Morries_Wu.Dao;

import Morries_Wu.Bean.Student;
import Morries_Wu.QueryParam.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    //查询一个学生
    Student selectById(Integer id) throws IOException;

    //添加一个学生,返回值int:表示本次操作影响的数据库的行数
    int insertStudent(Student student);

    List<Student> selectStudents();

    //Dao接口的方法形参是一个简单类型的
    Student selectByEmail(String email);

    /**
     * 多个简单参数
     * 使用@Param命名参数,注解是mybatis提供的
     * 位置:在形参定义的前面
     * 属性:value 自定义的参数名臣
     */
    List<Student> selectByNameOrAge(@Param(value = "myname") String name, @Param(value = "myage") Integer age);

    /**
     * 一个Java对象作为参数(对象由属性,每个属性有set,get方法)
     */
    List<Student> selectByObject(Student student);

    List<Student> selectByQueryParam(QueryParam param);

    //使用位置,获取参数
    List<Student> selectByPosition(String name, Integer age);

    //使用Map作为参数
    List<Student> selectStudentByMap(Map<String, Object> map);

    //更新
    int updateStudent(Student student);

    //使用${}占位符,使用@Param命名
    List<Student> queryStudent(@Param("myname") String name);

    List<Student> queryStudentOrById();

    List<Student> queryStudentOrByName();

    List<Student> queryStudentOrByColName(@Param("colName") String name);

    int countStudent();

    //查询结果返回是一个Map
    Map<Object, Object> selectMap(@Param("stuid") Integer id);

}
