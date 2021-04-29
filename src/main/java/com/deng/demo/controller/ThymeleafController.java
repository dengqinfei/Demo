package com.deng.demo.controller;

import com.deng.demo.template.ConfigParse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ThymeleafController {

    @Autowired
    private ConfigParse proxyHttpConfParse;

    @GetMapping("/template")
    public String getProxyHttpConfContent(){
        Map<String,Object> map = new HashMap<>();
        map.put("ip","10.23.54.5");
        map.put("componentId","clusterrere");
        return proxyHttpConfParse.getParseContent(map);


    }

}
