package com.example.cards;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will will handle calculations of the ace card
   Sources: Chapter 10, 12, 13, 14, 15, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// Sub class to get the same information for Ace
public class Ace extends Card {
    public Ace(String rank, String suit) {
        super(rank, suit, 11);
    }

    // Getter method to get value of card
    @Override
    public int getValue() {
        return value;
    }

    // Setter method to set value, could be a 1 or 11
    public void setValue(int value) {
        if (value == 1 || value == 11) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Ace value must be 1 or 11");
        }
    }
}
