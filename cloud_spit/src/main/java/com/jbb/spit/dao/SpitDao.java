package com.jbb.spit.dao;

import com.jbb.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽dao
 *
 * @author jbb
 * @date 2019/3/18
 */
public interface SpitDao extends MongoRepository<Spit, String> {
    /**
     * 根据上级ID查询吐槽列表（分页）
     *
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Spit> findByParentid(String parentid, Pageable pageable);
}
