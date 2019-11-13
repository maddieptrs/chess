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
     * Returns if the piece has been captured.
     * @return true if the piece is captured, false otherwise.
     */
    public boolean isCaptured() {
        return captured;
    }

    /**
     * Returns the type of the piece.
     * @return the type of the piece.
     */
    public abstract Type getType();

    /**
     * Moves the piece to the given position if the move is allowed.
     * @param newPosition the new position.
     */
    public abstract void move(Position newPosition);

//    public void capture() { };
//    public void getCaptured() { };
}
