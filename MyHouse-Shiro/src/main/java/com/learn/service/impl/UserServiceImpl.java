package com.learn.service.impl;


import com.learn.mapper.UserMapper;
import com.learn.model.User;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 谢为
 * @since 2019-08-19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

//    @Override
//    public List<User> getAllUser() {
//        return userMapper.getAllUser();
//    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }

//    @Override
//    public boolean login(String username,String password) {
//        User user = getUserByUserName(username);
//        if(password.equals(user.getPassword())){
//            return true;
//        }else
//            return false;
//    }
}
