
package lk.ijse.dep.service;

// Inheritance: AiPlayer Player class eken extends wela thiyenne
public class AiPlayer extends Player {

    // Constructor: Board object parameter ekak gannawa
    public AiPlayer(Board board) {
        super(board); // Call the superclass constructor
    }

    //movePiece method eka Override karanawa
    //add test commit
    @Override
    public void movePiece(int col) {
        //minimax algorithm eka use karala best move eka hoya gatha
        col = bestMove();

        //select karapu move ekata board eka update karanawa
        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false); //ui eka update karanawa

        // winner check karanawa
        Winner winner = board.findWinner();
        if (winner.getWinningPiece() != Piece.EMPTY) {
            board.getBoardUI().notifyWinner(winner); // winner wa notify kara gannawa
        } else if (!board.existLegalMoves()) {
            // legal move ekak wath nathnam notify kara gannawa winner kenek na kiyala (empty)
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

    //minimax eka use karala best move eka hoya gannawa
    private int bestMove() {
        boolean isUserWinning = false;
        int tiedColumn = 0;
        int col;

        //column eken ekata iterate karanawa
        for (col = 0; col < 6; ++col) {
            if (board.isLegalMove(col)) {
                //move eka legal da kiyala balala minmax use karala searchingVal
                int row = board.findNextAvailableSpot(col);
                board.updateMove(col, Piece.GREEN);
                int evaluationVal = minimax(0, false);
                board.updateMove(col, row, Piece.EMPTY);

                //evaluationVal eka
                if (evaluationVal == 1) {
                    return col;
                }

                //human winner da kiyala check karanawa
                if (evaluationVal == -1) {
                    isUserWinning = true;
                } else {
                    tiedColumn = col;
                }
            }
        }

        // human is winning nam tied column eka play karanwa
        if (isUserWinning && board.isLegalMove(tiedColumn)) {
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
