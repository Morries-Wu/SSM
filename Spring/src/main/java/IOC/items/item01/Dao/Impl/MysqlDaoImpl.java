package IOC.items.item01.Dao.Impl;

import IOC.items.item01.Bean.SysUser;
import IOC.items.item01.Dao.UserDao;

public class MysqlDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("执行了Mysql数据库操作");
    }
}
