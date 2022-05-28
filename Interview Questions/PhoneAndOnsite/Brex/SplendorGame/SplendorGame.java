package SplendorGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yingli on 4/25/22.
 */
/*
*  SplendorGame

1: 手中gem可不可以afford一张卡
2: 卡‍‍‍‌‌‍‌‌‍‍‌‍‌‌‍‍‌‌的颜色可以抵消相同颜色的gem, 手中有n张卡, 可不可以afford 其他的卡
3: 如果multi threading怎么办 怎么lock

* */

 public class SplendorGame {

    public static void main(String[] arg) {


        Card blueCard = new Card(GemColor.BLUE);
        Card redCard = new Card(GemColor.RED);
        Card yellowCard = new Card(GemColor.YELLOW);
        Card greenCard = new Card(GemColor.GREEN);

        Player player1 = new Player();
        player1.ownGems.put(GemColor.BLUE, 2);
        player1.ownGems.put(GemColor.GREEN, 3);
        player1.ownGems.put(GemColor.RED, 1);

        yellowCard.cost.put(GemColor.RED, 1);
        yellowCard.cost.put(GemColor.GREEN, 2);

        greenCard.cost.put(GemColor.BLUE, 100);

        System.out.println(player1.affordable(yellowCard));
        System.out.println(player1.affordable(greenCard));

        // let player hold some blue cards, in order to able purchase green
        for (int i = 0; i < 101; i++) {
            player1.ownCards.add(blueCard);
        }
        System.out.println("Own 100 blue cards but dose not count: " + player1.affordable(greenCard));
        System.out.println("Own 100 blue cards : " + player1.affordableWithCard(greenCard));

        System.out.println("before purchase a yellow card, player has yellow card ? : "
                + player1.ownCards.contains(yellowCard));
        System.out.println("player has how many cards before puchase: " + player1.ownCards.size());
        try {
            player1.purchase(yellowCard);
            System.out.println("get 1 yellow card");
        } catch (Exception e) {
            System.out.println("CANNOT AFFORD");
        }

        System.out.println("after purchase a yellow card, player has yellow card ? : "
                + player1.ownCards.contains(yellowCard));
        System.out.println("player has how many cards after purchase: " + player1.ownCards.size());



    }

    static class Card {
        Map<GemColor, Integer> cost;
        GemColor cardColor;

        public Card(GemColor color) {
            this.cardColor = color;
            this.cost = new HashMap<GemColor, Integer>();
        }
        public GemColor getCardColor() {
            return cardColor;
        }
    }


    enum GemColor {
        RED,
        GREEN,
        WHILE,
        BLUE,
        YELLOW
    }

    static class Player {

        Map<GemColor, Integer> ownGems;

        List<Card> ownCards;
        //constructor
        public Player() {
            ownGems = new HashMap<GemColor, Integer>();
            ownCards = new ArrayList<Card>();
        }

        public boolean affordable(Card card) {

            //count by color for input card
            Map<GemColor, Integer> costByGemColor = card.cost;

            //count player own gem by color
            Map<GemColor, Integer> ownByGemColor = ownGems;


            //check if affordable
            for (Map.Entry<GemColor, Integer> entry : costByGemColor.entrySet()) {
                GemColor color = entry.getKey();
                int count = entry.getValue();
                if (!ownByGemColor.containsKey(color)) return false;
                if (ownByGemColor.get(color) < count) return false;
            }
            return true;
        }

        boolean purchase(Card card) throws Exception{
            if (!affordable(card)) {
                return false;
            }
            //count by color for input card
            Map<GemColor, Integer> costByColor = card.cost;

            //remove gems by color
            for (Map.Entry<GemColor, Integer> entry : costByColor.entrySet()) {
                GemColor color = entry.getKey();
                int count = entry.getValue();
                if (!ownGems.containsKey(color)) {
                    throw new Exception("cannot afford");
                }
                ownGems.put(color, ownGems.get(color) - count);
                if (ownGems.get(color) < 0) {
                    throw new Exception("cannot afford");
                }
            }
            ownCards.add(card);
            return true;
        }

        boolean affordableWithCard (Card card) {

            //count by color for input card
            Map<GemColor, Integer> costByGemColor = card.cost;

            //count player own gem by color
            Map<GemColor, Integer> ownByGemColor = ownGems;

            //add own card color into count
            for (Card ownCard : ownCards) {
                GemColor ownCardColor = ownCard.getCardColor();
                ownByGemColor.put(ownCardColor, ownByGemColor.getOrDefault(ownCardColor, 0) + 1);
            }

            //check if affordable
            for (Map.Entry<GemColor, Integer> entry : costByGemColor.entrySet()) {
                GemColor color = entry.getKey();
                int count = entry.getValue();
                if (!ownByGemColor.containsKey(color)) return false;
                if (ownByGemColor.get(color) < count) return false;
            }
            return true;

        }
    }
}
