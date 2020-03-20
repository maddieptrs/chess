package pieces;

import game.Colour;
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
     * @param colour colour of the Knight.
     */
    public Knight(Position position, Colour colour) {
        super(position, colour);
    }

    /**
     * Returns the type of the Knight.
     * @return the type of the Knight.
     */
    public Type getType() {
        return type;
    }

    /**
     * Determines if the path to the given position is allowed for the Knight.
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public boolean isPathValid(Position newPosition) {
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
     * Creates an array of positions that the Knight will cross as it moves.
     * This method is only called if isPathValid(end) = true.
     * We can treat this as the second step in determining if a move is allowed.
     * The Knight is allowed to "jump" over other pieces because of its unique
     * movement.
     * @param end the Knight's final position.
     * @return an array of positions the Knight will cross.
     */
    public Position[] createPath(Position end) {
        // order of movement does not matter as it does not matter if the Knight
        // "jumps" over any pieces.
        Position[] path = new Position[3];
        int changeInX = getPosition().getX() - end.getX();
        int changeInY = getPosition().getY() - end.getY();
        if (Math.abs(changeInX) == 1) {
            int newX = getPosition().getX() + changeInX;
            path[0] = new Position(newX, getPosition().getY());
            path[1] = new Position(newX, getPosition().getY() + changeInY/2);
            path[2] = new Position(newX, getPosition().getY() + changeInY);
        } else {
            int newY = getPosition().getY() + changeInY;
            path[0] = new Position(getPosition().getX(), newY);
            path[1] = new Position(getPosition().getX() + changeInX/2, newY);
            path[2] = new Position(getPosition().getX() + changeInX, newY);
        }
        return path;
    }
}
