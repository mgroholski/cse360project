package com.squad.project;

import javafx.application.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.squad.project.spring.DTO.*;

@SpringBootApplication
public class RunApplication 
{
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
        Application.launch(TabApplication.class);
    }
}
