package com.simiv1.microservices.limitsservice;

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
    public LimitConfiguration retrieveLimitsFromConfigurations(){

        return  new LimitConfiguration(configuration.getMaximum(),
                configuration.getMinimum());
    }
    
}
