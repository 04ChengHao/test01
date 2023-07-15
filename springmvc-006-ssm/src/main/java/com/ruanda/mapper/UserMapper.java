package com.ruanda.mapper;

import com.ruanda.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 分页查询 User
     * @param startRows 起始页
     * @return List<User>
     */
    List<User> queryUserPage(Integer startRows);

    /**
     * select * from user
     * #limit(当前页面-1)*每页条数,每页条数
     * limit 10,5
     */
    List<User> selectUserPage(
            @Param("userName")
            String userName,
            @Param("userSex")
            String userSex,
            @Param("startRow")  //算好的起始行的值
            int startRow);

    /**
     * 添加 User
     * @param user
     * @return 返回码
     */
    int createUser(User user);

    /**
     * 根据 userId 删除用户
     * @return 返回码
     */
    int deleteUserById(String userId);

    /**
     * 查询 User 个数
     * @param userName
     * @param userSex
     * @return
     */
    int getRowCount(
            @Param("userName")
            String userName,
            @Param("userSex")
            String userSex);

    /**
     * 根据 userId 批量删除用户
     * @param userIds
     * @return
     */
    int deleteUserByIdList(@Param("list") List userIds);

    /**
     * 根据 userId 更新用户
     * @return 返回码
     */
    int updateUserById(User user);
}
