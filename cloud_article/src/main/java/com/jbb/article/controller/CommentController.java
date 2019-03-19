package com.jbb.article.controller;

import baseenum.StatusEnum;
import com.jbb.article.pojo.Comment;
import com.jbb.article.service.CommentService;
import controller.BaseController;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论Controller
 *
 * @author jbb
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "提交成功 ");
    }

    @RequestMapping(value = "/article/{articleid}", method = RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid) {
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", commentService.findByArticleid(articleid));
    }

}