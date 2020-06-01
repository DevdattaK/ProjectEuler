package main.java.org.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23. * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem_1 {
  private final Function<List<Integer>, List<Integer>> listShrinkerToMinimalRequiredElements =
      (l) -> {
        Iterator<Integer> divisorIterator = l.iterator();
        try {
          Integer number = divisorIterator.next();
          Integer number1 = null;

          while (divisorIterator.hasNext()) {
            number1 = divisorIterator.next();

            if (number1 % number == 0) {
              divisorIterator.remove();
            }
            number = number1;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

        return l;
      };

  public long findSumOfMultiplesOfNumbers(List<Integer> numbers, int upperLimit) {
    Set<Long> divisors = new HashSet<>();
    int min = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();

    for(int i = 1; i <= upperLimit/min; i++){
        for(Integer num : numbers){
            if((i * num) < upperLimit){
                divisors.add((long)(i * num));
            }
        }
    }

    return divisors.stream().mapToLong(Long::longValue).sum();
  }
}
