/**
 * Represents the model of a Tic Tac Toe game.
 */
public interface TicTacToeModel {

  /**
   * Initializes the game board.
   */
  void initializeBoard();

  /**
   * Retrieves the current player.
   *
   * @return the current player
   */
  Player getCurrentPlayer();

  /**
   * Makes a move on the game board at the specified position.
   *
   * @param row    the row index of the move
   * @param column the column index of the move
   * @throws IllegalArgumentException if the specified position is invalid or already occupied
   */
  void makeMove(int row, int column);

  /**
   * Retrieves the player who has won the game.
   *
   * @return the winning player, or {@code Player.NOBODY} if no winner yet
   */
  Player getWinner();

  /**
   * Checks if the game board is full.
   *
   * @return {@code true} if the board is full, {@code false} otherwise
   */
  boolean isBoardFull();

  /**
   * Resets the game to its initial state.
   */
  void resetGame();

  /**
   * Check the winner of this game
   */
  void checkWinner();

}
