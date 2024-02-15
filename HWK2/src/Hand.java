import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Hand <C>{

  /**
   * Constructor
   * @return empty carHand
   */
  Hand<C> CreateHand();

  /**
   * add one <C> to the “front” of a Hand
   * @param
   */
  void add(C c);

  /**
   * remove the index’th <C>
   * from a Hand
   * @param index
   */
  void discard(int index);

  /**
   * get the index’th
   * <C> from the Hand
   * @param index
   * @return the item on postion index
   */
  C get(int index);

  /**
   *
   * @return the
   * number of <C>s currently in the Hand
   */
  int getSize();

  /**
   * Check if the list is empty
   * @return
   */
  boolean isEmpty();

  /**
   * return the index of the first item in the Hand that is equal to it
   * @param c
   * @return
   */
  int find(C c);

  /**
   * accepts a higher-order comparison Function as an argument and calls Collections.sort on the
   * Hand
   * @param comparator
   */
  void sortHand(Comparator<C> comparator);

  /**
   * return a subset of a Hand based on a
   * Predicate
   * @param predicate
   * @return a subset of a Hand based on a
   *     Predicate
   */
  Hand<C> getHand(Predicate<C> predicate);

  /**
   *
   * @return the sum of the ranks of the cards in the han
   */
  int rankSum();

  /**
   *
   * @param function
   * @return a Hand<C> where C is
   * some other reference type
   * @param <T>
   */
  <T> Hand<T> getMap(Function<C, T> function);

}
