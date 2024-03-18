package lk.ijse.dep.service;

public interface Board {
    // Constants defining the number of columns and rows on the board

    int NUM_OF_ROWS=5;
    int NUM_OF_COLS=6;
    BoardUI getBoardUI();
    int findNextAvailableSpot(int col);

    boolean isLegalMoves(int col);

    boolean isLegalMove(int col);

    boolean exitLegalMoves();

    void updateMove(int col, boolean isHuman);

    boolean existLegalMoves();

    void updateMove(int col, boolean isHuman, Piece move);

    void updateMove(int col, Piece move);
    void updateMove(int col,int row,Piece move);
    Winner findWinner();
    Piece[][] getPieces();

}