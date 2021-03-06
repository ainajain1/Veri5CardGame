import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Game {
	private List<Player> players = new ArrayList<>();
	private Deck deck = new Deck();

	public String addPlayer() {
		String playerName = Utility.getPlayerNameFromNumber(players.size() + 1);
		players.add(new Player(playerName));
		return playerName;
	}

	public void removePlayer(int number) throws GameException {
		if (players.isEmpty())
			throw new GameException("No player left in game.");
		Optional<Player> optionalPlayer = players.stream()
				.filter(map -> map.getName().equals(Utility.getPlayerNameFromNumber(number))).findAny();
		if (optionalPlayer.isPresent()) {
			Player player = optionalPlayer.get();
			players.remove(player);
			return;
		} else {
			throw new GameException("Player doesn't exist in game.");
		}
	}

	public void shuffleDeck() throws GameException {
		deck.shuffle();
	}

	public void printAllCardsInDeck() throws GameException {
		deck.printAllPresentCardsInDeck();
	}

	public Card getOneCardFromDeck() {
		return deck.getOneCardFromDeck();
	}

	public void getMultipleCardFromDeck(int noOfCards) throws GameException {
		if (players.size() == 0)
			throw new GameException("Player should be more than one.");
		
		for (Player player : players) {
			for (Card card : deck.getMultipleCardFromDeck(noOfCards))
				player.addCard(card);
		}
	}

	public String winner() throws GameException {
		if (players.size() < 2 || deck.getGivenCardList().size() < 2)
			throw new GameException("Game was never started.");
		Collections.sort(players, new PlayerComparator());
		return players.get(0).getName();
	}

	public void start() throws GameException {
		if (players.size() < 2)
			throw new GameException("Player should be more than one.");
		if (players.size() > deck.getCurrentCardList().size())
			throw new GameException("Not enough cards left in deck.");
		for (Player player : players) {
			player.addCard(getOneCardFromDeck());
		}
	}

	public void printCardsofPlayers() throws GameException {
		if (players.size() == 0)
			throw new GameException("Player should be more than one.");
		for (Player player : players) {
			System.out.println(player.getName() + ": ");
			player.printAllCards();
			System.out.println();
		}
	}

	public void finish() {
		for (Player player : players) {
			player.reset();
		}
		deck.reset();
	}
}
