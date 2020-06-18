import java.util.Scanner;

public class Play {

	public static Game game = new Game();

	public static void main(String[] args) {
		Action.printAll();
		start();
	}

	public static void start() {
		try {
			while (true) {
				play();
			}
		} catch (GameException gameException) {
			System.out.println(gameException.getMessage());
			start();
		}
	}

	public static void play() throws GameException {
		Scanner sc = new Scanner(System.in);

		switch (Action.getAction(sc.nextInt())) {

		case ADD_PLAYER:
			System.out.println("Player: '" + game.addPlayer() + "' added.");
			break;

		case REMOVE_PLAYER:
			System.out.print("Please enter the player number:");
			int playerNumber = sc.nextInt();
			game.removePlayer(playerNumber);
			System.out.println("Player removed.");
			break;

		case SHUFFLE:
			game.shuffleDeck();
			break;

		case PRINT_ALL_CARDS_IN_DECK:
			game.printAllCardsInDeck();
			break;

		case START_GAME:
			game.start();
			break;

		/*
		 * case GET_MULTIPLE_CARD_FROM_DECK: int noOfCards = sc.nextInt();
		 * game.getMultipleCardFromDeck(noOfCards); break;
		 */

		case PRINT_ALL_CARDS_OF_PLAYER:
			game.printCardsofPlayers();
			break;

		case WINNER:
			System.out.println("'" + game.winner() + "'");
			break;

		case FINISH:
			game.finish();
			break;

		case EXIT:
			sc.close();
			System.exit(1);
			break;
			
		}
	}

}
