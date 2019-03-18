package com.jbb.base.dao.mybatis;

import com.jbb.base.entity.Label;

import java.util.List;

/**
 * 标签Mapper
 *
 * @author jbb
 * @date 2019/3/17
 */
public interface LabelMapper {
    /**
     * 按条件搜索
     *
     * @param label 标签条件
     * @return java.util.List<com.jbb.base.entity.Label>
     */
    List<Label> findSearch(Label label);
}
