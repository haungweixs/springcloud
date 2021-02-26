package com.huangwei.springcloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hw
 * 21/02/24 14:56
 */
@Configuration
public class TopicRabbitConfig {

    //队列名称
    public final static String man="topic.man";
    public final static String womian="topic.woman";

    @Bean
    public Queue firstTopicQueue()
    {
        return new Queue(man,true);
    }

    @Bean
    public Queue secondTopicQueue()
    {
        return new Queue(womian,true);
    }

    @Bean
    TopicExchange topicExchange()
    {
        return new TopicExchange("TopicExchange",true,false);
    }

    @Bean
    Binding firstBinding()
    {
        return BindingBuilder.bind(firstTopicQueue()).to(topicExchange()).with("topic.*");
    }

    @Bean
    Binding secondBinding()
    {
        return BindingBuilder.bind(secondTopicQueue()).to(topicExchange()).with("#.topic");
    }
}
