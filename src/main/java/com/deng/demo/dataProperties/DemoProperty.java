package com.deng.demo.dataProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "demo.data")
public class DemoProperty {
    private String name;
    //envirment先加载，这个name值取application.properties当中的，value值如果application.properties不存在，就取defaultValue值
    private String value = "defaultValue";




}