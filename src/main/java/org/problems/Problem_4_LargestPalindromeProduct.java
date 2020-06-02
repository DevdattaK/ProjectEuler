package main.java.org.problems;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99.
 *
 * <p>Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem_4_LargestPalindromeProduct {

  private Function<Integer, Integer> getLengthOfNumber =
      (n) -> {
        int length = 0;

        while (n > 9) {
          n = n / 10;
          length++;
        }

        return length;
      };

    private Predicate<Long> isPalindrome =
            (n) -> {
                StringBuilder sb = new StringBuilder();
                sb.append(n.toString());

                if (sb.length() == 1) {
                    return true;
                } else {
                    char firstChar, lastChar;
                    int startPosition = 0, endPosition = sb.length() - 1;
                    firstChar = sb.charAt(startPosition);
                    lastChar = sb.charAt(endPosition);

                    while (firstChar == lastChar) {
                        sb.deleteCharAt(endPosition);
                        sb.deleteCharAt(startPosition);

                        if (sb.length() > 1) {
                            endPosition = sb.length() - 1;
                            firstChar = sb.charAt(startPosition);
                            lastChar = sb.charAt(endPosition);
                        }else{
                            return true;
                        }
                    }
                }

                return false;
            };

  public long getLargestPossibleNumberFromProductOfDigits(int numberOfDigits) {
    int maxNum = (int) Math.pow(10, numberOfDigits) - 1;

    return maxNum * maxNum;
  }

  public long getLargestPalindromicNumber(int numOfDigits) {

    // find largest possible number (product of 10^(numOfDigits+1)-1)
    long largestPossibleNumber = this.getLargestPossibleNumberFromProductOfDigits(numOfDigits);
    long potentialPalindrome = largestPossibleNumber;
    long smallestPossibleNumber = (long) Math.pow(10, numOfDigits);

    // find palindromic-numbers from this potentialPalindrome in downwards direction
    while (potentialPalindrome >= smallestPossibleNumber) {
      if (isPalindrome.test(potentialPalindrome)) {
        if (this.isProductOfTwoNumbersWithinAllowedRange(
            numOfDigits, potentialPalindrome)) {
          return potentialPalindrome;
        }
      }
      potentialPalindrome -= 1.0;
    }

    return 0L;
  }

  public boolean isProductOfTwoNumbersWithinAllowedRange(
      int numOfDigits, long potentialPalindrome) {
    long maxFactor = (long) Math.pow(10, numOfDigits) - 1;
    long minFactor = (long) Math.pow(10, numOfDigits - 1);

    // when multiplied by 1, maxFactor remains as it is and it is also a palindrome, thus return
    // true.
    if (maxFactor == potentialPalindrome) {
      return true;
    }

    for (long i = minFactor; i <= maxFactor; i++) {
      if (potentialPalindrome % i == 0
          && (potentialPalindrome / i) >= minFactor
          && (potentialPalindrome / i) <= maxFactor) {
        return true;
      }
    }

    return false;
  }
}
