package com.squad.project;

import javafx.application.Application;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunApplication 
{
    public static void main(String[] args) {
        Application.launch(TabApplication.class);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
