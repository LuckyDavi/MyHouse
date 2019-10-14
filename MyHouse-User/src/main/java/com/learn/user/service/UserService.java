package com.learn.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.user.pojo.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 谢为
 * @since 2019-10-12
 */
public interface UserService extends IService<User> {

    /**
     * 获取导出excel的数据
     * @return
     */
    List<List<String>> getExportDatas();

}
