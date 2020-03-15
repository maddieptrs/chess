package pieces;

import game.Colour;
import game.Player;
import game.Position;

/**
 * Pawn
 *
 * Pawn moves diagonally foward by one square.
 */
public class Pawn extends Piece {

    private Type type = Type.PAWN; // Piece type.
    private String id; // identifies this Pawn.

    /**
     * Constructs a Pawn at the specified position for the specified player.
     *
     * @param position position of the Pawn.
     * @param colour   colour of the Pawn.
     */
    public Pawn(Position position, Colour colour, String id) {
        super(position, colour);
        this.id = id;
    }

    /**
     * Returns the type of the Pawn.
     *
     * @return the type of the Pawn.
     */
    public Type getType() {
        return type;
    }

    /**
     * Determines if the path to the given position is allowed for the type of
     * the Piece.
     * @param newPosition the new position.
     * @return true if the path is valid, false otherwise.
     */
    public boolean isPathValid(Position newPosition) {
        int changeInX = Math.abs(getPosition().getX() - newPosition.getX());
        int changeInY = getPosition().getY() - newPosition.getY();
        if (this.getMoves() == 0) {
            // Pawn can move two spots forward on first move.
            return changeInX == 0 && changeInY <= 2;
        }
        // Pawn can only move forwards.
        return changeInX == 1 && changeInY == 1;

        // capturing must be included in game class so we can access the
        // chess board.

        // move is made in game.
    }

    /**
     * Creates an array of positions that the Pawn will cross as it moves.
     * This method is only called if isPathValid(end) = true.
     * We can treat this as the second step in determining if a move is allowed.
     * If the Pawn must jump over another piece - that is, there is an existing
     * piece in its path - then the move is not valid.
     * @param end the Pawn's final position.
     * @require Pawn is moving forward.
     */
    public Position[] createPath(Position end) {
        Position[] path = new Position[1];
        if (end.getX() - getPosition().getX() == 0) { // moves forward by 2 squares
            path = new Position[2];
            path[0] = new Position(getPosition().getX(),
                    getPosition().getY() + 1);
            path[1] = end;
            return path;
        }
        path[0] = end; // moves one square diagonally
        return path;
    }

}
