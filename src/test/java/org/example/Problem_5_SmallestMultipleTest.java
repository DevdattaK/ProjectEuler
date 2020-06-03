package test.java.org.example;

import main.java.org.problems.Problem_5_SmallestMultiple;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class Problem_5_SmallestMultipleTest {

  private Problem_5_SmallestMultiple obj = new Problem_5_SmallestMultiple();

  @Test
  public void whenGivenANumber_thenProvideItsPrimeFactorsAlongWithFequency() {

    Map<Integer, Map<Integer, Integer>> mapOfPrimeFactors = new HashMap<>();
    Function<Integer, Map<Integer, Integer>> getPreviousPrimeFactorMap =
        (num) -> {
          Map<Integer, Integer> result = new HashMap<>();
          for (int i = 2; i < num; i++) {
            if (mapOfPrimeFactors.containsKey(i))
              result.putAll(mapOfPrimeFactors.get(i));
          }

          return result;
        };

    int number = 2;
    Map<Integer, Integer> result = obj.getPrimeFactorFrequenciesOf(number, new HashMap<>());
    if (obj.isPrime.test(number)) mapOfPrimeFactors.put(number, result);

    assertTrue(result.containsKey(2));
    assertEquals(result.get(2), 1);
    assertEquals(result.size(), 1);

    number = 3;
    result = obj.getPrimeFactorFrequenciesOf(number, getPreviousPrimeFactorMap.apply(number));
    if (obj.isPrime.test(number)) mapOfPrimeFactors.put(number, result);
    assertTrue(result.containsKey(3));
    assertEquals(result.get(3), 1);
    assertEquals(result.size(), 1);

    number = 4;
    result = obj.getPrimeFactorFrequenciesOf(number, getPreviousPrimeFactorMap.apply(number));
    if (obj.isPrime.test(number)) mapOfPrimeFactors.put(number, result);

    assertTrue(result.containsKey(2));
    assertEquals(result.get(2), 2);
    assertEquals(result.size(), 1);

    number = 5;
    result = obj.getPrimeFactorFrequenciesOf(number, getPreviousPrimeFactorMap.apply(number));
    if (obj.isPrime.test(number)) mapOfPrimeFactors.put(number, result);

    assertTrue(result.containsKey(5));
    assertEquals(result.get(5), 1);
    assertEquals(result.size(), 1);

    number = 6;
    result = obj.getPrimeFactorFrequenciesOf(number, getPreviousPrimeFactorMap.apply(number));
    if (obj.isPrime.test(number)) mapOfPrimeFactors.put(number, result);

    assertTrue(result.containsKey(2));
    assertEquals(result.get(2), 1);
    assertTrue(result.containsKey(3));
    assertEquals(result.get(3), 1);
    assertEquals(result.size(), 2);
  }

  @Test
  public void whenGivenStartAndEnd_thenFindSmallestMultiple(){
    int number = 10;

    long smallestMultiple = obj.getSmallestMultipleForRange(1, 10);
    assertEquals(2520, smallestMultiple);

    smallestMultiple = obj.getSmallestMultipleForRange(1, 20);
    assertEquals(232792560, smallestMultiple);
  }
}
