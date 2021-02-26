package com.huangwei.springcloud.receiver;

import com.huangwei.springcloud.config.ApiResult;
import com.huangwei.springcloud.entities.Product;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Hw
 * 21/02/24 13:48
 */
@Component
@RabbitListener(queues = "topic.man")
public class FirstTopicReceiver {

    @Resource
    RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void findList(Product productList)
    {
        System.out.println("消费者topic.man收到消息"+productList.getId());
//        rabbitTemplate.convertAndSend("TopicExchange","main.topic",productList);
    }
}
