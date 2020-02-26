package com.ypf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ypf.mapper")
public class LinuxLearnPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinuxLearnPlatformApplication.class, args);
    }

}
