package lk.ijse.dep.service;

public class Player {
    public Board board;
    public Player (Board board){

        this.board=board;
    }
    public void movePiece(int col){

    }
}
    /*
    The Player class serves as the base class for different types of players in the game. Here's an explanation of the class:

    Fields:

    board: Represents the game board associated with the player.
    Constructor:

    public Player(Board board): Initializes a new instance of the Player class with the specified game board.
    Parameters:
    board: The game board associated with the player.
    Inside the constructor, the provided game board is assigned to the board field.
    movePiece(int col) Method:

    This method represents the action of a player making a move on the game board.
    Parameters:
    col: The column index where the player intends to make a move.
    This method is intended to be overridden by subclasses to implement specific behaviors for different types of players.
    By default, the method does not perform any action and serves as a placeholder for subclasses to provide their own implementation.
    Overall, the Player class provides a common structure and behavior that can be extended by subclasses to represent different types of players in the game, such as human players (HumanPlayer) and AI players (AiPlayer).






     */