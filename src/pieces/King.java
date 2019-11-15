package pieces;

import game.Player;
import game.Position;

/**
 * King
 *
 * King moves one square in any direction.
 */
public class King extends Piece {

    private Type type = Type.KING; // Piece type.
    private boolean checked = false; // Has King been checked.
    private int moves = 0; // Number of moves made with King.

    /**
     * Constructs a King at the specified position for the specified player.
     * @param position position of the King.
     * @param player player the King belongs to.
     */
    King(Position position, Player player) {
        super(position, player);
    }

    /**
     * Returns the type of the King.
     * @return the type of the King.
     */
    public Type getType() {
        return type;
    }

    /*
    Helper method to determine if the path to the given position will be valid.
     */
    private boolean isPathValid(Position newPosition) {
        return getPosition().distance(newPosition) == 1;
    }

    /**
     * Moves the King to the given position if the path to the position is a
     * valid path. The King can move diagonally in any direction by one square.
     * Otherwise, prints "Move not allowed."
     * @param newPosition the new position.
     * @require newPosition must be on the board.
     */
    public void move(Position newPosition) {
        if (isPathValid(newPosition)) {
            setPosition(newPosition);
            moves++;
        } else {
            System.out.println("Move not allowed.");
        }
    }

    /**
     * Returns the number of times the King has moved.
     * @return number of times the King has moved.
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Checks if the King is in check.
     * @return true if the King is in check, false otherwise.
     */
    public boolean isChecked() {
        return checked;
    }
}
