package pieces;

import game.Colour;
import game.Player;
import game.Position;

/**
 * Piece
 *
 * Abstract class that represents a chess piece.
 */
public abstract class Piece {
    private Position position; // the current position of the piece.
    private Colour colour; // the colour of the piece (Black/White).
    private boolean captured = false; // if the piece is captured.
    private int moves = 0; // the number of moves the Piece has made.


    /**
     * Creates a game piece at the given position for the given player.
     * At construction, the pieces have not been captured.
     */
    public Piece(Position position, Colour colour) {
        this.position = position;
        this.colour = colour;
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

    /**
     * Creates an array of positions that the Piece will cross as it moves.
     * This method is only called if isPathValid(end) = true.
     * We can treat this as the second step in determining if a move is allowed.
     * If the Piece must jump over another piece - that is, there is an existing
     * piece in its path - then the move is not valid.
     * @param end the Piece's final position.
     */
    public abstract Position[] createPath(Position end);

}
