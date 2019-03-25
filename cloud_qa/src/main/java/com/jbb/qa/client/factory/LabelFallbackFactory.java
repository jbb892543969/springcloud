package com.jbb.qa.client.factory;

import baseenum.StatusEnum;
import com.jbb.qa.client.LableClient;
import entity.Result;
import org.springframework.stereotype.Component;

/**
 * label服务异常处理
 *
 * @author jbb
 * @date 2019/3/23
 */
@Component
public class LabelFallbackFactory implements LableClient {
    @Override
    public Result findById(String id) {
        return new Result(false, StatusEnum.REMOTERROR.getCode(), "服务调用失败");
    }
}
