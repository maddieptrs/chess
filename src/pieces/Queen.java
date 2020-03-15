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
     */
    public Position[] createPath(Position end) {
        int changeInX = getPosition().getX() - end.getX();
        int changeInY = getPosition().getY() - end.getY();
        Position[] path = null;
        if (changeInX == 0) { // vertical move
            path = new Position[Math.abs(changeInY)];
            int direction = 1;
            if (changeInY < 0) {
                direction = -1;
            }
            for (int i = 0; i < Math.abs(changeInY); i++) {
                path[i] = new Position(getPosition().getX(),
                        getPosition().getY() + direction * (i + 1));
            }
        } else if (changeInY == 0) { // horizontal move
            path = new Position[Math.abs(changeInX)];
            int direction = 1;
            if (changeInX < 0) {
                direction = -1;
            }
            for (int i = 0; i < Math.abs(changeInX); i++) {
                path[i] = new Position(getPosition().getX() +
                        direction * (i + 1), getPosition().getY());
            }
        } else { // diagonal move
            // copy bishop?? Make private helper method??
        }
        return path;
    }
}
