package pieces;

import game.Player;
import game.Position;

/**
 * Piece
 *
 * Abstract class that represents a chess piece.
 */
public abstract class Piece {
    private Position position; // the current position of the piece.
    private Player player; // the player to whom the piece belongs to.
    private boolean captured = false; // if the piece is captured
    private int moves = 0; // the number of moves the Piece has made.


    /**
     * Creates a game piece at the given position for the given player.
     * At construction, the pieces have not been captured.
     */
    public Piece(Position position, Player player) {
        this.position = position;
        this.player = player;
    }

    /**
     * Returns the position of the piece.
     * @return the position of the piece.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Changes the piece's position.
     * @param newPosition the piece's new position.
     */
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Returns if the piece has been captured.
     * @return true if the piece is captured, false otherwise.
     */
    public boolean isCaptured() {
        return captured;
    }

    /**
     * Captures the piece.
     */
    public void getCaptured() {
        captured = true;
    }

    /**
     * Returns the type of the piece.
     * @return the type of the piece.
     */
    public abstract Type getType();

    /**
     * Returns the number of moves the piece has made.
     * @return the number of moves the piece has made.
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Increases the number of moves the piece has made.
     */
    public void increaseMoves() {
        moves++;
    }

    /**
     * Determines if the path to the given position is allowed for the type of
     * the Piece.
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public abstract boolean isPathValid(Position newPosition);



//    public void capture() { };
    // could do capture(Piece piece) which calls a method move(Piece piece) so
    // there would be overloaded move methods. this covers pawn problem.
    // but player should probably call capture()
}
