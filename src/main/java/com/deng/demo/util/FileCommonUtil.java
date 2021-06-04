package com.deng.demo.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileCommonUtil {

    public static void main(String[] args) throws Exception {

        String templatePath = "D:\\project\\gitProject\\haManager\\hamanager-master\\output\\document\\resource\\hebei\\componentId\\";
        String filePath = "D:\\project\\gitProject\\haManager\\hamanager-master\\output\\document\\template";
        String writePath = "D:\\project\\gitProject\\haManager\\hamanager-master\\output\\document\\template2";
        File writeFilePath = new File(writePath);
        if (!writeFilePath.exists()){
            writeFilePath.mkdirs();
        }
        File file = new File(filePath);
        File[] cfile = file.listFiles();
        for (File ccfile:cfile){
            String componentId = ccfile.getName();
            componentId = componentId.split("\\.")[0];
            File componentIdFile = new File(writePath+File.separator+componentId);

            if (!componentIdFile.exists()){
                componentIdFile.mkdir();
            }

            File metaInfPathsFile = new File(templatePath+File.separator+"META-INF");
            File metaInfsPathsFile = new File(writePath+File.separator+componentId+File.separator+"META-INF");
            if (!metaInfsPathsFile.exists()){
                metaInfsPathsFile.mkdir();
            }
            FileUtils.copyDirectory(metaInfPathsFile,metaInfsPathsFile);
            File packageInfo = new File(writePath+File.separator+componentId+File.separator+"META-INF"+File.separator+"packageinfo.xml");
            String packageInfoContent = FileUtils.readFileToString(packageInfo,"utf-8");
            String newString = packageInfoContent.replaceAll("componentId",componentId);
            FileUtils.writeStringToFile(packageInfo,newString,"utf-8");
            File scriptFile = new File(ccfile.getAbsolutePath()+File.separator+"script");
            File[] cccfile = scriptFile.listFiles();
            for (File sfile:cccfile){
                String ssfile = sfile.getName();
                File serviceFile = new File(writePath+File.separator+componentId+File.separator+ssfile);
                if (!serviceFile.exists()){
                    serviceFile.mkdir();
                }
                File templatePathsFile = new File(templatePath+File.separator+"serviceId");
                FileUtils.copyDirectory(templatePathsFile,serviceFile);

            }
        }
    }
}
