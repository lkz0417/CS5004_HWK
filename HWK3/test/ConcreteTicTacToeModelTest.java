
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConcreteTicTacToeModelTest {

  private ConcreteTicTacToeModel model;

  /**
   * Build a new game model before each test
   */
  @Before
  public void setUp() {
    model = new ConcreteTicTacToeModel();
    model.initializeBoard();
  }

  /**
   * test if the method InitializedBoard works well
   */
  @Test
  public void testInitializedBoard() {
    assertNotNull(model.getCurrentPlayer());
    assertEquals(Player.X, model.getCurrentPlayer());
  }

  /**
   * test if method MakeMove works
   */
  @Test
  public void testMakeMove() {
    model.makeMove(0, 0);
    assertEquals(Player.O, model.getCurrentPlayer());
    try {
      model.makeMove(0, 0);
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Pass
    }
  }

  /**
   * test if the exception when two players' position are overlapped
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMakeMoveWithException() {
    model.makeMove(0, 0);
    model.makeMove(0, 0);
  }

  /**
   * test if the checkWinner method works well
   */
  @Test
  public void testGetWinner() {
    model.makeMove(0, 0);
    model.makeMove(1, 1);
    model.makeMove(0, 1);
    model.makeMove(1, 0);
    model.makeMove(0, 2);
    assertEquals(Player.X, model.getWinner());
  }

  /**
   * test if the method IsBoardFull works
   */
  @Test
  public void testIsBoardFull() {
    assertFalse(model.isBoardFull());
    model.makeMove(0, 0);
    model.makeMove(0, 1);
    model.makeMove(0, 2);
    model.makeMove(1, 0);
    model.makeMove(1, 1);
    model.makeMove(1, 2);
    model.makeMove(2, 0);
    model.makeMove(2, 1);
    model.makeMove(2, 2);
    assertTrue(model.isBoardFull());
  }

  /**
   * test if the method ResetGame works well
   */
  @Test
  public void testResetGame() {
    model.makeMove(0, 0);
    model.makeMove(0, 1);
    model.resetGame();
    assertEquals(Player.X, model.getCurrentPlayer());
    assertFalse(model.isBoardFull());
    assertEquals(Player.NOBODY, model.getWinner());
  }
}
