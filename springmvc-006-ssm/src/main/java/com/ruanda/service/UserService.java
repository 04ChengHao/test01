package com.ruanda.service;

import com.ruanda.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    /**
     * 分页查询 User
     * @param startRows 起始页
     * @return List<User>
     */
    List<User> queryUserPage(Integer startRows);

    /**
     * 分页查询 User 带条件
     * @param userName
     * @param userSex
     * @param startRow
     * @return
     */
    List<User> selectUserPage(String userName, String userSex, int startRow);

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
    int getRowCount(String userName,String userSex);

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
