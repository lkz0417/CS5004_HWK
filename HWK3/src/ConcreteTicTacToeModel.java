import java.util.Arrays;

public class ConcreteTicTacToeModel implements TicTacToeModel {

  private Player[][] board;
  private Player currentPlayer;
  private Player winner;

  /**
   * Constructor
   */
  public ConcreteTicTacToeModel() {
    initializeBoard();
  }

  /**
   * Initializes the game board.
   */
  @Override
  public void initializeBoard() {
    board = new Player[3][3];
    currentPlayer = Player.X;
    winner = Player.NOBODY;
  }

  /**
   * Retrieves the current player.
   *
   * @return the current player
   */
  @Override
  public Player getCurrentPlayer() {
    return currentPlayer;
  }

  /**
   * Makes a move on the game board at the specified position.
   *
   * @param row    the row index of the move
   * @param column the column index of the move
   * @throws IllegalArgumentException if the specified position is invalid or already occupied
   */
  @Override
  public void makeMove(int row, int column) {
    if (row < 0 || row >= 3 || column < 0 || column >= 3) {
      throw new IllegalArgumentException("Invalid position");
    }
    if (board[row][column] != null) {
      throw new IllegalArgumentException("Position already occupied");
    }
    board[row][column] = currentPlayer;
    checkWinner();
    if (winner == Player.NOBODY) {
      currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }
  }

  /**
   * Retrieves the player who has won the game.
   *
   * @return the winning player, or {@code Player.NOBODY} if no winner yet
   */
  @Override
  public Player getWinner() {
    return winner;
  }

  /**
   * Checks if the game board is full.
   *
   * @return {@code true} if the board is full, {@code false} otherwise
   */
  @Override
  public boolean isBoardFull() {
    for (Player[] row : board) {
      for (Player cell : row) {
        if (cell == null) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Resets the game to its initial state.
   */
  @Override
  public void resetGame() {
    initializeBoard();
  }

  /**
   * Check the winner of this game
   */
  public void checkWinner() {
    // Check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] != null && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
        winner = board[i][0];
        return;
      }
    }
    // Check columns
    for (int i = 0; i < 3; i++) {
      if (board[0][i] != null && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
        winner = board[0][i];
        return;
      }
    }
    // Check diagonals
    if (board[0][0] != null && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
      winner = board[0][0];
      return;
    }
    if (board[0][2] != null && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
      winner = board[0][2];
      return;
    }
    // Check for a draw
    if (isBoardFull()) {
      winner = Player.NOBODY;
    }
  }
}
