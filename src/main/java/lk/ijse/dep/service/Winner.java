package lk.ijse.dep.service;

public class Winner {
    //Encapsulation
    private Piece winningPiece;
    private int col1;
    private int row1;
    private int col2;
    private int row2;

    public Winner(Piece winningPiece, int col1, int row1, int col2, int row2) {
        this.winningPiece = winningPiece;
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
    }
    public Winner(Piece winningPiece) {
        this.setWinningPiece(winningPiece);
        this.setCol1(-1);
        this.setRow1(-1);
        this.setCol2(-1);
        this.setRow2(-1);
    }


    public Piece getWinningPiece() {
        return winningPiece;
    }

    public void setWinningPiece(Piece winningPiece) {
        this.winningPiece = winningPiece;
    }

    public int getCol1() {
        return col1;
    }

    public void setCol1(int col1) {
        this.col1 = col1;
    }

    public int getRow1() {
        return row1;
    }

    public void setRow1(int row1) {
        this.row1 = row1;
    }

    public int getCol2() {
        return col2;
    }

    public void setCol2(int col2) {
        this.col2 = col2;
    }

    public int getRow2() {
        return row2;
    }

    public void setRow2(int row2) {
        this.row2 = row2;
    }

    @Override
    public String toString() {
        return "Winner{" +
                "winningPiece=" + winningPiece + ", col1="
                + col1 +
                ", row1=" + row1 +
                ", col2=" + col2 +
                ", row2=" + row2 +
                '}';

    }

}
    /*
    The Winner class represents the outcome of a game round, indicating the winning piece and the positions on the game board where the win occurred. Here's an explanation of the class:

    Fields:

    winningPiece: Represents the piece (BLUE or GREEN) that won the game.
    col1, row1: Represents the column and row indices of the first position where the winning sequence starts.
    col2, row2: Represents the column and row indices of the last position where the winning sequence ends.
    Constructors:

    public Winner(Piece winningPiece, int col1, int row1, int col2, int row2): Initializes a new instance of the Winner class with the specified winning piece and positions.
    Parameters:
    winningPiece: The piece (BLUE or GREEN) that won the game.
    col1, row1: The column and row indices of the first position where the winning sequence starts.
    col2, row2: The column and row indices of the last position where the winning sequence ends.
    public Winner(Piece winningPiece): Initializes a new instance of the Winner class with the specified winning piece only.
    This constructor is used when there is no specific winning sequence, such as in the case of a tie game or when the game is just starting.
    It sets the positions (col1, row1, col2, row2) to -1 to indicate that they are not applicable.
    Getter and Setter Methods:

    Getter methods (getWinningPiece(), getCol1(), getRow1(), getCol2(), getRow2()) are provided to retrieve the values of the corresponding fields.
    Setter methods (setWinningPiece(), setCol1(), setRow1(), setCol2(), setRow2()) are provided to set the values of the corresponding fields.
    toString() Method:

    Overrides the toString() method to provide a string representation of the Winner object.
    Returns a string containing the values of all fields of the Winner object.
    Overall, the Winner class encapsulates the information about the winning outcome of a game round, including the winning piece and the positions on the game board where the win occurred.

     */