package pieces;

import game.Player;
import game.Position;

/**
 * Bishop
 *
 * Bishop moves diagonally for any number of squares.
 */
public class Bishop extends Piece {

    private Type type = Type.BISHOP; // Piece type.

    /**
     * Constructs a Bishop at the specified position for the specified player.
     * @param position position of the Bishop.
     * @param player player the Bishop belongs to.
     */
    Bishop(Position position, Player player) {
        super(position, player);
    }

    /**
     * Returns the type of the Bishop.
     * @return the type of the Bishop.
     */
    public Type getType() {
        return type;
    }

    /*
    Helper method to determine if the path to the given position will be valid.
     */
    private boolean isPathValid(Position newPosition) {
        return Math.abs(getPosition().getY() - newPosition.getY())
                == Math.abs(getPosition().getX() - newPosition.getX());
    }

    /**
     * Moves the Bishop to the given position if the path to the position is a
     * valid path. The Bishop can move diagonally for any number of squares.
     * Otherwise, prints "Move not allowed."
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
