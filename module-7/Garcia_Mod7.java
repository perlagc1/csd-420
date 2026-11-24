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
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Garcia_Mod7 extends Application {

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

        // Create a bordered container for the first circle
        StackPane borderedPane = new StackPane(circle1);
        borderedPane.getStyleClass().add("border");
        borderedPane.setPrefWidth(90);

        // Arrange the four circles horizontally
        HBox pane = new HBox(8);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(
            borderedPane, circle2, circle3, circle4
        );

        // Create the scene and load the external CSS
        Scene scene = new Scene(pane, 400, 330);
        scene.getStylesheets().add(
            getClass().getResource("mystyle.css").toExternalForm()
        );

        // Display the application
        primaryStage.setTitle("Module 7 - JavaFX CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}