
/*
 * Name: Perla Garcia Cavazos
 * Date: October 21, 2026
 * Assignment: CSD 420 - Module 1 - JavaFX Cards
 *
 * Description:
 * Displays four randomly selected playing cards from
 * a deck of 52 cards. Clicking the Refresh Cards button
 * displays a new set of four cards.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garcia_Mod1_Cards extends Application {

    private final HBox cardBox = new HBox(15);
    private List<Integer> previousCards = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        cardBox.setAlignment(Pos.CENTER);

        Button refreshButton = new Button("Refresh Cards");

        // Lambda expression handles the button click.
        refreshButton.setOnAction(event -> displayRandomCards());

        VBox root = new VBox(25, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));

        displayRandomCards();

        Scene scene = new Scene(root, 650, 300);

        primaryStage.setTitle("CSD 420 - Random Playing Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Selects four unique cards, different from the previous set.
    private void displayRandomCards() {

        List<Integer> deck = new ArrayList<>();

        for (int i = 1; i <= 52; i++) {
            if (!previousCards.contains(i)) {
                deck.add(i);
            }
        }

        Collections.shuffle(deck);

        List<Integer> selectedCards =
                new ArrayList<>(deck.subList(0, 4));

        cardBox.getChildren().clear();

        for (int cardNumber : selectedCards) {

            String imagePath = "/cards/" + cardNumber + ".png";

            Image image = new Image(
                    getClass().getResource(imagePath).toExternalForm()
            );

            ImageView cardView = new ImageView(image);
            cardView.setFitHeight(180);
            cardView.setPreserveRatio(true);

            cardBox.getChildren().add(cardView);
        }

        previousCards = selectedCards;
    }

    public static void main(String[] args) {
        launch(args);
    }
}