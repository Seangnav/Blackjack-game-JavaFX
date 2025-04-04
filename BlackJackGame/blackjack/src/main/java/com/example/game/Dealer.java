package com.example.game;

import java.util.ArrayList;
import java.util.List;

import com.example.cards.Card;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will handle dealer actions 
   Sources: Chapter 10, 12, 13, 14, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// Class to handle dealer information
public class Dealer {
    private List<Card> hand;

    // Constructor
    public Dealer() {
        hand = new ArrayList<>();
    }

    // Method to add a card to the dealer's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Getter method the dealer's hand
    public List<Card> getHand() {
        return hand;
    }

    // Clear the dealer's hand 
    public void clearHand() {
        hand.clear();
    }

    // Print statement
    @Override
    public String toString() {
        return "Dealer Hand: " + hand;
    }
}