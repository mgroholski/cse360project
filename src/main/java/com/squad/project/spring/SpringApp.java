package com.squad.project.spring;

import com.squad.project.RunApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringApp
{
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
}
