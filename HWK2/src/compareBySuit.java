import java.util.Comparator;

public class compareBySuit implements Comparator<Card> {

  @Override
  public int compare(Card o1, Card o2) {
    int a = 0, b = 0;
    switch (o1.getSuit()) {
      case CLUBS : a = 1; break;
      case HEARTS: a = 2; break;
      case DIAMONDS: a = 3; break;
      case SPADES: a = 4; break;
    }
    switch (o2.getSuit()) {
      case CLUBS : b = 1; break;
      case HEARTS: b = 2; break;
      case DIAMONDS: b = 3; break;
      case SPADES: b = 4; break;
    }
    return a - b;
  }
}
