package main.java.org.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is
 * 13. *
 *
 * <p>What is the 10 001st prime number?
 */
public class Problem_7_NthPrimeNumber {

  private List<Long> primesSoFar = new ArrayList<>();

  public long getNthPrimeNumber(int n) {

    Predicate<Long> isPrimeNumber =
        (num) -> {
          return primesSoFar.stream().filter(i -> i <= Math.sqrt(num)).noneMatch(i -> num % i == 0);
        };

    long curNum = 2;

    while (primesSoFar.size() < n) {
      if (isPrimeNumber.test(curNum)) {
        primesSoFar.add(curNum);
      }
      curNum += 1l;
    }

    long result = primesSoFar.get(primesSoFar.size() - 1);

    primesSoFar.clear();

    return result;
  }
}
