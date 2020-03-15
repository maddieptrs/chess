package game;

import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;

import java.util.ArrayList;
import java.util.List;

/**
 * Player
 *
 * A player in the chess game.
 */
public class Player {

    private String name; // name of the player
    private Colour colour; // colour of the player's pieces
    private boolean yourTurn = false; // if it is the player's turn
    private int score = 0; // the player's score
    private List<Piece> pieces;

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
     * Returns a list of pieces belonging to the player.
     * @return a list of pieces belonging to the player.
     */
    public List<Piece> getList() {
        return pieces;
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
     * Returns the player's score.
     * @return the player's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Increases the player's score by the given amount.
     * @param increment how much to increase the score by.
     */
    public void increaseScore(int increment) {
        score += increment;
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
     * I DON'T THINK THIS IS QUITE CORRECT!!!
     * @param rook the rook to be castled with.
     *
     *             has been copied from King
     */
    public void castle(Rook rook) {
//        if (moves == 0 && rook.getMoves() == 0) {
//
//        } do this in king??!
    }

    /**
     * Player selects a piece to move and a place to move it to. This method
     * call the isPathValid method from Piece and if it is, will move the Piece
     * to the new position and increase the Piece's moves count.
     * Assumes that there is no other pieces on the board. This is dealt with
     * in Game.
     * @param piece the piece to be moved.
     * @param position the position the piece is to be moved to.
     */
    public void move(Piece piece, Position position) {
        if (piece.isPathValid(position)) {
            piece.setPosition(position);
            piece.increaseMoves();
        } else {
            System.out.print("Move not allowed.");
        }
    } //  do this in game??

//    public void checkmate() { };

    // public void capture() { };
}
