package game;

/**
 * Player
 *
 * A player in the chess game.
 */
public class Player {

    private String name; // name of the player
    private Colour colour; // colour of the player's pieces
    private boolean yourTurn = false; // if it is the player's turn

    /**
     * Creates a named player that uses either the white or black pieces.
     * If the player's colour is white, then it is their turn initially.
     */
    Player(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
        if (this.colour == Colour.WHITE) {
            yourTurn = true;
        }
    }

    /**
     * Changes the player's turn. If it was their turn, it now is not, and vice
     * versa.
     */
    public void changeTurn() {
        yourTurn = !yourTurn;
    }

    /**
     * Returns if it is this player's turn.
     * @return true if it is the player's turn, false otherwise.
     */
    public boolean getTurn() {
        return yourTurn;
    }

//    public void checkmate() { };
}
