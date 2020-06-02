package test.java.org.example;

import main.java.org.problems.Problem_2_EvenValuedFibAddition;
import org.junit.jupiter.api.Test;

public class Problem_2_EvenValuedFibAdditionTest {
  private Problem_2_EvenValuedFibAddition problem2 = new Problem_2_EvenValuedFibAddition();

  @Test
  public void whenGivenListOfDivisorsAndMaxNum_thenGiveAdditionOfDuplicatesOfNumsLessThanMax() {
    long maxLimit = 4_000_000L;
    long result = problem2.getAdditionOfEvenValuedFibUptoSpecifiedLimit(maxLimit);
    System.out.println(String.format("Sum of even valued Fibs upto %d is %d ", maxLimit, result));
  }
}
