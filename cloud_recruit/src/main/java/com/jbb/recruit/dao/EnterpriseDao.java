package com.jbb.recruit.dao;

import com.jbb.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {
    /**
     * 根据热门查询列表
     *
     * @param ishot 是否热门
     * @return java.util.List<com.jbb.recruit.pojo.Enterprise>
     */
    List<Enterprise> findByIshot(String ishot);
}
