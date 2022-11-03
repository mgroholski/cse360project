module com.squad.project {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.squad.project to javafx.fxml;
    exports com.squad.project;
}