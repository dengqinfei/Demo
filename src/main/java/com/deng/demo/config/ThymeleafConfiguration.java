package com.deng.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * <p>
 * thymeleaf的自动配置类，用户模板的字符串填充
 * </p>
 * @author: zhu.chen
 * @date: 2019/11/19
 * @version: v1.0.0
 */
@Configuration
public class ThymeleafConfiguration {



    @Bean
    public TemplateEngine textTemplateEngine(ClassLoaderTemplateResolver resolver) {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addTemplateResolver(resolver);
        return templateEngine;
    }

    @Bean
    public ClassLoaderTemplateResolver resolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".conf");
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCheckExistence(true);
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public Context context() {
        Context context = new Context();

        return context;
    }

}
