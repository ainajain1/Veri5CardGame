import java.util.Scanner;

public class Play {

    public static Game game = new Game();

    public static void main(String[] args) {
        Action.printAll();
        start();
    }

    public static void start() {
        try {
            while(true) {
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
                game.addPlayer();
                break;

            case REMOVE_PLAYER:
                System.out.print("Please enter the player number:");
                int playerNumber = sc.nextInt();
                game.removePlayer(playerNumber);
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

            case PRINT_ALL_CARDS_OF_PLAYER:
                game.printCardsofPlayers();
                break;

            case WINNER:
                game.winner();
                break;

            case FINISH:
                game.finish();
                break;

            case EXIT:
                System.exit(1);
                break;
        }
    }

}
