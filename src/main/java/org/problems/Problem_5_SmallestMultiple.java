package main.java.org.problems;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any
 * remainder. What is the smallest positive number that is evenly divisible by all of the numbers
 * from 1 to 20?
 *
 * <p>DRK : This is a problem of finding LeastCommonMultiple - LCM. Link :
 * http://www.math.com/school/subject1/lessons/S1U3L3DP.html
 */
public class Problem_5_SmallestMultiple {

  private BiPredicate<Integer, Set<Integer>> isPrimeBasedOnPrimesComputedSoFar =
      (number, primeFactorsSoFar) -> {
        return primeFactorsSoFar.stream()
            .filter(e -> e <= Math.sqrt(number))
            .noneMatch(i -> number % i == 0);
      };

  public Predicate<Integer> isPrime =
      (number) -> {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(i -> number % i == 0);
      };

  public Map<Integer, Integer> getPrimeFactorFrequenciesOf(
      int number, Map<Integer, Integer> primeFactorsMapWithMaxFrequencies) {
    List<Map.Entry<Integer, Integer>> primeFactors = null;
    Map<Integer, Integer> result = new HashMap<>();
    BiConsumer<Map.Entry<Integer, Integer>, Map<Integer, Integer>> resultFrequencyUpdater =
        (e, m) -> {
          if (m.containsKey(e.getKey())) {
            m.put(e.getKey(), m.get(e.getKey()) + 1);
          } else {
            m.put(e.getKey(), 1);
          }
        };

    if (number > 1) {
      if (isPrimeBasedOnPrimesComputedSoFar.test(
          number, primeFactorsMapWithMaxFrequencies.keySet())) {
        result.put(number, 1);
      } else {
        int curNumber = number;
        Map.Entry<Integer, Integer> primeFactorEntry;
        int curPrime;
        primeFactors = new ArrayList<>(primeFactorsMapWithMaxFrequencies.entrySet());
        primeFactors.sort(Map.Entry.comparingByKey());
        int i;

        for (i = 0; i < primeFactors.size(); ) {
          primeFactorEntry = primeFactors.get(i);
          curPrime = primeFactorEntry.getKey();

          if (curNumber % curPrime == 0) {
            curNumber /= curPrime;
            resultFrequencyUpdater.accept(primeFactorEntry, result);
            i = 0;
          } else {
            i++;
          }
        }
        if (i >= primeFactors.size() && curNumber > 1) result.put(curNumber, 1);
      }
    } else {
      System.out.println("Given number is not valid for prime factor computation.");
      result = null;
    }

    return result;
  }

  public long getSmallestMultipleForRange(int start, int end) {
    long result = 1l;
    Map<Integer, Integer> primeFactorsMapWithMaxFrequencies = new HashMap<>();
    Map<Integer, Integer> primeFactorFreqMap = null;
    BiConsumer<Map<Integer, Integer>, Map<Integer, Integer>> mapUpdaterWithMaxFreq =
        (ref, target) -> {
          Integer val = 0;
          for (Integer key : ref.keySet()) {
            val = ref.get(key);
            if (target.containsKey(key)) {
              target.put(key, val > target.get(key) ? val : target.get(key));
            } else {
              target.put(key, 1);
            }
          }
        };

    start = start == 0 || start == 1 ? 2 : start;

    for (int number = start; number <= end; number++) {
      primeFactorFreqMap =
          this.getPrimeFactorFrequenciesOf(number, primeFactorsMapWithMaxFrequencies);

      mapUpdaterWithMaxFreq.accept(primeFactorFreqMap, primeFactorsMapWithMaxFrequencies);
    }

    for (Map.Entry<Integer, Integer> entry : primeFactorsMapWithMaxFrequencies.entrySet()) {
      result *= Math.pow(entry.getKey(), entry.getValue());
    }

    return result;
  }
}
