package com.huangwei.springcloud.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by Hw
 * 21/02/23 14:49
 */
@Configuration
public class DirectRabbitConfig {

    @Resource
    private CachingConnectionFactory connectionFactory;
    //消息接受类
    @Resource
    private MyAckReceiver myAckReceiver;

    @Bean
    public  Queue TestDirectQueue()
    {
        return new Queue("TestDirectQueue",true);
    }

    @Bean
    DirectExchange TestDirectExchange()
    {
        return new DirectExchange("TestDirectExchange");
    }

    @Bean
    Binding bindingDirect()
    {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer()
    {
        SimpleMessageListenerContainer container=new SimpleMessageListenerContainer(connectionFactory);
        //设置监听数据
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        //设置签收模式
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //设置一个队列
        container.setQueues(TestDirectQueue());
        //设置是否重回队列
        container.setDefaultRequeueRejected(false);
        container.setMessageListener(myAckReceiver);
        return  container;
    }
}
