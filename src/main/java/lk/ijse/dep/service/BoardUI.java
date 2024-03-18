package lk.ijse.dep.service;

public interface BoardUI {
    public void update(int col,boolean isHuman);
    void notifyWinner(Winner winner);
}
    /*

    The BoardUI interface defines the contract for interacting with the user interface of the game board. Here's an explanation of the methods:

    update(int col, boolean isHuman) Method:

    This method is called to update the UI when a move is made on the board.
    Parameters:
    col: The column index where the move was made.
    isHuman: A boolean value indicating whether the move was made by a human player (true) or an AI player (false).
    This method is responsible for visually updating the game board in the user interface to reflect the move that was made.
    notifyWinner(Winner winner) Method:

    This method is called to notify the UI when a winner is determined.
    Parameters:
    winner: A Winner object representing the winning player or an empty piece if there is no winner.
    This method is responsible for displaying a notification in the UI indicating the winner of the game or if the game ended in a draw.
    In summary, the BoardUI interface provides methods for updating the game board in the user interface and notifying the UI about the game's outcome. Implementations of this interface will handle the specifics of updating and notifying the user interface based on the requirements of the game.






     */