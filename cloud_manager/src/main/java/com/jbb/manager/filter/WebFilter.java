package com.jbb.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.JwtUtil;

/**
 * 过滤器
 *
 * @author jbb
 * @date 2019/3/25
 */
@Component
public class WebFilter extends ZuulFilter {
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 过滤器类型
     * pre:路由之前 post:路由之后 routing:路由之时 error:发送错误调用
     *
     * @return java.lang.String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器优先级 数字越大越后执行
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行过滤器
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println(111);
        return null;
    }
}
