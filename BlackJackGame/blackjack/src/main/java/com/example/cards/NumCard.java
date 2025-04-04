package com.example.cards;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will information about the number cards
   Sources: Chapter 10, 12, 13, 14, 15, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// Sub class to get the same information for Number card
public class NumCard extends Card {
    public NumCard(String rank, String suit, int value) {
        super(rank,suit,value);
    }

    // Method to get value of Number card
    @Override
    public int getValue() {
        return value;
    }
    
}
