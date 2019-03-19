package com.jbb.article.controller;

import baseenum.StatusEnum;
import com.jbb.article.pojo.Article;
import com.jbb.article.service.ArticleService;
import controller.BaseController;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", articleService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        if (article == null) {
            article = articleService.findById(id);
            redisTemplate.opsForValue().set("article_" + id, article, 1, TimeUnit.DAYS);
        }
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", article);
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Article> pageList = articleService.findSearch(searchMap, page, size);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", new PageResult<Article>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", articleService.findSearch(searchMap));
    }

    /**
     * 增加
     *
     * @param article
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "增加成功");
    }

    /**
     * 修改
     *
     * @param article
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Article article, @PathVariable String id) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        articleService.deleteById(id);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "删除成功");
    }

    /**
     * 审核
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/examine/{id}", method = RequestMethod.PUT)
    public Result examine(@PathVariable String id) {
        articleService.examine(id);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "审核成功！");
    }

    /**
     * 点赞
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/thumbup/{id}", method = RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id) {
        articleService.updateThumbup(id);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "点赞成功");
    }

}
