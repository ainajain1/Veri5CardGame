import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player {
    private List<Card> cards = new ArrayList<>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void printAllCards() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    /*public int getTotalPoints() {
        int totalPoints = 0;
        for (Card card : cards) {
            totalPoints += card.getValue();
        }
        return totalPoints;
    }*/

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public String getName() {
        return name;
    }

    public int getFirstCardValue() {
        if (cards.isEmpty()) return  0;
        return cards.get(0).getValue();
    }

    public int getFirstCardSuitValue() {
        if (cards.isEmpty()) return  -1;
        return cards.get(0).getSuit().ordinal();
    }

    public void reset() {
        cards.clear();
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getSortedCardList() {
        //we can keep the list sorted while adding the card
        Collections.sort(cards, new CardComparator());
        return cards;
    }
}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getValue() > card2.getValue()) {
            return 1;
        }
        if (card1.getValue() < card2.getValue()) {
            return -1;
        }
        return 0;
    }
}
