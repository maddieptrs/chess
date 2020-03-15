package game;

import pieces.Piece;
import pieces.Type;

import java.util.List;

/**
 * Board
 *
 * A class that represents the chess board. Each part of the board is filled by
 * Pieces or empty squares.
 */
public class Board {

    private Piece[][] board;
    private int width = 8;
    private int height = 8;

    /**
     * Constructor that takes no arguments. This creates a traditional chess
     * board with a width of 8 and a height of 8. Upon creation, the board will
     * be empty.
     */
    Board() {
        board = new Piece[8][8];
    }

    /**
     * Returns the piece occupying the given square.
     * @param position the position of the given square.
     * @return the piece occupying the square, or null if it is an empty square.
     */
    public Piece getEntry(Position position) {
        return board[position.getY()][position.getX()];
    }

    /**
     * Sets an entry of the board to a different piece (for example, from
     * Knight to King, or from an empty space to Queen).
     * @param position the position on the board to be set.
     * @param piece the piece the entry must now contain.
     */
    public void setEntry(Position position, Piece piece) {
        this.board[position.getY()][position.getX()] = piece;
    }
}
