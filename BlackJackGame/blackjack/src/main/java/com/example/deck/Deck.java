package com.example.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.cards.Card;

/* 
   Sean Vang 
   CSC 322
   Session 7 Assignment 7 & 8
   The program will create a virtual blackjack game for a user to play using inheritance, polymorphism, exception handling, abstract classes, JavaFX Basics and UI Tools, Recursion, and Generics
   This file will handle the deck with shuffling, adding and drawing cards, get size of deck
   Sources: Chapter 10, 12, 13, 14, 15, 16, 18, 19, 25, w3schools, GeeksforGeeks, Jenkov, Oracle, Stack Overflow, and openjfx
   I certify, that this computer program submitted by me is all of my own work. Signed: Sean Vang
*/

// The Deck class represents a deck of cards used. 
public class Deck<T extends Card> {
    private List<T> cards = new ArrayList<>();

    // Method to shuffle the deck using Collections.shuffle()
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw the top card from the deck
    public T drawCard() {
        if (cards.isEmpty()) {
            System.out.println("The deck is empty. Cannot draw a card.");
            return null;
        }
        return cards.remove(0);
    }

    // Method to check if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Method to add a card
    public void addCard(T card) {
        cards.add(card);
    }

    // Method to return the size of the deck 
    public int size() {
        return cards.size();
    }
    
}
