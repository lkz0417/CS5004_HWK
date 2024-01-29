public interface Fraction {

  /**
   * returns the scientific value (decimal) of the fraction.
   * @return
   */
  public double toDouble ();

  /**
   * returns the reciprocal of this fraction.
   * @return
   */
  public double reciprocal();

  /**
   * adds this fraction to the one passed to it and returns the
   * result as a fraction
   * @param other
   * @return
   */
  public double add(Fraction other);

  /**
   * compares two fractions
   * @param other
   * @return
   */
  int compareTo(Fraction other);
}
