package test_work.Dao.Impl;

import org.springframework.stereotype.Repository;
import test_work.Bean.SysUser;
import test_work.Dao.UserDao;

/**
 * Dao持久层
 */
@Repository("MysqlDaoImpl")
public class MysqlDaoImpl implements UserDao {

    public MysqlDaoImpl() {
        System.out.println("MysqlDaoImpl已被创建");
    }

    @Override
    public void insertUser(SysUser user) {
        System.out.println("执行了Mysql数据库操作");
    }
}
