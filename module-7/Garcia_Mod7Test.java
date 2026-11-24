/*
Name: Perla Garcia Cavazos
Date: November 24, 2026
Assignment: Module 7 - CSD 420
Description: Tests the four circles, CSS styles,
fill colors, stroke colors, and bordered container.
*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Garcia_Mod7Test extends Application {

    private int passed = 0;
    private int failed = 0;

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

            // Test the number of layout elements
            check(pane.getChildren().size() == 4,
                  "Four layout elements are displayed");

            // Retrieve the bordered container and circles
            StackPane borderedPane =
                (StackPane) pane.getChildren().get(0);

            Circle circle1 =
                (Circle) borderedPane.getChildren().get(0);

            Circle circle2 =
                (Circle) pane.getChildren().get(1);

            Circle circle3 =
                (Circle) pane.getChildren().get(2);

            Circle circle4 =
                (Circle) pane.getChildren().get(3);

            // Test CSS style classes
            check(circle1.getStyleClass().contains("plaincircle"),
                  "Circle 1 style class");

            check(circle2.getStyleClass().contains("plaincircle"),
                  "Circle 2 style class");

            // Test CSS IDs
            check("redcircle".equals(circle3.getId()),
                  "Circle 3 CSS ID");

            check("greencircle".equals(circle4.getId()),
                  "Circle 4 CSS ID");

            // Test fill colors
            check(Color.WHITE.equals(circle1.getFill()),
                  "Circle 1 white fill");

            check(Color.WHITE.equals(circle2.getFill()),
                  "Circle 2 white fill");

            check(Color.RED.equals(circle3.getFill()),
                  "Circle 3 red fill");

            check(Color.GREEN.equals(circle4.getFill()),
                  "Circle 4 green fill");

            // Test black strokes on white circles
            check(Color.BLACK.equals(circle1.getStroke())
                  && Color.BLACK.equals(circle2.getStroke()),
                  "White circles have black strokes");

            // Test transparent strokes on colored circles
            check(Color.TRANSPARENT.equals(circle3.getStroke())
                  && Color.TRANSPARENT.equals(circle4.getStroke()),
                  "Colored circles have transparent strokes");

            // Test the bordered container
            check(borderedPane.getStyleClass().contains("border"),
                  "Container has border style class");

            check(borderedPane.getBorder() != null
                  && !borderedPane.getBorder().getStrokes().isEmpty()
                  && Color.BLACK.equals(borderedPane.getBorder()
                      .getStrokes().get(0).getTopStroke()),
                  "Container has a black border");

            // Display final test results
            System.out.println("------------------------");
            System.out.println("Tests passed: " + passed);
            System.out.println("Tests failed: " + failed);

            if (failed == 0) {
                System.out.println("All tests passed successfully!");
            } else {
                System.out.println("Some tests failed.");
            }

        } catch (Exception e) {
            System.out.println("Test error: " + e.getMessage());

        } finally {
            stage.close();
            Platform.exit();
        }
    }

    // Helper method to verify each test
    private void check(boolean condition, String description) {
        if (condition) {
            System.out.println("PASS: " + description);
            passed++;
        } else {
            System.out.println("FAIL: " + description);
            failed++;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}