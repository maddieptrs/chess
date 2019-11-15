package game;

import java.util.List;

/**
 * Board
 *
 * A class that represents the chess board.
 */
public class Board {

    private char[][] board;
    private int width;
    private int height;

    /**
     * Constructor that takes no arguments. This creates a traditional chess
     * board with a width of 8 and a height of 8. Upon
     * creation, the board will be empty.
     */
    Board() {
        this.width = 8;
        this.height = 8;
    }

    /**
     * Constructor that takes a height and width and creates a new chess board
     * with those dimensions. Upon creation, the board will be empty.
     */
    Board(int width, int height) {
        this.width = width;
        this.height = height;

        // "colour" the board??

    }

    /**
     * Finds the pieces on the board on the straight path between initialPos
     * and finalPos. Used to determine if there are any piece between two
     * positions.
     * @param initialPos
     * @param finalPos
     * @return
     */
//    public List<Character> getPath(Position initialPos, Position finalPos) {
//
//    }
}
