package com.huangwei.springcloud.receiver;

import com.huangwei.springcloud.entities.Product;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Hw
 * 21/02/24 13:54
 */
@Component
@RabbitListener(queues = "topic.woman")
public class SecondTopicReceiver {

    @RabbitHandler
    public void  SecondTopicReceiver(Product productList)
    {
        System.out.println("消费者topic.woman收到消息"+productList.getId());
    }
}
