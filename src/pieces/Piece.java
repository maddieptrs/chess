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
    private String identifier; // a String used to identify the Piece instance.

    /**
     * Creates a game piece at the given position for the given player.
     * At construction, the pieces have not been captured.
     */
    Piece(Position position, Player player) {
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
     * Moves the piece to the given position if the path to the position is a
     * valid path.
     * Otherwise, prints "Move not allowed."
     * @param newPosition the new position.
     * @require newPosition must be on the board.
     */
    public abstract void move(Position newPosition);



//    public void capture() { };
    // could do capture(Piece piece) which calls a method move(Piece piece) so
    // there would be overloaded move methods. this covers pawn problem.
    // but player should probably call capture()
}
