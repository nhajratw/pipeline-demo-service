package com.chikli.pipelinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses=PipelineDemoConfiguration.class)
public class PipelineDemoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(PipelineDemoConfiguration.class, args);
    }
}