package Morries_Wu.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static SqlSessionFactory factory = null;

    static {
        String config = "mybatis.xml";
        try {
            InputStream read = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建方法,获取SqlSession对象
    public static SqlSession getsqlsession() {
        SqlSession session = null;
        if (factory != null) {
            session = factory.openSession();//openSession(true)
        }
        return session;
    }


}
