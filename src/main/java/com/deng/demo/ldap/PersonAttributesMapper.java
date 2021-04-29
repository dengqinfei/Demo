package com.deng.demo.ldap;

import org.springframework.ldap.core.AttributesMapper;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class PersonAttributesMapper implements AttributesMapper<Person> {


    @Override
    public Person mapFromAttributes(Attributes attrs) throws NamingException {
        Person person = new Person();
//        person.setPersonName((String)attrs.get("cn").get());
        System.out.println(attrs.get("ou"));
       // person.setOrgId((String)attrs.get("orgId").get());
        return person;

    }
}
