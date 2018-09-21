package com.ecms.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsynchConfig
{
    /**
     * This Function is configuration for (Threads) Task Executor @param @return
     * Executor @throws
     */
    @Bean
    public Executor asynchExecuter()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setQueueCapacity(1000);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(1200);
        executor.setThreadNamePrefix("Sending-Mail-To: ");
        executor.initialize();
        return executor;
    }

}
