import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestHand {
  Card card1 = new Card(Suit.DIAMONDS, 5);
  Card card2 = new Card(Suit.CLUBS, 10);
  Card card3;
  CardHand<Card> cardHand = new CardHand<Card>();
  CardHand<Card> cardHand2 = new CardHand<Card>();

  /**
   * init
   */
  @Before
  public void init() {
    cardHand.add(card2);
    cardHand.add(card1);
  }

  /**
   * testConstructor
   */
  @Test
  public void testConstructor1 () {
    card3 = new Card(Suit.HEARTS, 12);
  }

  /**
   * testConstructorWithException
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testConstructor2() {
    card3 = new Card(Suit.HEARTS, 14);
  }

  /**
   * testAdd
   */
  @Test
  public void testAdd() {
    cardHand.add(card2);
    cardHand.add(card1);
    for (int i = 0; i < cardHand.getSize(); i++) {
      System.out.println(cardHand.get(i));
    }
    assertEquals(card1, cardHand.get(0));
    assertEquals(card2, cardHand.get(1));

  }

  /**
   * test the method of discard
   */
  @Test
  public void testDiscard() {
    cardHand.discard(0);
    assertEquals(cardHand.get(0), card2);
    cardHand.discard(0);
    assertTrue(cardHand2.isEmpty());
  }

  /**
   * test discard with exception
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testDiscardWithException() {
    cardHand.discard(3);
    cardHand.discard(10);
  }

  /**
   * testGet
   */
  @Test
  public void testGet1() {
    assertEquals(card1, cardHand.get(0));
    assertEquals(card2, cardHand.get(1));
  }

  /**
   * testGetWithException
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetWithException() {
    Card card = cardHand.get(10);
    card = cardHand.get(100);
  }

  /**
   * test the size of carHand
   */
  @Test
  public void testSize() {
    assertEquals(2, cardHand.getSize());
    cardHand.add(new Card(Suit.SPADES, 6));
    assertEquals(3, cardHand.getSize());
  }

  /**
   * test if the carHand is empty
   */
  @Test
  public void testEmpty() {
    assertTrue(cardHand2.isEmpty());
    assertFalse(cardHand.isEmpty());
  }

  /**
   * test the find method
   */
  @Test
  public void testFind() {
    Card testCard1 = new Card(Suit.CLUBS, 5);
    Card testCard2 = new Card(Suit.DIAMONDS, 10);
    assertEquals(0, cardHand.find(testCard1));
    assertEquals(1, cardHand.find(testCard2));
  }

  /**
   * test SortHand method
   */
  @Test
  public void testSortHand() {
    compareBySuit comparator = new compareBySuit();
    Collections.sort(cardHand.list);
    assertEquals(card1, cardHand.get(0));
    assertEquals(card2, cardHand.get(1));
    cardHand.sortHand(comparator);
    assertEquals(card2, cardHand.get(0));
    assertEquals(card1, cardHand.get(1));
  }

  /**
   * test the method of getHand
   */
  @Test
  public void testGetHand() {
    Predicate<Card> predicate1 = card -> card.getRank() > 6;
    CardHand<Card> carHandTest1 = (CardHand<Card>) cardHand.getHand(predicate1);
    assertEquals(carHandTest1.get(0), card2);
    Predicate<Card> predicate2 = card -> card.getSuit() == Suit.DIAMONDS;
    CardHand<Card> carHandTest2 = (CardHand<Card>) cardHand.getHand(predicate2);
    assertEquals(carHandTest2.get(0), card1);
  }

  /**
   * test the method of rankSum
   */
  @Test
  public void testRankSum() {
    assertEquals(15, cardHand.rankSum());
    card3 = new Card(Suit.HEARTS, 6);
    cardHand.add(card3);
    assertEquals(21, cardHand.rankSum());
  }

  /**
   * test the method of getMap
   */
  @Test
  public void testGetMap() {
    Function<Card, Suit> function1 = card -> card.getSuit();
    Function<Card, Color> function2 = card -> {
      if (card.getSuit() == Suit.DIAMONDS || card.getSuit() == Suit.HEARTS) {
        return Color.RED;
      }else {
        return Color.BLACK;
      }
    };
    Hand<Suit> suitMap = cardHand.getMap(function1);
    Hand<Color> colorMap = cardHand.getMap(function2);
    assertEquals(suitMap.get(0), Suit.CLUBS);
    assertEquals(suitMap.get(1), Suit.DIAMONDS);
    assertEquals(colorMap.get(0), Color.BLACK);
    assertEquals(colorMap.get(1), Color.RED);

  }

}
