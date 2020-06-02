package main.java.org.problems;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * <p>What is the largest prime factor of the number 600851475143 ?
 */
public class Problem_3_LargestPrimeFactor {
  private Predicate<Long> isPrime =
      (n) -> {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
      };

  public void printLargestPrimeFactor(long number) {
    int divider = 2;
    Double potentialLargestFactor = null;
    int totalIterations = 0;


    while (divider < number/2) {
      potentialLargestFactor =  (double)number / divider;
      if (potentialLargestFactor > 1
          && potentialLargestFactor.compareTo(Math.floor(potentialLargestFactor)) == 0) {
        if (isPrime.test(potentialLargestFactor.longValue())) {
          System.out.println("Largest Prime factor of " + number + " = " + potentialLargestFactor);
          break;
        }
      }
      divider++;
    }
  }
}
