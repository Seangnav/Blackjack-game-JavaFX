package com.example.cards;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will will handle calculations of the cards and recogition of suit, rank, and value
   Sources: Chapter 10, 12, 13, 14, 15, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// Class to initialize rank, suit, and value 
public class Card {
    public String rank;
    public String suit;
    public int value;

    // Constructor 
    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    // Getter method to get the rank of the card
    public String getRank() {
        return rank;
    }

    // Getter method to get the suit of the card
    public String getSuit() {
        return suit;
    }

    // Getter method to get value of card
    public int getValue() {
        return value;
    }

    // Method to print
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}