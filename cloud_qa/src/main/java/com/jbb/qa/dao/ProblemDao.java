package com.jbb.qa.dao;

import com.jbb.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
    /**
     * 根据标签ID查询最新问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "select * from tb_problem pm,tb_pl pl where pm.id = pl.problemid and pl.labelid = ?1 order by pm.replytime desc", nativeQuery = true)
    Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询最火热问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "select * from tb_problem pm,tb_pl pl where pm.id = pl.problemid and pl.labelid = ?1 order by pm.reply desc", nativeQuery = true)
    Page<Problem> hotList(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询最未回答问题列表
     *
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "select * from tb_problem pm,tb_pl pl where pm.id = pl.problemid and pl.labelid = ?1 and pm.reply = 0 order by pm.createtime desc", nativeQuery = true)
    Page<Problem> waitList(String labelId, Pageable pageable);
}
