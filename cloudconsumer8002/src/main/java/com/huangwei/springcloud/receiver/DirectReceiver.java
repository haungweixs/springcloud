package com.huangwei.springcloud.receiver;

import com.huangwei.springcloud.entities.Rkson;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Hw
 * 21/02/23 14:56
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(List<Rkson> rksonList)
    {
        for(Rkson rkson:rksonList){
            System.out.println("消费者1收到消息"+rkson.getId());
            return;
        }
    }
}
