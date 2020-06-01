package test.java.org.example;

import main.java.org.problems.Problem_1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Problem_1_Test {
  private Problem_1 problem1 = new Problem_1();

  @Test
  public void whenGivenListOfDivisorsAndMaxNum_thenGiveAdditionOfDuplicatesOfNumsLessThanMax() {
    long result = problem1.findSumOfMultiplesOfNumbers(Arrays.asList(3, 5), 1000);
    System.out.println(result);
  }
}
