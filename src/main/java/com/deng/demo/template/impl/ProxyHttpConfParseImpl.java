package com.deng.demo.template.impl;

import com.deng.demo.template.ConfigParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service("proxyHttpConfParse")
public class ProxyHttpConfParseImpl implements ConfigParse {
    private static final Logger log = LoggerFactory.getLogger(ProxyHttpConfParseImpl.class);
    @Autowired
    private TemplateEngine textTemplateEngine;
    @Autowired
    private Context context;

    @PostConstruct
    public void init(){
        log.info("init");

    }

    @Override
    public String getParseContent(Map<String,Object> Variables) {

        context.setVariables(Variables);
        String result = textTemplateEngine.process("proxy_webPort",context);
        return result;
    }
}
