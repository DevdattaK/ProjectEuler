package main.java.org.problems;

import java.util.stream.LongStream;

/**
 * The sum of the squares of the first ten natural numbers is,
 * <p>1^2+2^2+...+10^2=385 The square of the sum of the first ten natural numbers is,
 * <p>(1+2+...+10)^2=552=3025 Hence the difference between the sum of the squares of the first ten
 * natural numbers and the square of the sum is 3025−385=2640.
 * <p>Find the difference between the sum of the squares of the first one hundred natural numbers
 * and the square of the sum.
 */
public class Problem_6_SumSquareDifference {

  public long getSumOfSquaresForRange(int start, int end){

    return LongStream.rangeClosed(start, end).map(i -> (long) Math.pow(i, 2)).sum();

  }

  public long getSquareOfSumForRange(int start, int end){
    long val = LongStream.rangeClosed(start, end).sum();

    return val * val;
  }
}
