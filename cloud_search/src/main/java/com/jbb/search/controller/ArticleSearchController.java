package com.jbb.search.controller;

import baseenum.StatusEnum;
import com.jbb.search.pojo.Article;
import com.jbb.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {
    @Autowired
    private ArticleSearchService articleSearchService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        articleSearchService.add(article);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "操作成功");
    }

    @RequestMapping(value = "/search/{keywords}/{page}/{size}", method =
            RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords,
                                  @PathVariable int page, @PathVariable int size) {
        Page<Article> articlePage =
                articleSearchService.findByTitleLike(keywords, page, size);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", new PageResult<Article>(articlePage.getTotalElements(), articlePage.getContent()));
    }
}