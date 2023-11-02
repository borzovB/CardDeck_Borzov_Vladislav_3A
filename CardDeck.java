package com.mycompany.carddeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс CardDeck представляет собой модель колоды карт.
public class CardDeck {
    private List<Card> deck; // Хранилище для карт.

    // Конструктор класса CardDeck инициализирует колоду и заполняет ее картами.
    public CardDeck() {
        deck = new ArrayList<>();
        initializeDeck();
    }

    // Метод initializeDeck() заполняет колоду всеми 52 картами.
    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    // Метод shuffle() перемешивает карты в колоде случайным образом.
    public void shuffle() {
        Collections.shuffle(deck);
    }

    // Метод dealCard() извлекает и возвращает верхнюю карту из колоды.
    public Card dealCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            return null; // Если колода пуста, возвращаем null.
        }
    }

    // Метод returnCardToDeck() возвращает карту в колоду.
    public void returnCardToDeck(Card card) {
        deck.add(card);
    }

    // Метод getDeckSize() возвращает текущее количество карт в колоде.
    public int getDeckSize() {
        return deck.size();
    }

    // Метод printDeck() выводит все карты в колоде на экран.
    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    // Этот метод представляет собой пример использования класса CardDeck.
    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeck();
        cardDeck.shuffle();

        System.out.println("Колода перед раздачей карт:");
        cardDeck.printDeck();

        Card dealtCard = cardDeck.dealCard();
        if (dealtCard != null) {
            System.out.println("Сданная карта: " + dealtCard);
        }

        System.out.println("Колода после сдачи карты:");
        cardDeck.printDeck();

        Card returnedCard = new Card(Rank.ACE, Suit.SPADES);
        cardDeck.returnCardToDeck(returnedCard);

        System.out.println("Колода после возврата карты:");
        cardDeck.printDeck();
    }
}

// Класс Card представляет собой карту с мастью (suit) и достоинством (rank).
class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

// Перечисление Rank представляет достоинства карт.
enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

// Перечисление Suit представляет масти карт.
enum Suit {
    SPADES, HEARTS, CLUBS, DIAMONDS
}

