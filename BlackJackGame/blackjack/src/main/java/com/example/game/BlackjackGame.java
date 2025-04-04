package com.example.game;

import java.util.ArrayList;
import java.util.List;

import com.example.cards.Card;
import com.example.deck.Deck;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will handle calculations, deck and card recogition, and result of the game
   Sources: Chapter 10, 12, 13, 14, 15, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// Class for blackjack game
public class BlackjackGame {
    private Deck<Card> deck; 
    private List<Card> playerHand; 
    private List<Card> dealerHand; 
    private boolean gameOver; 

    // Constructor
    public BlackjackGame() {
        // Create a new deck
        deck = new Deck<>(); 
        playerHand = new ArrayList<>(); 
        dealerHand = new ArrayList<>(); 
        // Instance to see game is not over yet
        gameOver = false; 
        // Fill the deck with cards and shuffle
        initializeDeck(); 
    }

    // Method to fill the deck with 52 cards and shuffle
    public void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                // Add a new card to the deck based on its rank and suit
                deck.addCard(new Card(rank, suit, getCardValue(rank)));
            }
        }
        deck.shuffle(); 
    }

    // Getter method to get the value of a card 
    public int getCardValue(String rank) {
        switch (rank) {
            case "Jack":
            case "Queen":
            case "King":
                return 10; 
            case "Ace":
                return 11; 
            default:
                return Integer.parseInt(rank); 
        }
    }

    // Method to start a new game
    public void startGame() {
        playerHand.clear(); 
        dealerHand.clear(); 
        deck.shuffle(); 
        // Reset the game state
        gameOver = false; 

        // Deal two cards to the player and dealer
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
    }

    // Method that lets player draws a card
    public void playerHit() {
        if (!gameOver) {
            playerHand.add(deck.drawCard()); 
            // Check if the player busts
            if (calculateHandValue(playerHand) > 21) { 
                // End the game
                gameOver = true; 
            }
        }
    }

    // Method for player ends their turn
    public void playerStand() {
        if (!gameOver) {
            // End the player's turn
            gameOver = true; 
            dealerTurn(); 
        }
    }

    // Method for dealer cards until their hand amount is at least 17
    public void dealerTurn() {
        while (calculateHandValue(dealerHand) < 17) {
            dealerHand.add(deck.drawCard()); 
        }
    }

    // Method to find amount in card hand
    public int calculateHandValue(List<Card> hand) {
        int value = 0; 
        int aceCount = 0; 

        // Loop through each card in the hand
        for (Card card : hand) {
            String rank = card.getRank(); 

            switch (rank) {
                case "Jack":
                case "Queen":
                case "King":
                    value += 10; 
                    break;
                case "Ace":
                    // Aces are worth 11 by default
                    value += 11; 
                    // Track the number of Aces because it can be 1 or 11
                    aceCount++; 
                    break;
                default:
                    value += Integer.parseInt(rank); 
                    break;
            }
        }

    // Fix the value of Aces if the hand total is over 21
    while (value > 21 && aceCount > 0) {
        // Count Ace as 1 instead of 11
        value -= 10; 
        aceCount--;
    }

    return value; 
    }

    

    // Method to determine the winner
    public String determineWinner() {
        int playerValue = calculateHandValue(playerHand);
        int dealerValue = calculateHandValue(dealerHand);

        if (playerValue > 21) {
            return "Dealer wins! You busted.";
        } else if (dealerValue > 21) {
            return "You win! Dealer busted.";
        } else if (playerValue > dealerValue) {
            return "You win!";
        } else if (playerValue < dealerValue) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }

    // Getters methods for player and dealer hands
    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    // Check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Method to get deck size for later
    public Deck<Card> getDeck() {
        return deck;
    }

    // Main method for program to start in text and show elements
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
    
        System.out.println("Player Hand: " + game.getPlayerHand());
        System.out.println("Dealer Hand: " + game.getDealerHand());
        
        System.out.println("Cards left in the deck: " + game.getDeck().size());
        
        game.playerHit();
        System.out.println("Player Hand after hit: " + game.getPlayerHand());
        
        game.playerStand();
        System.out.println("Dealer Hand after stand: " + game.getDealerHand());
    
        System.out.println(game.determineWinner());
    }
    
}