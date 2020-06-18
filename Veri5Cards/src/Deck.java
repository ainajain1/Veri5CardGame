import java.util.*;

public class Deck {

	private List<Card> givenCardList = new ArrayList<>();
	private List<Card> currentCardList = new ArrayList<>();

	Deck() {
		initializeDeck();
	}

	private void initializeDeck() {
		for (Suit suit : Suit.values()) {
			for (int cardNo = 0; cardNo < Utility.NUMBER_OF_CARDS_PER_SUIT; cardNo++) {
				currentCardList.add(new Card(suit, cardNo));
			}
		}
	}

	public void shuffle() throws GameException {
		if (currentCardList.size() <= 1) {
			throw new GameException("No cards to shuffle.");
		}
		Collections.shuffle(currentCardList);
	}

	public boolean isEmpty() {
		return currentCardList.size() == 0;
	}

	public Card getOneCardFromDeck() {
		Card card = currentCardList.get(0);
		currentCardList.remove(0);
		givenCardList.add(card);
		return card;
	}

	public List<Card> getMultipleCardFromDeck(int noOfCards) {
		List<Card> result = new ArrayList<>();
		for (int index = 0; index < noOfCards; index++) {
			result.add(getOneCardFromDeck());
		}
		return result;
	}

	public void returnOneCardToDeck(int position, Card card) {
		if (currentCardList.contains(card)) {
			System.out.println("Card is already in deck");
			return;
		}
		givenCardList.add(position, card);
		currentCardList.remove(card);
	}

	public void returnMultipleCard(List<Map<Object, Object>> cards) {
		for (Map<Object, Object> cardInput : cards) {
			int position = (int) cardInput.get("position");
			Card card = (Card) cardInput.get("card");
			returnOneCardToDeck(position, card);
		}
	}

	public void printAllPresentCardsInDeck() throws GameException {
		if (currentCardList.isEmpty())
			throw new GameException("No cards to shuffle.");

		for (Card card : currentCardList) {
			System.out.println(card.toString());
		}
	}

	public void reset() {
		currentCardList.clear();
		givenCardList.clear();
		initializeDeck();
	}

	public List<Card> getCurrentCardList() {
		return currentCardList;
	}

	public List<Card> getGivenCardList() {
		return givenCardList;
	}
}
