package pieces;

import game.Colour;
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
     * @param colour the colour of the Queen.
     */
    public Queen(Position position, Colour colour) {
        super(position, colour);
    }

    /**
     * Returns the type of the Queen.
     * @return the type of the Queen.
     */
    public Type getType() {
        return type;
    }

    /**
     * Determines if the path to the given position is allowed for the Queen.
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public boolean isPathValid(Position newPosition) {
        // Moves forwards/backwards, left/right, or diagonal
        int changeInX = getPosition().getX() - newPosition.getX();
        int changeInY = getPosition().getY() - newPosition.getY();
        return changeInX == 0 || changeInY == 0 || changeInX == changeInY;
    }

    /**
     * Creates an array of positions that the Queen will cross as it moves.
     * This method is only called if isPathValid(end) = true.
     * We can treat this as the second step in determining if a move is allowed.
     * If the Queen must jump over another piece - that is, there is an existing
     * piece in its path - then the move is not valid.
     * @param end the Queen's final position.
     * @return an array of positions the Queen will cross.
     */
    public Position[] createPath(Position end) {
        // FIX THIS
        int changeInX = getPosition().getX() - end.getX();
        int changeInY = getPosition().getY() - end.getY();
        int numSquares = (int)getPosition().distance(end);
        Position[] path = new Position[numSquares];
        if (changeInX == 0) { // vertical move
            int dir = changeInY < 0 ? -1 : 1;
            for (int i = 0; i < numSquares; i++) {
                path[i] = new Position(getPosition().getX(),
                        getPosition().getY() + dir * (i + 1));
            }
        } else if (changeInY == 0) { // horizontal move
            int dir = changeInX < 0 ? -1 : 1;
            for (int i = 0; i < numSquares; i++) {
                path[i] = new Position(getPosition().getX() + dir * (i + 1),
                        getPosition().getY());
            }
        } else { // diagonal move
            // Copied from Bishop
            int newX = getPosition().getX();
            int newY = getPosition().getY();
            for (int i = 0; i < numSquares; i++) {
                int dirX = end.getX() - getPosition().getX() < 0 ? -1 : 1;
                int dirY = end.getY() - getPosition().getY() < 0 ? -1 : 1;
                newX += dirX;
                newY += dirY;
                path[i] = new Position(newX, newY);
            }
        }
        return path;
    }
}
