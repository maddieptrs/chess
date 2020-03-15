package pieces;

import game.Player;
import game.Position;

/**
 * Queen
 *
 * Queen can move in a line in any direction for any number of squares.
 */
public class Queen extends Piece {

    private Type type = Type.QUEEN;

    /**
     * Constructs a Queen at the specified position for the specified player.
     * @param position the position of the Queen.
     * @param player the player the Queen belongs to.
     */
    public Queen(Position position, Player player) {
        super(position, player);
    }

    /**
     * Returns the type of the Queen.
     * @return the type of the Queen.
     */
    public Type getType() {
        return type;
    }

    /*
    Helper method to determine if the path to the given position will be valid.
     */
    private boolean isPathValid(Position newPosition) {
        int changeInX = getPosition().getX() - newPosition.getX();
        int changeInY = getPosition().getY() - newPosition.getY();
        return changeInX == 0 || changeInY == 0 || changeInX == changeInY;
        // Moves forwards/backwards, left/right, or diagonal
    }

    /**
     * Moves the Queen to the given position if the path to the position is a
     * valid path. The Queen can move in a line in any direction for any number
     * of squares.
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
