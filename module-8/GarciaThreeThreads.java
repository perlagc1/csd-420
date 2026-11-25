/*
 * Name: Perla Garcia Cavazos
 * Date: November 25, 2026
 * Course: CSD 420 - Advanced Java Programming
 * Assignment: Module 8 - Three Threads
 * Description: This program uses three threads to generate
 * random letters, digits, and special characters and
 * display them concurrently in a JavaFX text area.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.util.Random;

public class GarciaThreeThreads extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create the text area for displaying random characters
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);

        // Create and display the application window
        Scene scene = new Scene(textArea, 800, 500);
        primaryStage.setTitle("Three Random Character Threads");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create a thread to generate 10,000 random letters
        Thread letterThread = new Thread(() -> {
            Random random = new Random();

            for (int i = 0; i < 10000; i++) {
                char letter = (char) ('a' + random.nextInt(26));

                Platform.runLater(() -> {
                    textArea.appendText(String.valueOf(letter));
                });

                // Briefly pause to reduce UI overload
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        // Create a thread to generate 10,000 random digits
        Thread digitThread = new Thread(() -> {
            Random random = new Random();

            for (int i = 0; i < 10000; i++) {
                char digit = (char) ('0' + random.nextInt(10));

                Platform.runLater(() -> {
                    textArea.appendText(String.valueOf(digit));
                });

                // Briefly pause to reduce UI overload
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        // Create a thread to generate 10,000 random special characters
        Thread specialThread = new Thread(() -> {
            Random random = new Random();
            String specialCharacters = "!@#$%&*";

            for (int i = 0; i < 10000; i++) {
                char special = specialCharacters.charAt(
                        random.nextInt(specialCharacters.length()));

                Platform.runLater(() -> {
                    textArea.appendText(String.valueOf(special));
                });

                // Briefly pause to reduce UI overload
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        // Allow the application to close without waiting for the threads
        letterThread.setDaemon(true);
        digitThread.setDaemon(true);
        specialThread.setDaemon(true);

        // Start all three threads concurrently
        letterThread.start();
        digitThread.start();
        specialThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}