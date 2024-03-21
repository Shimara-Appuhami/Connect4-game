package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces;
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];//array eka piece ekata assign kala
        this.boardUI = boardUI;

        for (int i = 0; i < NUM_OF_COLS; i++) {//mulu board ekama empty karanwa
            for (int j = 0; j < NUM_OF_ROWS; j++) {
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
            if (pieces[col][i] == Piece.EMPTY) {//col i empty da kiyala balanwa 2 emptyda balanaw empty nam return kanwa nathnam -1 return karanwa
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
        if (findNextAvailableSpot(col) != -1) {//spot eka -1 nemeda kiyala banawa ehema nathnam
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
    public boolean existLegalMoves() {//legal move ekakda kiyala balanawa
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
        pieces[col][findNextAvailableSpot(col)] = move;   //array ekata col,spot ekai da gannawa assign karagannawa move eka
    }

    @Override
    public void updateMove(int col, int row, Piece move) {

        pieces[col][row] = move;
    }

    @Override
    public Winner findWinner() {

        int rowcount;
        for (int col = 0; col < NUM_OF_COLS; col++) {
            int rowloop = findNextAvailableSpot(col) == -1 ? NUM_OF_ROWS : findNextAvailableSpot(col);
            rowcount = 0;
            for (int row = 1; row < rowloop; row++) {
                if (pieces[col][row].equals(pieces[col][row - 1])) {//danata thiyana row ekata kalin ekata samanada balanawa
                    rowcount++;
                    if (rowcount == 3) {
                        return new Winner(pieces[col][row], col, row - 3, col, row);
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
                        return new Winner(pieces[col][row], col - 3, row, col, row);
                    }
                } else {
                    count = 1;
                }
            }
        }

        return new Winner(Piece.EMPTY);//winner kenek nathnam empty karanwa
    }

    @Override
    public Piece[][] getPieces() {
        return new Piece[0][];
    }

}
