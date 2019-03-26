package com.jbb.base.controller;

import baseenum.StatusEnum;
import com.jbb.base.entity.Label;
import com.jbb.base.service.LabelService;
import controller.BaseController;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签Controlle
 *
 * @author jbb
 * @date 2019/3/17
 */
@RestController
@RequestMapping("label")
public class LabelController extends BaseController {
    @Autowired
    private LabelService labelService;
    @Value("${server.port}")
    private Integer port;
    @Value("${test}")
    private String test;

    @GetMapping("test")
    public String test() {
        return test;
    }
    /**
     * 查询标签列表
     *
     * @return entity.Result<java.util.List < com.jbb.base.entity.Label>>
     */
    @GetMapping
    public Result<List<Label>> findAll() {
        return new Result<List<Label>>(true, StatusEnum.SUCCESS.getCode(), "查询成功", labelService.findAll());
    }

    /**
     * 根据ID查询标签
     *
     * @param id 标签ID
     * @return entity.Result<com.jbb.base.entity.Label>
     */
    @GetMapping("/{id}")
    public Result<Label> findById(@PathVariable String id) {
        System.out.println(port);
        return new Result<>(true, StatusEnum.SUCCESS.getCode(), "查询成功", labelService.findById(id));
    }

    /**
     * 增加标签
     *
     * @param label 标签
     * @return entity.Result
     */
    @PostMapping
    public Result addLabel(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "新增成功");
    }

    /**
     * 更新标签
     *
     * @param label 标签
     * @return entity.Result
     */
    @PutMapping
    public Result updateLabel(@RequestBody Label label) {
        labelService.update(label);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "修改成功");
    }

    /**
     * 根据标签ID删除标签
     *
     * @param id 标签ID
     * @return entity.Result
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable String id) {
        labelService.deleteById(id);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "删除成功");
    }

    @PostMapping("/search")
    public Result<List<Label>> findSearch(@RequestBody Label label) {
        List<Label> search = labelService.findSearch(label);
        return new Result<>(true, StatusEnum.SUCCESS.getCode(), "查询成功", search);
    }
}
