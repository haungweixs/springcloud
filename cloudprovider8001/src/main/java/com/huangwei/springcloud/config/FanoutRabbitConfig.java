package com.huangwei.springcloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hw
 * 21/02/24 16:19
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue QueueOne()
    {
        return new Queue("fanoutQueue1");
    }

    @Bean
    public Queue QueuqTwo()
    {
        return new Queue("fanoutQueue2");
    }


    @Bean
    FanoutExchange fanoutExchange()
    {
        return new FanoutExchange("FanoutExchange");
    }

    @Bean
    Binding bindingOne()
    {
        return BindingBuilder.bind(QueueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo()
    {
        return BindingBuilder.bind(QueuqTwo()).to(fanoutExchange());
    }


}
