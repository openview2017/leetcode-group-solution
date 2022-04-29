import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yingli on 4/25/22.
 */
/*
*  Splendor

1: 手中gem可不可以afford一张卡
2: 卡‍‍‍‌‌‍‌‌‍‍‌‍‌‌‍‍‌‌的颜色可以抵消相同颜色的gem, 手中有n张卡, 可不可以afford 其他的卡
3: 如果multi threading怎么办 怎么lock

* */

 public class Splendor {

    class Card {

        Map<GemColor, Integer> cost = new HashMap<GemColor, Integer>();
        GemColor cardColor;

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

    class Player {

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
