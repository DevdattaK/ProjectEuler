package test.java.org.example;

import main.java.org.problems.Problem_3_LargestPrimeFactor;
import org.junit.jupiter.api.Test;

public class Problem_3_LargestPrimeFactorTest {
  private Problem_3_LargestPrimeFactor problem3 = new Problem_3_LargestPrimeFactor();

  @Test
  public void whenGivenANumber_findLargestPrimeFactor() {
    //problem3.printLargestPrimeFactor(13195);

    problem3.printLargestPrimeFactor(600_851_475_143L);
  }

  @Test
  public void whenGivenDouble_ConvertToDoubleObj() {
    int divider = 2;
    double number = 13195;
    Double potentialLargestFactor = null;
    potentialLargestFactor =  (double)(number / divider);

    System.out.println((double)(number / divider));
  }

    static class Problem_4_LargestPalindromeProductTest {

      @Test
      void getLargestPalindromicNumber() {}
    }
}
