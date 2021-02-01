package com.huangwei.springcloud.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hw
 * 21/01/22 15:15
 */
@Configuration
public class ApplicationContexConfig {

    @Bean
    public RestTemplate getRestTemplate()
    {
        return  new RestTemplate();
    }

    @Bean
    public SentinelResourceAspect sentinelResourceAspect()
    {
        return new SentinelResourceAspect();
    }
}
