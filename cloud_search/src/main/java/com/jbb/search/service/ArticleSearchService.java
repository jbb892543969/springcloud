package com.jbb.search.service;

import com.jbb.search.dao.ArticleSearchDao;
import com.jbb.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import service.BaseService;

/**
 * 文章搜索Service
 *
 * @author jbb
 */
@Service
public class ArticleSearchService extends BaseService {
    @Autowired
    private ArticleSearchDao articleSearchDao;

    /**
     * 增加文章
     *
     * @param article
     */
    public void add(Article article) {
        articleSearchDao.save(article);
    }

    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
    }
}