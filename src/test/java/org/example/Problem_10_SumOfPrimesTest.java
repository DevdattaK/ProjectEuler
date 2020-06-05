package test.java.org.example;

import main.java.org.problems.Problem_10_SumOfPrimes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem_10_SumOfPrimesTest {

  private Problem_10_SumOfPrimes obj = new Problem_10_SumOfPrimes();

  @Test
  public void pythagoreanTripleProductTest(){
    assertEquals(17, obj.getSumOfPrimesInRange(2, 10));

    assertEquals(7, obj.getSumOfPrimesInRange(6, 10));

    assertEquals(277050, obj.getSumOfPrimesInRange(2, 2_000));

    assertEquals(142913828922l, obj.getSumOfPrimesInRange(2, 2_000_000));

    //2 billion range takes too much time.
    //assertEquals(142913828922l, obj.getSumOfPrimesInRange(2, 2_000_000_000));
  }


  @Test
  public void whenGivenARange_theComputeSomeOfPrimesInThatRangeUsingEratostheneseMethod(){
    assertEquals(17, obj.getSumOfPrimesInRangeUsingEratostheneseMethod(2, 10));

    assertEquals(7, obj.getSumOfPrimesInRangeUsingEratostheneseMethod(6, 10));

    assertEquals(142913828922l, obj.getSumOfPrimesInRangeUsingEratostheneseMethod(2, 2_000_000));
  }

}
