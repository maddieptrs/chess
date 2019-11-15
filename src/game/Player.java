package game;

import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;

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

    /**
     * Promotes one of the player's pawns to another piece.
     * @param pawn the pawn to be promoted.
     * @param piece the piece to be promoted to.
     * @require piece must be a subclass of Piece && !(piece instanceOf Pawn)
     *          && !(piece instanceOf King)
     */
    public <T extends Piece> void promotePawn(Pawn pawn, T piece) {
        // do i need to use generics?
        // how can i instantiate a new piece without knowing its type?
    }

    /**
     * Allows the player to castle. That is, if the King and the given Rook have
     * not yet moved in the game, and the King is not in check, and there are
     * no pieces between the King and Rook, then the King and Rook can swap
     * places.
     * @param rook the rook to be castled with.
     */
//    public void castle(Rook rook) {
//        if (moves == 0 && rook.getMoves() == 0) {
//
//        }
//    }

//    public void checkmate() { };

    // public void capture() { };
}
