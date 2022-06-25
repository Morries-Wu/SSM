package IOC.items.item01.Service.Impl;

import IOC.items.item01.Bean.SysUser;
import IOC.items.item01.Dao.UserDao;
import IOC.items.item01.Service.UserService;

public class UserServiceImpl implements UserService {
    //引用类型
    private UserDao userDao = null;
    //使用set注入,需要set方法

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(SysUser user) {
        userDao.insertUser(user);
    }
}
