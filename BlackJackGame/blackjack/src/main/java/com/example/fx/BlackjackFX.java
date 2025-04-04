package com.example.fx;

import com.example.cards.Card;
import com.example.game.BlackjackGame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will create the UI of the Blackjack game
   Sources: Chapter 10, 12, 13, 14, 15, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

public class BlackjackFX extends Application {
    // Controll the game logic
    private BlackjackGame game; 
    private Label playerScoreLabel; 
    private Label dealerScoreLabel; 
    private HBox playerCardLayout; 
    private HBox dealerCardLayout; 
    private Label resultLabel; 
    private Button playAgainButton; 

    @Override
    public void start(Stage primaryStage) {
        // Initialize the game
        game = new BlackjackGame();
        game.startGame();

        // Title label with special font, color and size
        Label titleLabel = new Label("Welcome to Blackjack!");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.GOLD);

        // Player Score label with special font, color and size
        playerScoreLabel = new Label("Player Score: " + game.calculateHandValue(game.getPlayerHand()));
        playerScoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        playerScoreLabel.setTextFill(Color.WHITE);

        // Dealer Score label with special font, color and size
        dealerScoreLabel = new Label("Dealer Score: " + game.calculateHandValue(game.getDealerHand()));
        dealerScoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        dealerScoreLabel.setTextFill(Color.WHITE);

        // Result label with special font, color, and certain visiblity
        resultLabel = new Label();
        resultLabel.setFont(Font.font("Arial", 20));
        resultLabel.setTextFill(Color.GOLD);
        resultLabel.setVisible(false); // Hide initially

        // Hit button with color, style, size and width
        Button hitButton = new Button("Hit");
        hitButton.setStyle("-fx-background-color: yellowgreen; -fx-text-fill: white;");
        hitButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
        // Stand button with color, style, size and width
        Button standButton = new Button("Stand");
        standButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        standButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        // Play Again button with color, style, size, and certain visibility. 
        playAgainButton = new Button("Play Again");
        playAgainButton.setStyle("-fx-background-color: powderblue; -fx-text-fill: white;");
        playAgainButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        playAgainButton.setVisible(false); 

        // Horizontal layout for player's cards
        playerCardLayout = new HBox(10); 
        playerCardLayout.setAlignment(Pos.CENTER);

        // Horizontal layout for dealer's cards
        dealerCardLayout = new HBox(10); 
        dealerCardLayout.setAlignment(Pos.CENTER);

        updateCardDisplay();

        // Hit button action that allows player to add a card and update the game display. When game is over, results are displayed. 
        hitButton.setOnAction(e -> {
            game.playerHit(); 
            updateCardDisplay(); 
            // Check if the player busts
            if (game.isGameOver()) { 
                showResult(hitButton, standButton);
            }
        });

        // Stand button action that allows player to stand and update game display, Displays results if lost. 
        standButton.setOnAction(e -> {
            game.playerStand(); 
            updateCardDisplay(); 
            showResult(hitButton, standButton);
        });

        // Play Again button action that starts a new game with buttons (shows different visibilites)
        playAgainButton.setOnAction(e -> {
            game.startGame(); 
            updateCardDisplay(); 
            // Hide or disable buttons
            resultLabel.setVisible(false); 
            playAgainButton.setVisible(false); 
            hitButton.setDisable(false); 
            standButton.setDisable(false); 
        });

        // Create a layout for buttons
        HBox buttonLayout = new HBox(20, hitButton, standButton, playAgainButton);
        buttonLayout.setAlignment(Pos.CENTER);

        // Main layout for JavaFX elements
        VBox tableLayout = new VBox(20, titleLabel, dealerScoreLabel, dealerCardLayout, playerScoreLabel, playerCardLayout, buttonLayout, resultLabel);
        tableLayout.setAlignment(Pos.CENTER);
        tableLayout.setPadding(new Insets(20));

        // Load the background image
        Image backgroundImage = new Image("file:blackjack/images/BJTable.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        // Set the image to fit the entire pane
        backgroundImageView.setFitWidth(800); 
        backgroundImageView.setFitHeight(600); 

        // Stretch the image to fit
        backgroundImageView.setPreserveRatio(false); 

        // Create a StackPane to hold the background and JavaFX elements
        StackPane root = new StackPane();
        // Adds background image then JavaFX elements
        root.getChildren().addAll(backgroundImageView, tableLayout); 

        // Creating the scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Blackjack Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to update the card display for player and dealer
    public void updateCardDisplay() {
        playerCardLayout.getChildren().clear(); 
        dealerCardLayout.getChildren().clear(); 

        // Display player's cards from folder
        for (Card card : game.getPlayerHand()) {
            String imagePath = "file:blackjack/images/cards/" + getShorthandName(card) + ".gif";
            ImageView cardView = loadCardImage(imagePath);
            // Add the card to the layout
            playerCardLayout.getChildren().add(cardView); 
        }

        // Display dealer's cards from folder
        for (Card card : game.getDealerHand()) {
            String imagePath = "file:blackjack/images/cards/" + getShorthandName(card) + ".gif";
            ImageView cardView = loadCardImage(imagePath);
            // Add the card to the layout
            dealerCardLayout.getChildren().add(cardView); 
        }

        // Update scores
        playerScoreLabel.setText("Player Score: " + game.calculateHandValue(game.getPlayerHand()));
        dealerScoreLabel.setText("Dealer Score: " + game.calculateHandValue(game.getDealerHand()));
    }

    // Method to load a card image
    public ImageView loadCardImage(String imagePath) {
        ImageView cardView = new ImageView(); // Initialize ImageView upfront
        try {
            Image cardImage = new Image(imagePath);
            cardView.setImage(cardImage); // Set image after loading
            cardView.setFitWidth(100);
            cardView.setPreserveRatio(true);
        } catch (Exception e) {
            System.err.println("Failed to load image: " + imagePath);
        }
        return cardView; // Doesnt work if it is empty
    }
    

    // Method to convert card name to shorthand format to read
    public String getShorthandName(Card card) {
        String rank = card.getRank().toLowerCase();
        String suit = card.getSuit().toLowerCase();

        // Convert rank to shorthand
        switch (rank) {
            case "jack":
                rank = "j";
                break;
            case "queen":
                rank = "q";
                break;
            case "king":
                rank = "k";
                break;
            case "ace":
                rank = "a";
                break;
            default:
                break;
        }

        // Convert suit to shorthand
        switch (suit) {
            case "hearts":
                suit = "h";
                break;
            case "diamonds":
                suit = "d";
                break;
            case "clubs":
                suit = "c";
                break;
            case "spades":
                suit = "s";
                break;
            default:
                throw new IllegalArgumentException("Invalid suit: " + suit);
        }

        return rank + suit;
    }

    // Display the game result
    public void showResult(Button hitButton, Button standButton) {
        String result = game.determineWinner();
        resultLabel.setText(result); 
        resultLabel.setVisible(true); 

        // Disable hit and stand buttons 
        hitButton.setDisable(true);
        standButton.setDisable(true);

        playAgainButton.setVisible(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
