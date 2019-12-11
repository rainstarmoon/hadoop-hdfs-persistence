package com.xiazeyu.hadoop.hdfs.config;

import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HdfsConfig {

    @Autowired
    private HdfsProperties hdfsProperties;

    @Bean
    public org.apache.hadoop.conf.Configuration configuration() {
        org.apache.hadoop.conf.Configuration config = new org.apache.hadoop.conf.Configuration();
        config.set("fs.defaultFS", hdfsProperties.getFs().getDefaultFS());
        config.set("dfs.client.use.datanode.hostname", hdfsProperties.getDfsClientUseDatanodeHostname());
        return config;
    }

    @Bean
    public FileSystem fileSystem(org.apache.hadoop.conf.Configuration config) {
        FileSystem fileSystem = null;
        try {
            fileSystem = FileSystem.get(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileSystem;
    }

}
