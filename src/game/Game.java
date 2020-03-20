package game;

import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    /*
    in here we want to create board, populate it with pieces for each player,
    assign a colour to each player, let each player take a turn and move a
    piece - that is, call the move function which will check if the piece
    being moved is the right colour, then check if it can be moved (call piece's
    move function), also if the
    player takes any pieces.
     */

    public Game(String whiteName, String blackName) {
        board = new Board();

        whitePlayer = new Player(whiteName, Colour.WHITE, board);
        blackPlayer = new Player(blackName, Colour.BLACK, board);
    }

    /**
     * Populates the board with white and black pieces. The white pieces are
     * positioned at the lower end of the board (beginning with y position = 0)
     * and the black pieces are position at the higher end of the board
     * (beginning with y posiiton = 8).
     * @param board the board to be populated.
     */
    public void populateBoard(Board board) {

    }

    /*
    Helper method to move the piece ...
     */
    private void makeMove(Player player, Piece piece, Position position) {
        /*
        gives which player is moving, piece to move, position to move to.
        if there are no obstructions in the piece's path, call player.move(),
        if there is an opposite colour piece at the given position capture it,
        add the score to the player.
         */
    }
}
