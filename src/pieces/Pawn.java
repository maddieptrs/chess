package pieces;

import game.Player;
import game.Position;

/**
 * Pawn
 *
 * Pawn moves diagonally foward by one square.
 */
public class Pawn extends Piece {

    private Type type = Type.PAWN; // Piece type.
    private int moves = 0; // Number of moves Pawn has made.

    /**
     * Constructs a Pawn at the specified position for the specified player.
     *
     * @param position position of the Pawn.
     * @param player   player the Pawn belongs to.
     */
    Pawn(Position position, Player player) {
        super(position, player);
    }

    /**
     * Returns the type of the Pawn.
     *
     * @return the type of the Pawn.
     */
    public Type getType() {
        return type;
    }

    /*
    Helper method to determine if the path to the given position will be valid.
     */
    private boolean isPathValid(Position newPosition) {
        int changeInX = Math.abs(getPosition().getX() - newPosition.getX());
        int changeInY = getPosition().getY() - newPosition.getY();
        if (moves == 0) {
            return changeInX == 0 && changeInY <= 2;
            // Pawn can move two spots forward on first move.
        }

        // changeInY must be positive
        return changeInX == 1 && changeInY == 1;

        // how to fix this for capturing???
        // have overloaded methods? e.g. isValidPath(Position position) and
        // isValidPath(Piece piece) so we'd have move(Position position) and
        // move(Piece piece)??
    }

    /**
     * Moves the Pawn to the given position if the path to the position is a
     * valid path. If it is the Pawn's first move, it can move two squares
     * forward. If the Pawn is capturing another piece, it may move one square
     * diagonally. Otherwise, the Pawn can move forwards by one square.
     * Otherwise, prints "Move not allowed."
     *
     * @param newPosition the new position.
     * @require newPosition must be on the board.
     */
    public void move(Position newPosition) {
        if (isPathValid(newPosition)) {
            setPosition(newPosition);
        } else {
            System.out.println("Move not allowed.");
        }
    }

    /**
     * Returns the number of times the Pawn has moved.
     * @return the number of times the Pawn has moved.
     */
    public int getMoves() {
        return moves;
    }
}
