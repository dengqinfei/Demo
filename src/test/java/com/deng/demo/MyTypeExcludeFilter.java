package com.deng.demo;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

public class MyTypeExcludeFilter extends TypeExcludeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {

        if("com.deng.demo.template.impl.ProxyHttpConfParseImpl".equals(metadataReader.getClassMetadata().getClassName())){
            return true;
        }

        return false;
    }

}