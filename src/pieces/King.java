package pieces;

import game.Colour;
import game.Position;

/**
 * King
 *
 * King moves one square in any direction.
 */
public class King extends Piece {

    private Type type = Type.KING; // Piece type.
    private boolean checked = false; // Has King been checked.

    /**
     * Constructs a King at the specified position for the specified player.
     * @param position position of the King.
     * @param colour colour of the King.
     */
    public King(Position position, Colour colour) {
        super(position, colour);
    }

    /**
     * Returns the type of the King.
     * @return the type of the King.
     */
    public Type getType() {
        return type;
    }

    /**
     * Determines if the path to the given position is allowed for the King.
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public boolean isPathValid(Position newPosition) {
        return getPosition().distance(newPosition) == 1;
        // special case for castling dealt with in Player.
    }

    /**
     * Creates an array of positions that the King will cross as it moves.
     * This method is only called if isPathValid(end) = true.
     * We can treat this as the second step in determining if a move is allowed.
     * If the King must jump over another piece - that is, there is an existing
     * piece in its path - then the move is not valid.
     * @param end the King's final position.
     * @return an array of positions the Piece will cross.
     */
    public Position[] createPath(Position end) {
        return new Position[]{end};
    }

    /**
     * Creates an array of positions that the King will cross as it castles.
     * This is the exception to createPath. We assume that neither the Rook nor
     * the King will have moved (this will be dealt with in Player).
     * @param rook the rook to be castled with.
     * @return an array of positions the King will cross while castling.
     */
    public Position[] castlePath(Rook rook) {
        int rookX = rook.getPosition().getX();
        int kingX = getPosition().getX();
        boolean castleToLeft = (rookX < kingX);
        Position[] path = new Position[Math.abs(rookX - kingX)];
        for (int i = 0; i < Math.abs(rookX - kingX); i++) {
            if (castleToLeft) {
                path[i] = new Position(kingX - (i + 1), getPosition().getY());
            } else {
                path[i] = new Position(kingX + i + 1, getPosition().getY());
            }
        }
        return path;
    }

    /**
     * Checks if the King is in check.
     * @return true if the King is in check, false otherwise.
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Toggles the check variable.
     */
    public void toggleCheck() {
        checked = !checked;
    }
}
