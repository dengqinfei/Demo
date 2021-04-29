package com.deng.demo.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LdapController {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private IPersonRepo personRepo;



    @GetMapping("/ldap/get")
    public String getLdap() {
        System.out.println(ldapTemplate);

        List<Person> persons = personRepo.getAllPersons();
        return persons.toString();
    }
}
