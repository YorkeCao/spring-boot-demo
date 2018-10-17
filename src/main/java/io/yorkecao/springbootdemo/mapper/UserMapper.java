package io.yorkecao.springbootdemo.mapper;

import io.yorkecao.springbootdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Yorke
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     * @return 用户
     */
    User selectUserById(@Param("id") int id);
}
