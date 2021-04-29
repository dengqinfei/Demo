package com.deng.demo.springLdap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.pool2.factory.PoolConfig;
import org.springframework.ldap.pool2.factory.PooledContextSource;
import org.springframework.ldap.pool2.validation.DefaultDirContextValidator;


@Configuration
public class LdapConfig {

    @Bean
    public LdapTemplate  ldapTemplate(){
        LdapTemplate template = null;


        LdapContextSource contextSource = new LdapContextSource();
      //  String url = "ldap://10.19.131.23:8443";
        String base = "dc=platform,dc=deng,dc=com";
        String userDn = "cn=Manager,dc=deng,dc=com";
        String password = "1vYahCrT";
        String[] urls = new String[]{"ldap://10.19.131.13:7002","ldap://10.19.131.23:7003","ldap://10.19.131.13:7003"};
        contextSource.setUrls(urls);
      //  contextSource.setUrl(url);
        contextSource.setBase(base);
        contextSource.setUserDn(userDn);
        contextSource.setPassword(password);
        contextSource.setPooled(false);
        contextSource.afterPropertiesSet(); // important
        PoolConfig poolConfig = new PoolConfig();
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestWhileIdle(true);
        PooledContextSource poolingContextSource = new PooledContextSource(poolConfig);
        poolingContextSource.setDirContextValidator(new DefaultDirContextValidator());
        poolingContextSource.setContextSource(contextSource);
        template = new LdapTemplate(poolingContextSource);
        System.out.println("dsf");
        return template;
}
    }





