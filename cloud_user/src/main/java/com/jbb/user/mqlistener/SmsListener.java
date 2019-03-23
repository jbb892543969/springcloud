package com.jbb.user.mqlistener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短信监听发送
 *
 * @author jbb
 * @date 2019/3/20
 */
@Component
public class SmsListener {
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "queue.sms"), exchange = @Exchange("exchage.cloud"), key = "smsKey")})
    public void send(Map<String, String> msg) {
        System.out.println(msg.get("mobile"));
        System.out.println(msg.get("code"));
    }
}
