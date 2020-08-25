package com.hikvision.demo;

import com.hikvision.demo.template.impl.ProxyHttpConfParseImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ldap.core.LdapTemplate;

@SpringBootTest


public class DemoApplicationTests {
    @MockBean
   private ProxyHttpConfParseImpl proxyHttpConfParseImpl;
    @Autowired
    private LdapTemplate ldapTemplate;
    @Test
   public  void contextLoads() {

        System.out.println(ldapTemplate);

    }

}
