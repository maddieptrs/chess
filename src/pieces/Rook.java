package pieces;

import game.Colour;
import game.Position;

/**
 * Rook
 *
 * Rook moves directly fowards, backwards, or directly sideways for any number
 * of squares.
 */
public class Rook extends Piece {

    private Type type = Type.ROOK;

    /**
     * Constructs a Rook at the specified position for the specified player.
     * @param position position of the Rook.
     * @param colour colour of the Rook.
     */
    public Rook(Position position, Colour colour) {
        super(position, colour);
    }

    /**
     * Returns the type of the Rook.
     * @return the type of the Rook.
     */
    public Type getType() {
        return type;
    }

    /**
     * Determines if the path to the given position is allowed for the Rook.
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public boolean isPathValid(Position newPosition) {
        int changeInX = getPosition().getX() - newPosition.getX();
        int changeInY = getPosition().getY() - newPosition.getY();
        return changeInX == 0 || changeInY == 0; // Moves up, down, or sideways.
    }

    /**
     * Creates an array of positions that the Rook will cross as it moves.
     * This method is only called if isPathValid(end) = true.
     * We can treat this as the second step in determining if a move is allowed.
     * If the Rook must jump over another piece - that is, there is an existing
     * piece in its path - then the move is not valid.
     * @param end the Rook's final position.
     * @return an array of positions the Rook will cross.
     */
    public Position[] createPath(Position end) {
        int changeInX = getPosition().getX() - end.getX();
        int changeInY = getPosition().getY() - end.getY();
        int numSquares = (int)getPosition().distance(end);
        Position[] path = new Position[numSquares];
        for (int i = 0; i < numSquares; i++) {
            if (changeInY == 0) { // horizontal movement
                int dir = changeInX < 0 ? -1 : 1;
                path[i] = new Position(getPosition().getX() + dir * (1 + i),
                        getPosition().getY());
            } else {
                int dir = changeInY < 0 ? -1 : 1;
                path[i] = new Position(getPosition().getX(),
                        getPosition().getY() + dir * (1 + i));
            }
        }
        return path;
    }
}
