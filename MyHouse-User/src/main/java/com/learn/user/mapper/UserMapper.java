package com.learn.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 谢为
 * @since 2019-10-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取导出excel的数据
     * @return
     */
    List<User> getExportDatas();

}
