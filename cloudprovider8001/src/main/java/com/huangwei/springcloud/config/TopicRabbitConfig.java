package com.huangwei.springcloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hw
 * 21/02/24 9:48
 */
@Configuration
public class TopicRabbitConfig {
    //绑定键
    public final static String man="topic.man";
    public final static String woman="topic.woman";

    @Bean
    public Queue firstQueue()
    {
        return new Queue(man);
    }

    @Bean
    public Queue secondQueue()
    {
        return new Queue(woman);
    }

    @Bean
    TopicExchange TestTopicExchange()
    {
        return new TopicExchange("TopicExchange",true,false);
    }

    @Bean
    Binding firstBindingRouting()
    {
        return BindingBuilder.bind(firstQueue()).to(TestTopicExchange()).with("topic.*");
    }

    /**
     * 简单地介绍下规则：

     *  (星号) 用来表示一个单词 (必须出现的)
     #  (井号) 用来表示任意数量（零个或多个）单词
     通配的绑定键是跟队列进行绑定的，举个小例子
     队列Q1 绑定键为 TT.*          队列Q2绑定键为  TT.#
     如果一条消息携带的路由键为 TT.BA，那么队列Q1将会收到 但是为TT.B.A就收不到了；
     如果一条消息携带的路由键为TT.AA.BB，那么队列Q2将会收到；
     * */

    @Bean
    Binding secondBindingRouting()
    {
        return  BindingBuilder.bind(secondQueue()).to(TestTopicExchange()).with("#.topic");
    }

}
