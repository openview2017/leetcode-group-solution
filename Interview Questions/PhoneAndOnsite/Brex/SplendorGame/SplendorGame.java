package SplendorGame;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


// Main class should be named 'Solution'
/*
class Card
   color
   cost
class Player
   list of cards
   ---
   can_purchase
class Gem
   Color
*/

enum Color {
    BLUE,
    WHITE,
    GREEN,
    RED,
    YELLOW
}

class Solution {
    public static void main(String[] args) {
        Card card1 = new Card(Color.BLUE);
        Map<Color, Integer> cardCost = new HashMap<>();
        cardCost.put(Color.GREEN, 1);
        cardCost.put(Color.RED, 2);
        cardCost.put(Color.YELLOW, 1);
        card1.cost = cardCost;


        Card card2 = new Card(Color.GREEN);
        Card card3 = new Card(Color.RED);
        Card card4 = new Card(Color.YELLOW);
        Card card5 = new Card(Color.YELLOW);
        Card card6 = new Card(Color.YELLOW);



        List<Card> cardList = new ArrayList<>();
        cardList.add(card2);
        cardList.add(card3);
        cardList.add(card4);

        Map<Color, Integer> gems = new HashMap<>();
        gems.put(Color.GREEN, 1);
        gems.put(Color.RED, 2);
        gems.put(Color.YELLOW, 3); //check before and after purchase

        Player player = new Player();
        player.ownCard = cardList;
        player.ownGem = gems;

        System.out.println(player.can_purchase(card1));

        cardList.add(card5);
        cardList.add(card6);

        System.out.println(player.can_purchase(card1));


        System.out.println(player.ownCard.size() + " should be 5");
        System.out.println(player.ownGem.get(Color.YELLOW) + " equals to 3");

        System.out.println(player.purchase(card1));
        System.out.println(player.ownCard.size() + " should be 6");
        System.out.println(player.ownGem.get(Color.YELLOW) + " equals to 3");

    }

    static class Card {
        Color cardColor;
        Map<Color, Integer> cost;

        Color getColor() {
            return cardColor;
        }
        Map<Color, Integer> getCost() {
            return cost;
        }
        public Card(Color color) {
            this.cardColor = color;
            cost = new HashMap<>();
        }
    }

    static class Player {
        List<Card> ownCard;
        Map<Color, Integer> ownGem;

        public Player() {
            ownCard = new ArrayList<>();
            ownGem = new HashMap<>();
        }

        public boolean can_purchase(Card card) {
            Map<Color, Integer> cardCost = card.getCost();

            Map<Color, Integer> ownCardByColor = new HashMap<>();
            for (Card each : ownCard) {
                if (!ownCardByColor.containsKey(each.cardColor)) {
                    ownCardByColor.put(each.cardColor, 0);
                }
                ownCardByColor.put(each.cardColor, ownCardByColor.get(each.cardColor) + 1);
            }

            for (Map.Entry<Color, Integer> entry : cardCost.entrySet()) {
                Color color = entry.getKey();
                int count = entry.getValue();
                //check players own cards
                if (!ownGem.containsKey(color) && !ownCardByColor.containsKey(color)) return false;
                if (ownGem.get(color) + ownCardByColor.get(color)< count) return false;
            }
            return true;
        }

        public boolean purchase(Card card) {
            if (!can_purchase(card)) {
                return false;
            }
            Map<Color, Integer> ownCardByColor = new HashMap<>();
            for (Card each : ownCard) {
                if (!ownCardByColor.containsKey(each.cardColor)) {
                    ownCardByColor.put(each.cardColor, 0);
                }
                ownCardByColor.put(each.cardColor, ownCardByColor.get(each.cardColor) + 1);
            }
            Map<Color, Integer> cardCost = card.getCost();
            for (Map.Entry<Color, Integer> entry : cardCost.entrySet()) {
                Color color = entry.getKey();
                int count = entry.getValue() - ownCardByColor.getOrDefault(color, 0);
                if (count <= 0) continue;
                if (!ownGem.containsKey(color)) return false;
                ownGem.put(color, ownGem.get(color) - count);
                if (ownGem.get(color) < 0) return false;
            }
            ownCard.add(card);
            return true;
        }
    }


}

// Part 1. We want to write a function can_purchase() such that, given a particular card and collection of gems for a player,
// we return true if the player can afford the card, and false if they cannot.

// Part 2. We want to write a function purchase() such that, given a particular card and collection of gems for a player,
// we add the card to the player's hand and subtract the cost from the player's gems, if they are able to afford the card. The function should return true if the player can afford the card, and false if they cannot.

// Part 3. We want to introduce a new concept: for each card in a player's hand of a given color,
// we want to reduce the cost of any new purchase by 1 gem for that held card's color. For example,
// if the player holds 2 (G)reen cards and 1 (R)ed, and we are considering a card that lists its cost as 4 (G)reen, 2 (R)ed, and 1 (B)lue,
// then the player should be able to purchase it for 2 G, 1 R, and 1 B.
