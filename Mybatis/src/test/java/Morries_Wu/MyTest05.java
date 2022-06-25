package Morries_Wu;


import Morries_Wu.Dao.StudentDao;
import Morries_Wu.Utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class MyTest05 {

    @Test
    public void testCountStudent() throws IOException {
        //1、获取SqlSession
        SqlSession session = MybatisUtil.getsqlsession();
        //2、获取Dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        int count = dao.countStudent();
        System.out.println("nums" + count);
        session.close();
    }

    @Test
    public void testSelectMap() throws IOException {
        //1、获取SqlSession
        SqlSession session = MybatisUtil.getsqlsession();
        //2、获取Dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object, Object> outMap = dao.selectMap(1001);
        System.out.println(outMap);
        session.close();
    }


}
