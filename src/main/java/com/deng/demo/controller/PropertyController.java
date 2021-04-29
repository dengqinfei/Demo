package com.deng.demo.controller;

import cn.hutool.core.lang.Dict;
import com.deng.demo.dataProperties.DemoProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {


    private final DemoProperty demoProperty;


    @Autowired
    public PropertyController(DemoProperty demoProperty) {
        this.demoProperty = demoProperty;

    }

    /**
     * envirment先加载，这个name值取application.properties当中的，value值如果application.properties不存在，就取defaultValue值
     */


    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("demoProperty", demoProperty);
    }
}
