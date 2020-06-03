package test.java.org.example;

import main.java.org.problems.Problem_6_SumSquareDifference;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem_6_SumSquareDifferenceTest {

  private Problem_6_SumSquareDifference obj = new Problem_6_SumSquareDifference();

  @Test
  public void whenGivenStartAndEnd_thenFindSumOfSquares() {
    assertEquals(385, obj.getSumOfSquaresForRange(1, 10));
  }

  @Test
  public void whenGivenStartAndEnd_thenFindSquareOfSum() {
    assertEquals(3025, obj.getSquareOfSumForRange(1, 10));
  }

  @Test
  public void whenGivenStartAndEnd_thenFindDifferenceBetweenSumOfSquaresAndSquareOfSum() {
    assertEquals(
        2640, Math.abs(obj.getSquareOfSumForRange(1, 10) - obj.getSumOfSquaresForRange(1, 10)));
    assertEquals(
            25164150, Math.abs(obj.getSquareOfSumForRange(1, 100) - obj.getSumOfSquaresForRange(1, 100)));
  }
}
