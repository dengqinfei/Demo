package com.hikvision.demo;

import com.hikvision.demo.config.RedisConfig;
import com.hikvision.demo.config.ZookeeperConfig;
import com.hikvision.demo.redis.RedisLock;
import com.hikvision.demo.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication
//@ComponentScan(basePackages = {"com.hikvision.demo.springSourceCode","com.hikvision.demo.ldap","com.hikvision.demo.springLdap"})
@ComponentScan(basePackages = {"com.hikvision.demo"},excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {RedisLock.class, RedisUtil.class, RedisConfig.class, ZookeeperConfig.class}))
@SpringBootApplication(exclude={
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
public class DemoApplication  {
//extends SpringBootServletInitializer
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
   //@Override
   //protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
   //    return application.sources(DemoApplication.class);
   //}

   //@Override
   //public void onStartup(ServletContext sc) {

   //    sc.addListener(new SingleSignOutHttpSessionListener());

   //    FilterRegistration.Dynamic cASLogoutFilter = sc.addFilter("CASLogoutFilter", SingleSignOutFilter.class);

   //    cASLogoutFilter.addMappingForUrlPatterns(null, false, "/*");

   //    FilterRegistration.Dynamic cASAuthenticationFilter = sc.addFilter("CAS Authentication Filter", HikAuthenticationFilter.class);

   //    cASAuthenticationFilter.addMappingForUrlPatterns(null, false, "/*");

   //    FilterRegistration.Dynamic cas20Registration = sc.addFilter("CAS Validation Filter", HikCas20ProxyReceivingTicketValidationFilter.class);

   //    cas20Registration.setInitParameter("encoding", "UTF-8");

   //    cas20Registration.addMappingForUrlPatterns(null, false, "/*");

   //}
}
