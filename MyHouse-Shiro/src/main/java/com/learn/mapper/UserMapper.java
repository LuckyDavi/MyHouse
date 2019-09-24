package com.learn.mapper;

import com.learn.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 谢为
 * @since 2019-08-19
 */
@Mapper
public interface UserMapper {
//    List<User> getAllUser();

    User getUserByUserName(@Param("username") String username);
}
