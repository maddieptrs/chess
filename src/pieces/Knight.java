package pieces;

import game.Player;
import game.Position;

/**
 * Knight
 *
 * A Knight can move in an L shape, moving one square in one direction and then
 * 2 spaces in a perpendicular direction. For example, one square up and two
 * squares left.
 */
public class Knight extends Piece {

    private Type type = Type.KNIGHT; // Piece type.

    /**
     * Constructs a Knight at the specified position for the specified player.
     * @param position position of the Knight.
     * @param player player the Knight belongs to.
     */
    Knight(Position position, Player player) {
        super(position, player);
    }

    /**
     * Returns the type of the Knight.
     * @return the type of the Knight.
     */
    public Type getType() {
        return type;
    }

    /*
    Helper method to determine if the path to the given position will be valid.
     */
    private boolean isPathValid(Position newPosition) {
        int changeInX = Math.abs(getPosition().getX() - newPosition.getX());
        int changeInY = Math.abs(getPosition().getY() - newPosition.getY());
        if (changeInX == 1) {
            return (changeInY == 2);
        } else if (changeInY == 1) {
            return (changeInX == 2);
        }
        return false;
    }

    /**
     * Moves the Knight to the given position if the path to the position is a
     * valid path. The Knight moves in an L shape.
     * Otheriwse, prints "Move not allowed."
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
