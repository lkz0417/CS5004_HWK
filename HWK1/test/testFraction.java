import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class testFraction {
  Fractionimpl fraction1;
  Fractionimpl fraction2;

  /**
   * test if constructor is legal
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception{
    fraction1 = new Fractionimpl(5,2);
    fraction2 = new Fractionimpl(5,3);
  }

  /**
   * test toDouble method
   * @throws Exception
   */
  @Test
  public void testToDouble() throws Exception{
    int numerator = fraction1.getNumerator();
    int denominator = fraction1.getDenominator();
    double res = (double)(numerator)/(double)(denominator);
    assertEquals(res, fraction1.toDouble(),0.001);
  }

  /**
   * test toString method
   * @throws Exception
   */
  @Test
  public void testToString() throws Exception{
    int numerator = fraction1.getNumerator();
    int denominator = fraction1.getDenominator();
    int left = numerator / Fractionimpl.gcd(numerator, denominator);
    int right = denominator / Fractionimpl.gcd(numerator, denominator);
    assertEquals(fraction1.toString(), left + "/" + right);
  }

  /**
   * test Reciprocal method
   * @throws Exception
   */
  @Test
  public void testReciprocal() throws Exception{
    int numerator = fraction1.getNumerator();
    int denominator = fraction1.getDenominator();
    double recip = (double)(denominator)/(double)(numerator);
    assertEquals(recip, fraction1.reciprocal(), 0.001);
  }

  /**
   * test Add method
   * @throws Exception
   */
  @Test
  public void testAdd() throws Exception{
    double res = fraction1.toDouble() + fraction2.toDouble();
    assertEquals(fraction1.add(fraction2), res, 0.001);
  }

  /**
   * test compareTo method
   * @throws Exception
   */
  @Test
  public void testCompare() throws Exception{
    int res = 0;
    if(fraction1.toDouble() < fraction2.toDouble()){
      res = -1;
    }else if(fraction1.toDouble() == fraction2.toDouble()){
      res = 0;
    }else{
      res = 1;
    }
    assertEquals(res, fraction1.compareTo(fraction2));
  }

}
