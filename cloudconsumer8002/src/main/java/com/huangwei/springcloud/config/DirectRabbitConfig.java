package com.huangwei.springcloud.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hw
 * 21/02/23 14:49
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue TestDirectQueue()
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

}
