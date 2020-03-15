package pieces;

import game.Player;
import game.Position;

/**
 * Rook
 *
 * Rook moves directly fowards, backwards, or directly sideways for any number
 * of squares.
 */
public class Rook extends Piece {

    private Type type = Type.ROOK;
    private int moves = 0;

    /**
     * Constructs a Rook at the specified position for the specified player.
     * @param position position of the Rook.
     * @param player player the Rook belongs to.
     */
    public Rook(Position position, Player player) {
        super(position, player);
    }

    /**
     * Returns the type of the Rook.
     * @return the type of the Rook.
     */
    public Type getType() {
        return type;
    }

    /*
    Helper method to determine if the path to the given location will be valid.
     */
    private boolean isPathValid(Position newPosition) {
        int changeInX = getPosition().getX() - newPosition.getX();
        int changeInY = getPosition().getY() - newPosition.getY();
        return changeInX == 0 || changeInY == 0; // Moves up, down, or sideways.
    }

    /**
     * Moves the Rook to the given posiiton if the path to the position is a
     * valid path. The Rook can move directly forwards, backwards, or sideways
     * for any number of squares.
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
     * Returns the number of times Rook has moved.
     * @return the number of times Rook has moved.
     */
    public int getMoves() {
        return moves;
    }

}
