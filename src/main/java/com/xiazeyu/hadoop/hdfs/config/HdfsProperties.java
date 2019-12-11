package com.xiazeyu.hadoop.hdfs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "hadoop.hdfs")
public class HdfsProperties {

    private Fs fs;

    private String dfsClientUseDatanodeHostname;

    @Data
    public static class Fs {
        private String defaultFS;
    }

}

