package test.java.org.example;

import main.java.org.problems.Problem_7_NthPrimeNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem_7_NthPrimeNumberTest {

  private Problem_7_NthPrimeNumber obj = new Problem_7_NthPrimeNumber();

  @Test
  public void whenGivenANumberAsN_findNthPrimeNumber(){
    int n = 6;
    assertEquals(13, obj.getNthPrimeNumber(n));

    n = 7;
    assertEquals(17, obj.getNthPrimeNumber(n));

    n = 8;
    assertEquals(19, obj.getNthPrimeNumber(n));

    n = 9;
    assertEquals(23, obj.getNthPrimeNumber(n));

    n = 10_001;
    assertEquals(104743, obj.getNthPrimeNumber(n));
  }
}
