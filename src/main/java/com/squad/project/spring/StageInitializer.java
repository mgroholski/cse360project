package com.squad.project.spring;


import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import com.squad.project.TabApplication.StageReadyEvent;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
    }
}
