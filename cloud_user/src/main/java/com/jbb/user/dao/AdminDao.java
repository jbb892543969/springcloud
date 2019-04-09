package com.jbb.user.dao;

import com.jbb.user.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
    /**
     * 根据用户名查管理员
     *
     * @param loginname 用户名
     * @return
     */
    Admin findByLoginname(String loginname);
}
