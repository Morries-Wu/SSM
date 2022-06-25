package test_work.Dao.Impl;

import test_work.Bean.SysUser;
import test_work.Dao.UserDao;

public class OracleDaoImpl implements UserDao {

    public OracleDaoImpl() {
        System.out.println("OracleDaoImpl已被创建");
    }


    @Override
    public void insertUser(SysUser user) {
        System.out.println("执行了Oracle数据库操作");
    }
}
