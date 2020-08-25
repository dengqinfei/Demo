package com.hikvision.demo.controller;

import com.deng.demosdkconfig.bic.BicCoreService;
import com.deng.demosdkconfig.bic.dto.NodesList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class BicCoreController {
    private static final Logger logger = LoggerFactory.getLogger(BicCoreController.class);
    @Autowired
    private Environment en;
    @Autowired
    private BicCoreService bicCoreService;

    @GetMapping("/bicCore")
    public String bicCore(HttpServletRequest request, HttpServletResponse response){
        logger.info(request.getRequestURL().toString());
        NodesList nl = bicCoreService.getNodesListByServiceInfo("testfs","f","fs");
        String componentId = nl.getList().get(0).getComponentId();
        logger.info("componentId：{}",componentId);
        return componentId;
    }


}
