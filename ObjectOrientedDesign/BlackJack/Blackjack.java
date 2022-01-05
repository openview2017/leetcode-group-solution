import java.lang.Integer;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

//enum and constant class
public class Person {
    private String name;
    private String Address;
    private String email;
    private String phone;
}
public enum Suit{
    HEART, SPADE, CLUB, DIAMON
}
public enum AccountStatus {
    ACTIVE, CLOSED, BALCKLISTED
}


public abstract class BasePlayer {
    private String userId;
    private String passWord;
    private String displayName;
    private Person person;
    private AccountStatus status;
    protected List<Hand> hands;

    public List<Hand> getHands() {
        return hands;
    }
    public void addHand(Hand hand) {
        hands.add(hand);
    }
    public void removeHand(Hand hand) {
        hands.remove(hand);
    }

    public boolean resetPassWord();

}

public class Player extends BasePlayer {
    private int bet;
    private int totalCash;

    public Player(Hand hand) {
        this.hands = new ArrayList<Hand>();
        this.hands.add(hand);
    }
}

public class Dealer extends BasePlayer {
    private Hand hand;
}

public class Hand {

    private List<BlackjackCard> cards;

    private List<Integer> getScores() {
        List<Integer> scores = new ArrayList<Integer>();
        boolean hasAce = false;
        int score = 0;
        for (BlackjackCard card : cards) {
            int point = card.getGameValue();
            if (point == 1) hasAce = true;
            score += point;
        }
        scores.add(score);
        //Ace could be count as 11
        if (hasAce) scores.add(score + 10);

        return scores;
    }
    //initial with two cards
    public Hand(BlackjackCard c1, BlackjackCard c2) {
        this.cards = new ArrayList<BlackjackCard>();
        cards.add(c1);
        cards.add(c2);
    }
    protected void addCard(Card card) {
        cards.add(card);
    }

    public int resolveScore() {
        List<Integer> scores = getScores();
        int bestScore = 0;
        for (int score : scores) {
            if (score <= 21 && score > bestScore) {
                bestScore = score
            }
        }
        return bestScore;
    }
}

public class Card {
    private Suit suit;
    private int faceValue;

    public Suit getSuit();
    public int getFaceValue();

    public Card(Suit suit, int faceValue) {
        this.faceValue = faceValue;
        this.suit = suit;
    }
}

//for backjack game, we have different definition on value when card value is over 10
//so extend super class keep property and constructor, update value once over 10
public class BlackjackCard extends Card {
    private int gameValue;

    public int getGameValue();

    public BlackjackCard(Suit suit, int faceValue) {
        super(suit, faceValue);
        this.gameValue = faceValue;
        if (this.gameValue > 10) {
            this.gameValue = 10;
        }
    }
}

//Initial a deck
public class Deck {
    private Date creationDate;
    private List<BlackjackCard> cards;
    public Deck() {
        this.creationDate = new Date();
        this.cards = new ArrayList<BlackjackCard>();
        for (int val = 1; val <= 13; val++) {
            for (Suit suit : Suit.values()) {
                this.cards.add(new BlackjackCard(suit, val));
            }
        }
    }
    public List<BlackjackCard> getCards() {
        return cards;
    }

}

public class Shoe {
    private int numberOfDecks;
    private List<BlackjackCard> cards;

    private void createShoe() {
        this.cards = new ArrayList<BlackjackCard>();
        for (int i = 0; i < numberOfDecks; i++) {
            cards.add(new Deck().getCards());
        }
    }

    //shoe contain multiple deacks of card
    public Shoe(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        createShoe();
        shuffle();
    }
    public void shuffle() {
        int num = cards.size();
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            int index = rand.nextInt(num - i - 1);
            swap(i, index);
        }
    }
    public void swap(int i, int j) {
        BlackjackCard temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
        return;
    }
    public void dealCard() {
        if (cards.size() == 0) {
            createShoe();
        }
        return cards.remove(0);
    }
}

//encpsulate a blackjack game
public class Game {
    private Player player;
    private Dealer dealer;
    private Shoe shoe;

    private void playAction(String action, Hand hand) {
        switch (action) {
            case "hit" : hit(hand); break;
            case "split": split(hand); break;
            case "stand pat": break;
            case "stand": stand; break;
            default: print("Wrong input");
        }
    }

    private void hit(Hand hand) {
        hand.addCard(shoe.shuffle());
    }

    private void stand() {
        int dealerScore = dealer.getTotalScore();
        int playerScore = player.getTotalScore();
        List<Hands> hands = player.getHands();
        for (Hand hand : hands) {
            int bestScore = hand.resolveScore();
            if (bestScore == 21) {
                //blackjack pay 3:2
            } else if (playerScore > dealerScore) {
                //pay 1:1 to player
            } else if (playerScore < dealerScore) {
                //collect bet from player
            } else {
                //tie , return bet
            }
        }

    }
}