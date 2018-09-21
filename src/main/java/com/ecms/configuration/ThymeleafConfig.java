package com.ecms.configuration;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;

/**
 * This Class Acts as Configuration For Thymeleaf Templating Engine.
 * 
 * @author nagpalh
 */
@EnableWebMvc
@ComponentScan(basePackages = "com.ecms")
@Configuration
public class ThymeleafConfig
{

    /**
     * This Function Create Object that will Process Templates(or HTML Pages).
     * 
     * @return SpringTemplateEngine
     */
    @Bean(name = "templateEngine")
    public SpringTemplateEngine springTemplateEngine()
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());
        return templateEngine;
    }


    /**
     * This Function is used in creating SpringTemplateEngine Object.
     * 
     * @return SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver()
    {
        SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
        emailTemplateResolver.setPrefix("classpath:/templates/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode(StandardTemplateModeHandlers.HTML5.getTemplateModeName());
        emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return emailTemplateResolver;
    }
}
