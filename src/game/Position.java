package game;

/**
 * Position
 *
 * Represents a position on the board.
 */
public class Position {

    private int x; // x position
    private int y; // y position

    /**
     * Constructor that takes an x and y coordinate and creates a Position for
     * those coordinates.
     * @param x x coordinate.
     * @param y y coordinate.
     */
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the x coordinate of the Position.
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Retrieves the y coordinate of the Position.
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Determines the Euclidean distance between the given position and the
     * position being operated on.
     * @param other the other position.
     * @return the distance between the two positions.
     */
    public double distance(Position other) {
        return Math.sqrt((x - other.getX())^2 + (y - other.getY())^2);
    }

//    public void add(Position other) { };
//    public void multiply(int scalar) { };

    /**
     * Determines if one position is equal to another.
     * Positions are equal if the x coordinates are equal and the y coordinates
     * are equal.
     * @param o the object to be checked against.
     * @return true if equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (!(o instanceof Position)) { // checks if o is a Position
            return false;
        }

        Position other = (Position) o;
        return (x == other.getX()) && (y == other.getY());
    }

    /**
     * Gets the hashcode of the Position.
     * If two positions are equal, they must have the same hashcode.
     * @return the hashcode of the position.
     */
    public int hashCode() {
        return 3*x + 7*y;
    }
}
