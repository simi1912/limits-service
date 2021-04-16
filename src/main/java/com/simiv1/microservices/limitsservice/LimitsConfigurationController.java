package com.simiv1.microservices.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.simiv1.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    public LimitsConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    private Configuration configuration;

    @GetMapping("/limits")
    @HystrixCommand(fallbackMethod = "fallbackRetrieve")
    public LimitConfiguration retrieveLimitsFromConfigurations(){

        return  new LimitConfiguration(configuration.getMaximum(),
                configuration.getMinimum());
    }

    @GetMapping("/fault-tolerance")
    @HystrixCommand(fallbackMethod = "fallbackRetrieve")
    public LimitConfiguration retrieveConfiguration(){
        throw new RuntimeException("");
    }

    public LimitConfiguration fallbackRetrieve(){
        return new LimitConfiguration(999,9);
    }
    
}
