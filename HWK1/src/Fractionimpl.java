public class Fractionimpl implements Fraction{
  private int numerator;
  private int denominator;

  /**
   * Constructor
   * @param numerator
   * @param denominator
   */
  public Fractionimpl(int numerator, int denominator) {
    if(denominator <= 0) {
      throw  new IllegalArgumentException();
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
    if(denominator <= 0) {
      throw new IllegalArgumentException();
    }
    this.denominator = denominator;
  }

  /**
   * calculate numerator / denominator and return in double type
   * @return
   */
  @Override
  public double toDouble() {
    return (double)(numerator)/(double)(denominator);
  }

  /**
   * Simplify the numerator / denominator
   * @return
   */
  @Override
  public String toString() {
    // Divide numerator and denominator by gcd
    int left = numerator / gcd(numerator, denominator);
    int right = denominator / gcd(numerator, denominator);
    return left + "/" + right;
  }

  /**
   * Calculate gcd of two integers
   * @param a
   * @param b
   * @return
   */
  static int gcd(int a, int b) {
    if(b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
   * calculate reciprocal of this fraction
   * @return
   */
  @Override
  public double reciprocal() {
    if(numerator == 0) {
      throw new IllegalArgumentException();
    }
    return (double)(denominator)/(double)(numerator);
  }

  /**
   * Add one fraction to another
   * @param other
   * @return
   */
  @Override
  public double add(Fraction other) {
    return this.toDouble() + other.toDouble();
  }

  /**
   * Compare which fraction is bigger
   * @param other
   * @return
   */
  @Override
  public int compareTo(Fraction other) {
    if(this.toDouble() < other.toDouble()) {
      return -1;
    }else if(this.toDouble() == other.toDouble()) {
      return 0;
    }else {
      return 1;
    }
  }
}
