package test_work.Service.Impl;

import org.springframework.stereotype.Service;
import test_work.Bean.SysUser;
import test_work.Dao.UserDao;
import test_work.Service.UserService;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {
    //引用类型 @Autowired,@Resource
    @Resource(name = "MysqlDaoImpl")
    private UserDao userDao = null;
    //使用set注入,需要set方法

    @Override
    public void addUser(SysUser user) {
        userDao.insertUser(user);
    }
}
