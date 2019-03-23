package com.jbb.user.controller;

import baseenum.StatusEnum;
import com.jbb.user.pojo.Admin;
import com.jbb.user.service.AdminService;
import controller.BaseController;
import entity.PageResult;
import entity.Result;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", adminService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", adminService.findById(id));
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
        Page<Admin> pageList = adminService.findSearch(searchMap, page, size);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", new PageResult<Admin>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusEnum.SUCCESS.getCode(), "查询成功", adminService.findSearch(searchMap));
    }

    /**
     * 增加
     *
     * @param admin
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Admin admin) {
        adminService.add(admin);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "增加成功");
    }

    /**
     * 修改
     *
     * @param admin
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Admin admin, @PathVariable String id) {
        admin.setId(id);
        adminService.update(admin);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");//获取头信息
        if (authHeader == null) {
            return new Result(false, StatusEnum.ACCESSERROR.getCode(), "权限不足");
        }
        if (!authHeader.startsWith("Bearer ")) {
            return new Result(false, StatusEnum.ACCESSERROR.getCode(), "权限不足");
        }
        String token = authHeader.substring(7);//提取token
        Claims claims = jwtUtil.parseJWT(token);
        if (claims == null) {
            return new Result(false, StatusEnum.ACCESSERROR.getCode(), "权限不足");
        }
        if (!"admin".equals(claims.get("roles"))) {
            return new Result(false, StatusEnum.ACCESSERROR.getCode(), "权限不足");
        }
        adminService.deleteById(id);
        return new Result(true, StatusEnum.SUCCESS.getCode(), "删除成功");
    }

    /**
     * 用户登陆
     *
     * @param loginMap
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String, String> loginMap) {
        Admin admin = adminService.findByLoginnameAndPassword(loginMap.get("loginname"), loginMap.get("password"));
        if (admin != null) {
            //生成token
            String token = jwtUtil.createJWT(admin.getId(), admin.getLoginname(), "admin");
            return new Result(true, StatusEnum.SUCCESS.getCode(), "登陆成功", token);
        } else {
            return new Result(false, StatusEnum.ERROR.getCode(), "用户名或密码错误");
        }
    }
}
