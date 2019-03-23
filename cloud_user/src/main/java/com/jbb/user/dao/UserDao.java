package com.jbb.user.dao;

import com.jbb.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    /**
     * 根据手机号查询用户
     *
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile);

}
