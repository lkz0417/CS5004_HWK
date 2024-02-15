import java.util.Objects;

public class Card implements Comparable<Card> {
  private Suit suit;
  private int rank;

  public Card(Suit suit, int rank) {
    if (rank < 1 || rank > 13) {
      throw new IndexOutOfBoundsException();
    }
    this.suit = suit;
    this.rank = rank;

  }

  public Suit getSuit() {
    return suit;
  }

  public int getRank() {
    return rank;
  }

  public Color getColor() {
    return (suit == Suit.CLUBS || suit == Suit.SPADES) ? Color.BLACK : Color.RED;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Card card)) {
      return false;
    }
    return rank == card.rank && suit == card.suit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(suit, rank);
  }

  @Override
  public String toString() {
    return "Card{" +
        "suit=" + suit +
        ", rank=" + rank +
        '}';
  }

  @Override
  public int compareTo(Card o) {
    return rank - o.getRank();
  }
}

