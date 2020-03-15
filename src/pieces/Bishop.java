package pieces;

import game.Colour;
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
     * @param colour colour of the Bishop.
     */
    public Bishop(Position position, Colour colour) {
        super(position, colour);
    }

    /**
     * Returns the type of the Bishop.
     * @return the type of the Bishop.
     */
    public Type getType() {
        return type;
    }

    /**
     * Determines if the path to the given position is allowed for the Bishop
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public boolean isPathValid(Position newPosition) {
        // Moves diagonally
        return Math.abs(getPosition().getY() - newPosition.getY())
                == Math.abs(getPosition().getX() - newPosition.getX());
    }

    /**
     * Creates an array of positions that the Bishop will cross as it moves.
     * This method is only called if isPathValid(end) = true.
     * We can treat this as the second step in determining if a move is allowed.
     * If the Bishop must jump over another piece - that is, there is an existing
     * piece in its path - then the move is not valid.
     * @param end the Bishop's final position.
     * @require numSquares > 0.
     */
    public Position[] createPath(Position end) {
        int numSquares = Math.abs(end.getX() - getPosition().getX());
        Position[] path = new Position[numSquares];
        int newX = getPosition().getX();
        int newY = getPosition().getY();
        for (int i = 0; i < numSquares; i++) {
            if (end.getX() - getPosition().getX() < 0) {
                newX -= 1;
            } else {
                newX += 1;
            }
            if (end.getY() - getPosition().getY() < 0) {
                newY -= 1;
            } else {
                newY += 1;
            }
            path[i] = new Position(newX, newY);
        }
        return path;
    }
}
