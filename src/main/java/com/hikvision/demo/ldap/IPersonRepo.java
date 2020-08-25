package com.hikvision.demo.ldap;

import java.util.List;

public interface IPersonRepo {

    List<Person> getAllPersons();
    void setPersons();
}
