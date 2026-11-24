/*
Name: Perla Garcia Cavazos
Date: November 24, 2026
Assignment: Module 7 - CSD 420
Description: Tests the four circles and verifies
that the external CSS styles are applied correctly.
*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Garcia_Mod7Test extends Application {

    @Override
    public void start(Stage stage) {

        try {
            // Start the original application
            Garcia_Mod7 program = new Garcia_Mod7();
            program.start(stage);

            // Apply the external CSS styles
            HBox pane = (HBox) stage.getScene().getRoot();
            pane.applyCss();

            System.out.println("Module 7 - Test Results");
            System.out.println("------------------------");

            // Test the number of circles
            check(pane.getChildren().size() == 4,
                "Four circles are displayed");

            Circle circle1 = (Circle) pane.getChildren().get(0);
            Circle circle2 = (Circle) pane.getChildren().get(1);
            Circle circle3 = (Circle) pane.getChildren().get(2);
            Circle circle4 = (Circle) pane.getChildren().get(3);

            // Test the style classes
            check(circle1.getStyleClass().contains("plaincircle"),
                "Circle 1 style class");

            check(circle2.getStyleClass().contains("plaincircle"),
                "Circle 2 style class");

            // Test the CSS IDs
            check("redcircle".equals(circle3.getId()),
                "Circle 3 CSS ID");

            check("greencircle".equals(circle4.getId()),
                "Circle 4 CSS ID");

            // Test the fill colors
            check(Color.WHITE.equals(circle1.getFill()),
                "Circle 1 white fill");

            check(Color.WHITE.equals(circle2.getFill()),
                "Circle 2 white fill");

            check(Color.RED.equals(circle3.getFill()),
                "Circle 3 red fill");

            check(Color.GREEN.equals(circle4.getFill()),
                "Circle 4 green fill");

            // Test the stroke colors
            check(Color.BLACK.equals(circle1.getStroke())
                && Color.BLACK.equals(circle2.getStroke())
                && Color.BLACK.equals(circle3.getStroke())
                && Color.BLACK.equals(circle4.getStroke()),
                "All circles have black strokes");

            System.out.println("------------------------");
            System.out.println("All tests passed successfully!");

        } finally {
            stage.close();
            Platform.exit();
        }
    }

    // Verify each test condition
    private void check(boolean condition, String testName) {
        if (condition) {
            System.out.println("PASS: " + testName);
        } else {
            throw new AssertionError("FAIL: " + testName);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}