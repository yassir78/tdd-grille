package utils;

public enum Jeton {
    X('X'), O('O');

    private final char asChar;

    Jeton(char asChar) {
        this.asChar = asChar;
    }

    public char asChar() {
        return asChar;
    }

}
