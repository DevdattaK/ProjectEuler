package test.java.org.example;

import main.java.org.problems.Problem_8_LargestProductInASeries;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem_8_LargestProductInSeriesTest {

  private Problem_8_LargestProductInASeries obj = new Problem_8_LargestProductInASeries();


  @Test
  public void whenGivenNumberOfDigitsAndStartLocation_thenReturnCorrespondingNonZeroNumberAsString(){
    int start = 3, length = 4;

    StringBuilder result = obj.getStringBuilderWithNextNumericString(start, length, Optional.empty());
    assertEquals("6717", result.toString());

    result = obj.getStringBuilderWithNextNumericString(start, length, Optional.of(result));
    assertEquals("7176", result.toString());

    start = 999; length = 3;
    result = obj.getStringBuilderWithNextNumericString(start, length, Optional.empty());
    assertEquals("", result.toString());
  }

  @Test
  public void whenGivenANumberAsString_thenReturnItsNumericRepresentation(){
    StringBuilder sb = new StringBuilder("101");
    assertEquals(101, obj.getProductOfDigits(sb));
    sb.setLength(0);
    sb.append("01");
    assertEquals(1, obj.getProductOfDigits(sb));
    sb.setLength(0);
    sb.append("10");
    assertEquals(10, obj.getProductOfDigits(sb));
    sb.setLength(0);
    sb.append("50234");
    assertEquals(50234, obj.getProductOfDigits(sb));
  }

  @Test
  public void whenGivenNumberOfDigits_thenComputeLargestProductOfConsecutiveDigits(){
    assertEquals(5832, obj.getProductOfnConsecutiveDigitsInNumber(4));
    assertEquals(23514624000l, obj.getProductOfnConsecutiveDigitsInNumber(13));
  }
}
