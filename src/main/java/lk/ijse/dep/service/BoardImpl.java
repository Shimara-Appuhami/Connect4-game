package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces;
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        this.boardUI = boardUI;

        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {     //set EMPTY values
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {

        return this.boardUI;            //should return the memory location of the BoardUI
    }



    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                return i;       //available
            }
        }
        return -1;              // columns is full  if return -1
    }

    @Override
    public boolean isLegalMoves(int col1) {

        return false;
    }

    @Override
    public boolean isLegalMove(int col) {
        if (findNextAvailableSpot(col) != -1) {
            return true;        //if column is available
        } else {
            return false;       //if column is full
        }
    }

    @Override
    public boolean exitLegalMoves() {

        return false;
    }

    @Override
    public void updateMove(int col, boolean isHuman) {

    }

    @Override
    public boolean existLegalMoves() {
        for (int col = 0; col < NUM_OF_COLS; col++) {
            if (isLegalMove(col)) {
                return true; //if legal move
            }
        }
        return false; //if not legal move
    }

    @Override
    public void updateMove(int col, boolean isHuman, Piece move) {

    }

    @Override
    public void updateMove(int col, Piece move) {
        pieces[col][findNextAvailableSpot(col)] = move;   //  method should update the board by putting the piece  whose turn it is in the first free row of the specified column.
    }

    @Override
    public void updateMove(int col, int row, Piece move) {  //minimax

        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {

        int rowcount;
        for (int col = 0; col < NUM_OF_COLS; col++) {
            int rowloop = findNextAvailableSpot(col) == -1 ? NUM_OF_ROWS : findNextAvailableSpot(col);
            rowcount = 0;
            for (int row = 1; row < rowloop; row++) {
                if (pieces[col][row].equals(pieces[col][row - 1])) {
                    rowcount++;
                    if (rowcount == 3) {
                        return new Winner(pieces[col][row], col, row - 3, col, row);    //connect 4 pieces vertically
                    }
                } else {
                    rowcount = 0;
                }
            }
        }

        for (int row = 0; row < NUM_OF_ROWS; row++) {
            int count = 1;
            for (int col = 1; col < NUM_OF_COLS; col++) {
                if (pieces[col][row] == pieces[col - 1][row]) {
                    count++;
                    if (count == 4) {
                        return new Winner(pieces[col][row], col - 3, row, col, row);    //connect 4 pieces horizontally
                    }
                } else {
                    count = 1;
                }
            }
        }

        return new Winner(Piece.EMPTY);
    }

    @Override
    public Piece[][] getPieces() {
        return new Piece[0][];
    }

}
