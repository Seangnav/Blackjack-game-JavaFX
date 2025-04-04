package com.example.cards;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will handle information about the facecards
   Sources: Chapter 10, 12, 13, 14, 15, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// Sub class to get the same information for FaceCard
public class FaceCard extends Card {
    public FaceCard(String rank, String suit) {
        super(rank,suit, 10);
    }

    // Getter method to get value of face cards
    @Override
    public int getValue() {
        return value;
    }
}

