import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CardHand <C> implements Hand<C>{

  List<C> list = new ArrayList<>();

  /**
   * Constructor
   * @return empty carHand
   */
  public Hand<C> CreateHand() {
    return new CardHand<C>();
  }


  /**
   * add one <C> to the “front” of a Hand
   * @param
   */
  @Override
  public void add(C c) {
    List<C> tmp = new ArrayList<>();
    tmp.add(c);
    tmp.addAll(list);
    list.clear();
    list.addAll(tmp);
  }

  /**
   * remove the index’th <C>
   * from a Hand
   * @param index
   */
  @Override
  public void discard(int index) {
     int size = list.size();
     if (index >= size) {
       throw new IndexOutOfBoundsException();
     }else {
       list.remove(index);
     }

  }

  /**
   * get the index’th
   * <C> from the Hand
   * @param index
   * @return the item on postion index
   */
  @Override
  public C get(int index) {
    int size = list.size();
    C k = null;
    if (index >= size) {
      throw new IndexOutOfBoundsException();
    }else {
      k = list.get(index);
    }
    return k;
  }

  /**
   *
   * @return the
   * number of <C>s currently in the Hand
   */
  @Override
  public int getSize() {
    return list.size();
  }

  /**
   * Check if the list is empty
   * @return
   */
  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }


  /**
   * return the index of the first item in the Hand that is equal to it
   * @param c
   * @return
   */
  @Override
  public int find(C c) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(c)){
        return i;
      }

    }
    return -1;
  }

  /**
   * accepts a higher-order comparison Function as an argument and calls Collections.sort on the
   * Hand
   * @param comparator
   */
  @Override
  public void sortHand(Comparator<C> comparator) {
    Collections.sort(list, comparator);
  }

  /**
   * return a subset of a Hand based on a
   * Predicate
   * @param predicate
   * @return a subset of a Hand based on a
   *     Predicate
   */
  @Override
  public Hand<C> getHand(Predicate<C> predicate) {
    Hand<C> newCardSet = CreateHand();
    for (C c : list) {
      if (predicate.test(c)) {
        newCardSet.add(c);
      }
    }
    return newCardSet;
  }

  /**
   *
   * @return the sum of the ranks of the cards in the han
   */
  @Override
  public int rankSum() {
    if (list.isEmpty()) {
      return 0;
    }
    int sum = 0;
    if (list.get(0) instanceof Card) {
      for (int i = 0; i < list.size(); i++) {
        Card card = (Card) list.get(i);
        sum += card.getRank();
      }
    }
    return sum;
  }

  /**
   *
   * @param function
   * @return a Hand<C> where C is
   * some other reference type
   * @param <T>
   */
  @Override
  public <T> Hand<T> getMap(Function<C, T> function) {
    Hand<T> handMap = new CardHand<T>();
    for (C c : list) {
      handMap.add(function.apply(c));
    }
    return handMap;
  }
}
