package com.ecms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Entry Point of Application
 * 
 * @author nagpalh
 */

@EnableAsync
@EnableSwagger2
@SpringBootApplication
// @EnableDiscoveryClient
public class MicroserviceEcmsNotificationApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MicroserviceEcmsNotificationApplication.class, args);
    }

}
