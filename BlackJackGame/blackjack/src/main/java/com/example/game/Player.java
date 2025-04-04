package com.example.game;

import java.util.ArrayList;
import java.util.List;

import com.example.cards.Card;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will handle player actions 
   Sources: Chapter 10, 12, 13, 14, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// Class for player
public class Player {
    private List<Card> hand;

    // Constructor
    public Player() {
        hand = new ArrayList<>();
    }

    // Add a card to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Getter method to the player's hand
    public List<Card> getHand() {
        return hand;
    }


    // Clear the player's hand for a new round
    public void clearHand() {
        hand.clear();
    }

    // Print Statement
    @Override
    public String toString() {
        return "Player Hand: " + hand;
    }
}