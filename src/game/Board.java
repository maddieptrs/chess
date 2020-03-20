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

    private char[][] board;
    private int width = 8;
    private int height = 8;

    /**
     * Constructor that takes no arguments. This creates a traditional chess
     * board with a width of 8 and a height of 8. This is represented by a 2D
     * character array. Upon creation, the board will be empty.
     */
    Board() {
        board = new char[8][8];
        for (char[] row : board) {
            for (int i = 0; i < 8; i++) {
                row[i] = 'E';
            }
        }
    }

    /**
     * Returns the piece occupying the given square.
     * @param position the position of the given square.
     * @return the piece occupying the square, or null if it is an empty square.
     */
    public char getEntry(Position position) {
        return board[position.getY()][position.getX()];
    }

    /**
     * Sets an entry of the board to a different piece (for example, from
     * Knight to King, or from an empty space to Queen).
     * @param position the position on the board to be set.
     * @param key the character representing the piece the entry must now
     *            contain.
     */
    public void setEntry(Position position, char key) {
        this.board[position.getY()][position.getX()] = key;
    }
}
