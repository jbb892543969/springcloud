package com.jbb.article.service;

import com.jbb.article.dao.CommentDao;
import com.jbb.article.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BaseService;

import java.util.List;

/**
 * 评论Service
 *
 * @author jbb
 */
@Service
public class CommentService extends BaseService {
    @Autowired
    private CommentDao commentDao;

    public void add(Comment comment) {
        comment.setId(idWorker.nextId() + "");
        commentDao.save(comment);
    }

    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }
}