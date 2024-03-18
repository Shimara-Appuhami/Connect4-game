package lk.ijse.dep.service;
//Inheritance
public class HumanPlayer extends Player{
    public HumanPlayer(Board board) {
        super(board);// Call karanawa superclass eke thiyana constructor ekata(Player)
    }

    @Override
    public void movePiece(int col) {

        if (board.isLegalMove(col)) {  // move eka legal da kiyala check karanwa
            board.updateMove(col, Piece.BLUE);//human palyer ge move eka anuwa update karala human piece eka blue clour kiyala assume karanawa
            board.getBoardUI().update(col, true); //human player ge move pennanna UI eka update karanawa
            Winner winner = board.findWinner();//move ekata passe winner kenek innawada kiyala check karanawa
            if (winner.getWinningPiece() != Piece.EMPTY) {// ui notify karagannawa winner kenek innawada kiyala
                board.getBoardUI().notifyWinner(winner);//ui notify kara gannawa winner wa
            } else if (!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY)); // Notify kara gannawa UI game eka draw nam tied kiyala
            }
        }
    }
}