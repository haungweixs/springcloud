package com.huangwei.springcloud.config;

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


}
