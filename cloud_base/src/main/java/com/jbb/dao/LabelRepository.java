package com.jbb.dao;

import com.jbb.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 标签dao
 *
 * @author jbb
 * @date 2019/3/16
 */
public interface LabelRepository extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
