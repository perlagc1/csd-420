/*
Name: Perla Garcia Cavazos
Date: November 24, 2026
Assignment: Module 7 - CSD 420
Description: Displays four circles using an external
CSS stylesheet with style classes and IDs.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Garcia_Mod7 extends Application{

    @Override
    public void start(Stage primaryStage) {

        // Create four circles
        Circle circle1 = new Circle(40);
        Circle circle2 = new Circle(40);
        Circle circle3 = new Circle(40);
        Circle circle4 = new Circle(40);

        // Apply CSS style classes
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().add("plaincircle");

        // Apply CSS IDs
        circle3.setId("redcircle");
        circle4.setId("greencircle");

        // Create a horizontal layout
        HBox pane = new HBox(15);
        pane.setAlignment(Pos.CENTER);

        // Add circles to the layout
        pane.getChildren().addAll(
            circle1, circle2, circle3, circle4
        );

        // Create the scene
        Scene scene = new Scene(pane, 420, 150);

        // Load the external CSS stylesheet
        scene.getStylesheets().add(
            getClass().getResource("mystyle.css")
                .toExternalForm()
        );

        // Display the application
        primaryStage.setTitle("Module 7 - JavaFX CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Garcia_Mod7.class, args);
    }
}