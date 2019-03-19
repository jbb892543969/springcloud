package com.jbb.article.dao;

import com.jbb.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 评论Dao
 *
 * @author jbb
 */
public interface CommentDao extends MongoRepository<Comment, String> {
    /**
     * 根据文章ID查询评论列表
     *
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);
}