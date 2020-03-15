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

    /**
     * Constructs a Pawn at the specified position for the specified player.
     *
     * @param position position of the Pawn.
     * @param player   player the Pawn belongs to.
     */
    public Pawn(Position position, Player player) {
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

    /**
     * Determines if the path to the given position is allowed for the type of
     * the Piece.
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public boolean isPathValid(Position newPosition) {
        int changeInX = Math.abs(getPosition().getX() - newPosition.getX());
        int changeInY = getPosition().getY() - newPosition.getY();
        if (this.getMoves() == 0) {
            return changeInX == 0 && changeInY <= 2;
            // Pawn can move two spots forward on first move.
        }
        // changeInY must be positive
        return changeInX == 1 && changeInY == 1;

        // capturing must be included in game class so we can access the
        // chess board.

        // move is made in PLayer.
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

}
