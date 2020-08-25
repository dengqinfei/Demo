package com.hikvision.demo;

import com.hikvision.demo.ldap.IPersonRepo;
import com.hikvision.demo.ldap.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LdapTest {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private IPersonRepo personRepo;

    //@Before
    //public void init(){
    //    personRepo = new PersonRepoImpl();
    //    personRepo.setLdapTemplate(ldapTemplate);
    //}

    // @Resource(name = "personRepoImpl")
    // private IPersonRepo ipersonRepo;

    @Test
    public void testLdap() {
        System.out.println(ldapTemplate);

        List<Person> persons = personRepo.getAllPersons();
        System.out.println(persons);
    }

    protected Name buildDn(Person person) {
        return buildDn(person.getOu(), person.getCompany(), person.getCertNo());
    }

    protected Name buildDn(String fullname, String company, String country) {
        return LdapNameBuilder.newInstance()
                .add("c", country)
                .add("ou", company)
                .add("cn", fullname)
                .build();
    }
    @Test
    public void testSetLdap() {
        Person p = new Person();
        Name dn = buildDn(p);
        DirContextAdapter context = new DirContextAdapter(dn);

        context.setAttributeValues("objectclass", new String[] {"top", "person"});
        context.setAttributeValue("cn", p.getCompany());
        context.setAttributeValue("sn", p.getStatus());
        context.setAttributeValue("description", p.getCertNo());

        ldapTemplate.bind(context);

    }


}



