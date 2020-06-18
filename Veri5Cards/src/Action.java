public enum Action {

    ADD_PLAYER(1),
    REMOVE_PLAYER(2),
    SHUFFLE(3),
    PRINT_ALL_CARDS_IN_DECK(4),
    START_GAME(5),
    PRINT_ALL_CARDS_OF_PLAYER(6),
//    GET_MULTIPLE_CARD_FROM_DECK(10),
    WINNER(7),
    FINISH(8),
    EXIT(9);

    int actionNumber;
    Action(int actionNumber) {
        this.actionNumber = actionNumber;
    }


    public static Action getAction(int i) {
        for (Action action : Action.values()) {
            if (action.actionNumber == i) return action;
        }
        return EXIT;
    }

	public static void printAll() {
        for (Action action : Action.values()) {
            System.out.println(action.name() + " " + action.actionNumber);
        }
    }
}
