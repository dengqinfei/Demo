package com.hikvision.demo.ldap;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import java.util.List;

@Service
@Data
public class PersonRepoImpl implements IPersonRepo {

    @Autowired
    private LdapTemplate ldapTemplate;


    @Override
    public List<Person> getAllPersons() {
        return ldapTemplate.search(LdapQueryBuilder.query()
                .where("objectclass").is("organizationalUnit"), new PersonAttributesMapper());
    }

    @Override
    public void setPersons() {

        // 基类设置
        BasicAttribute ocattr = new BasicAttribute("objectClass");
        ocattr.add("top");
        ocattr.add("person");
        ocattr.add("uidObject");
        ocattr.add("inetOrgPerson");
        ocattr.add("organizationalPerson");
        // 用户属性
        Attributes attrs = new BasicAttributes();
        attrs.put(ocattr);
        attrs.put("cn", "fdsf");
        attrs.put("sn", "admin");
        attrs.put("telephoneNumber", "fd");
        attrs.put("title", "sdfe");
        attrs.put("userPassword", "Abc123++");
       //ldapTemplate..setContextSource().bind("uid=" + "adminds".trim(), null, attrs);


    }

}
