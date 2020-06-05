package main.java.org.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum of all the primes below two
 * million.
 */
public class Problem_10_SumOfPrimes {

  private boolean isPrime(int number) {
    return IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(i -> number % i == 0);
  }

  private boolean isPrimeUsingPrimesSoFar(int number, List<Integer> primesSoFar) {
    return primesSoFar.stream().filter(p -> p <= Math.sqrt(number)).noneMatch(p -> number % p == 0);
  }

  public List<Integer> getPrimesInRange(int start, int end) {
    List<Integer> primesSoFar = new ArrayList<>();

    if (start < 2) return null;

    // get primes between 2 and start (inclusive)
    if (start > 2) {
      primesSoFar = this.getPrimesInRange(2, start);
    }

    for (int i = start; i <= end; i++) {
      if (primesSoFar.isEmpty()) {
        if (isPrime(i)) {
          primesSoFar.add(i);
          continue;
        }
      }
      if (this.isPrimeUsingPrimesSoFar(i, primesSoFar)) {
        primesSoFar.add(i);
      }
    }

    return primesSoFar.stream().filter(i -> i >= start).collect(Collectors.toList());
  }

  public long getSumOfPrimesInRange(int start, int end) {
    List<Integer> primesInRange = this.getPrimesInRange(start, end);
    return primesInRange.parallelStream().mapToLong(Integer::longValue).sum();
  }

  public long getSumOfPrimesInRangeUsingEratostheneseMethod(int start, int end) {
    boolean[] unmarkedPrimes = new boolean[end+1];
    int j = 1;
    int indexOfCurPrimeMultiple = -1;
    long result = 0l;

    //set all positions to true.
    for(int i = 2; i <= end; i++){
      unmarkedPrimes[i] = true;
    }

    //apply core logic quoted in algorithm
    for(int i = 2; i <= Math.sqrt(end); i++){
      if(unmarkedPrimes[i] && (i*i) <= end){
        unmarkedPrimes[i*i] = false;
        j = 1;
        indexOfCurPrimeMultiple = i*(i+j);
        while (indexOfCurPrimeMultiple <= end){
          unmarkedPrimes[indexOfCurPrimeMultiple] = false;
          j++;
          indexOfCurPrimeMultiple = i*(i+j);
        }
      }
    }

    for(int i = start; i <= end; i++){
      if(unmarkedPrimes[i]){
        result += i;
      }
    }

    return result;
  }
}
