
package lk.ijse.dep.service;

//Inheritance: AiPlayer Player class eken extends wela thiyenne
public class AiPlayer extends Player {

    //Constructor: Board object parameter ekak gannawa
    public AiPlayer(Board board) {
        super(board); // Call the superclass constructor
    }

    //movePiece method eka Override karanawa
    @Override
    public void movePiece(int col) {

        col = bestMove();

        //select karapu move ekata board eka update karanawa
        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);//ui eka update karanawa

        //winner check karanawa
        Winner winner = board.findWinner();
        if (winner.getWinningPiece() != Piece.EMPTY) {
            board.getBoardUI().notifyWinner(winner);// winner wa notify kara gannawa
        } else if (!board.existLegalMoves()) {//exit ewa nadda kiyala balanawa

            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));// legal move ekak wath nathnam notify kara gannawa winner kenek na kiyala (empty)
        }
    }


    private int bestMove() {
        boolean isUserWinning = false;
        int tiedColumn = 0;
        int col;

        //column eken ekata iterate karanawa
        for (col = 0; col < 6; ++col) {
            if (board.isLegalMove(col)) {
                //move eka legal da kiyala balala minmax use karala evaluationVal
                int row = board.findNextAvailableSpot(col);//row ekata assign kala
                board.updateMove(col, Piece.GREEN);//col(ilagata legal da kiyala) ekai Piece ekai update karala balanawa
                int evaluationVal = minimax(0, false);//green eka dammama dinnanna puluwan da kiyala balanawa//two player games wala use wenawa /eken karanne best move eka hoyana algorethem ekak
                board.updateMove(col, row, Piece.EMPTY);//board update ekata green ekak dala baluwa ne dn eka undo karanw

                //evaluationVal eka 1 ta = da kiyala balanw
                if (evaluationVal == 1) {
                    return col;//1 nam ai ta hoda spot ekak
                }

                //human winner da kiyala check karanawa
                if (evaluationVal == -1) {//-1 wuna nam userge pathata win eka
                    isUserWinning = true;
                } else {
                    tiedColumn = col;//2 dinan nathnam tied karanw
                }
            }
        }

        // user winning and is legal move eka thiyanawa nam tied column eka yawanawa
        if (isUserWinning && board.isLegalMove(tiedColumn)) {//user dinanawa nam tied column eka haraha green ekak dala block karanw
            return tiedColumn;
        } else {
            // wena option ekk nathi nam random legal move ekak da ganna
            do {
                col = (int) (Math.random() * 6);
            } while (!board.isLegalMove(col));
            return col;
        }
    }

    // Minimax algorithm use karala calculate karanw searchingVal eka
    private int minimax(int depth, boolean maximizingPlayer) {
        // winner kenek innawada kiyala check karanawa
        Winner winner = board.findWinner();
        if (winner.getWinningPiece() == Piece.GREEN) {
            return 1; // AI wins
        } else if (winner.getWinningPiece() == Piece.BLUE) {
            return -1; // human wins
        } else if (board.existLegalMoves() && depth != 2) {
            //
            int col;
            int row;
            int evaluationResult;
            if (!maximizingPlayer) {
                // humans's turn
                for (col = 0; col < 6; ++col) {
                    if (board.isLegalMove(col)) {
                        row = board.findNextAvailableSpot(col);
                        board.updateMove(col, Piece.BLUE);
                        evaluationResult = this.minimax(depth + 1, true);
                        board.updateMove(col, row, Piece.EMPTY);
                        if (evaluationResult == -1) {
                            return evaluationResult;
                        }
                    }
                }
            } else {
                // AI's turn
                for (col = 0; col < 6; ++col) {
                    if (board.isLegalMove(col)) {
                        row = board.findNextAvailableSpot(col);
                        board.updateMove(col, Piece.GREEN);
                        evaluationResult = minimax(depth + 1, false);
                        board.updateMove(col, row, Piece.EMPTY);
                        if (evaluationResult == 1) {
                            return evaluationResult;
                        }
                    }
                }
            }
            return 0; // No winner yet
        } else {
            return 0; // No winner yet
        }
    }
}
