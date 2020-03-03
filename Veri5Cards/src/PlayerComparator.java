import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        int player1Score = player1.getFirstCardValue();
        int player2Score = player2.getFirstCardValue();

        if (player1Score > player2Score) {
            return 1;
        }
        if (player1Score < player2Score) {
            return -1;
        }

        return compareSuitWise(player1, player2);
    }

    public int compareSuitWise(Player player1, Player player2) {
        int player1SuitScore = player1.getFirstCardSuitValue();
        int player2SuitScore = player2.getFirstCardSuitValue();

        if (player1SuitScore > player2SuitScore) {
            return 1;
        }
        if (player1SuitScore < player2SuitScore) {
            return -1;
        }

        return 0;
    }

    // winning rule for multiple cards
    // Getting maximux card of each player
    // if both are same then comparing on the basis of given suit priority
    public int compareMultipleCards(Player player1, Player player2, int index) {
        Card card1WithMaxValue = player1.getSortedCardList().get(index);
        Card card2WithMaxValue = player2.getSortedCardList().get(index);
        if (card1WithMaxValue.getValue() > card2WithMaxValue.getValue()) {
            return 1;
        }
        if (card1WithMaxValue.getValue() < card2WithMaxValue.getValue()) {
            return -1;
        }
        if (card1WithMaxValue.getSuit().ordinal() > card2WithMaxValue.getSuit().ordinal()) {
            return 1;
        }
        return -1;
    }
}
