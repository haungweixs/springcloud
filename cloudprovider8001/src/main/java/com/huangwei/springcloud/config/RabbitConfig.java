package com.huangwei.springcloud.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hw
 * 21/02/25 10:30
 */
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate creatRabbitTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate=new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启mandatory 才能触发回调函数 无论消息怎么推送都能触发
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("ConfirmCallback:   "+"消息唯一标识"+correlationData);
                System.out.println("ConfirmCallback:   "+"消息结果"+b);
                System.out.println("ConfirmCallback:   "+"失败原因"+s);
            }
        });

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("ReturnCallback:     "+"消息："+message);
                System.out.println("ReturnCallback:     "+"回应码："+replyCode);
                System.out.println("ReturnCallback:     "+"回应信息："+replyText);
                System.out.println("ReturnCallback:     "+"交换机："+exchange);
                System.out.println("ReturnCallback:     "+"路由键："+routingKey);
            }
        });



        return rabbitTemplate;
    }
}
