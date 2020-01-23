package edu.cnm.deepdive.model;

import java.util.Arrays;
import java.util.Random;

public class Deck {

  private Card[]card;

  public Deck(Random rng) {
    card = new Card[Suit.values().length * Rank.values().length];
    int position = 0;
    for(Suit s : Suit.values()){
      for(Rank r : Rank.values()){
        card[position++] = new Card(s, r);

      }
    }
   for (int i = card.length -1; i > 0; i--) {
     int j = rng.nextInt(i + 1);
     Card temp =card[i];
     card[i]= card[j];
     card[j] = temp;
   }
  }

  @Override
  public String toString() {
    return Arrays.toString(card);
  }

  public static void main(String[] args) {
    Deck deck = new Deck(new Random());
    System.out.println(deck);
  }
}
