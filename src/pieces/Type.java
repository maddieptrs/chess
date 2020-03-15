package pieces;

/**
 * Type
 *
 * This enum defines the type of different pieces. Each piece Type has a key
 * that is used to identify it. Each piece also has a value that can be used
 * to estimate the advantage or disadvantage of a player. The king, however,
 * cannot be captured so it does not have a positive value.
 */
public enum Type {
    PAWN('p', 1),
    KNIGHT('n', 3),
    BISHOP('B', 3),
    ROOK('r', 5),
    KING('K'),
    QUEEN('Q', 9);

    private char key; // key associated with the piece type.
    private int value; // value associated with the piece type.

    /**
     * Constructor that takes a key and sets the value to 0.
     * @param key a character that references a specific type.
     */
    Type(char key) {
        this.key = key;
        value = 0;
    }

    /**
     * Constructor that takes a key and sets the value to the given value.
     * @param key a character that references a specific type.
     * @param value an int that represents the value of the type.
     */
    Type(char key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Retrieves the character key associated with the type being operated on.
     * @return a character that represents a type.
     */
    public char getKey() {
        return key;
    }

    /**
     * Retrieves the value of the type being operated on.
     * @return an int representing the value of the piece type.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the piece type that is associated with the given character key.
     * @param key a character that represenets a type.
     * @return the type associated with the key.
     * @throws IllegalArgumentException if the given key is not one of the
     * supported characters.
     */
    public Type getType(char key) throws IllegalArgumentException {
        for (Type type : values()) {
            if (key == type.getKey()) {
                return type;
            }
        }
        throw new IllegalArgumentException("Character not supported.");
    }
}
