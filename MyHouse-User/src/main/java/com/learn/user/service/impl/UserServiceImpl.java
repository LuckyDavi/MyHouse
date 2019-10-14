package com.learn.user.service.impl;

import com.learn.user.mapper.UserMapper;
import com.learn.user.pojo.User;
import com.learn.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 谢为
 * @since 2019-10-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 获取导出excel的数据
     * @return
     */
    @Override
    public List<List<String>> getExportDatas() {
        List<User> userList = userMapper.getExportDatas();
        List<List<String>> result = new ArrayList<>();
        for(User user:userList){
            List<String> data = new ArrayList<>();
            data.add(user.getName());
            if(user.getSex()==1){
                data.add("男");
            }else if(user.getSex()==0){
                data.add("女");
            }
            data.add(user.getAge().toString());
            data.add(user.getBirthday().toString());
            data.add(user.getJob());
            result.add(data);
        }
        return result;
    }
}
