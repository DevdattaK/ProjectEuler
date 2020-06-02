package test.java.org.example;

import main.java.org.problems.Problem_4_LargestPalindromeProduct;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class Problem_4_LargestPalindromeProduct_Test {

  private Problem_4_LargestPalindromeProduct obj = new Problem_4_LargestPalindromeProduct();
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
        /**
         * integer based calculation wont work e.g. below logic will say 10201 is not a palindrome!
         * int lowestDigit = 0; int heighestDigit = 0; int highestPownerOf10ForDivision =
         * getLengthOfNumber.apply(n.intValue());
         *
         * <p>while (n > 9) { lowestDigit = (int) (n % 10); heighestDigit = (int) (n / Math.pow(10,
         * highestPownerOf10ForDivision));
         *
         * <p>if (lowestDigit != heighestDigit) { return false; } //remove leading and trailing
         * digit and get the remaining number. n = (long) (n - heighestDigit * Math.pow(10,
         * highestPownerOf10ForDivision)); n = n / 10; highestPownerOf10ForDivision =
         * getLengthOfNumber.apply(n.intValue()); }
         */
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

  @Test
  public void whenGivenANumber_thenGetLengthOfIt() {

    assertEquals(2, getLengthOfNumber.apply(101), " Logic failure for 101 - getLengthOfNumber()");

    assertEquals(3, getLengthOfNumber.apply(1000), " Logic failure for 1000 - getLengthOfNumber()");

    assertEquals(0, getLengthOfNumber.apply(1), " Logic failure for 1 - getLengthOfNumber()");

    assertEquals(
        8,
        getLengthOfNumber.apply(123456789),
        " Logic failure for 123456789 - getLengthOfNumber()");
  }

  @Test
  public void whenGivenANumber_thenCheckIfPalindrome() {
    int[] palindromeNumber = {101, 99, 123321, 1};

    for (int number : palindromeNumber) {
      assertTrue(isPalindrome.test((long) 123321), "Failed for " + number);
    }

    int[] nonPalindromeNumber = {101, 99, 123321, 23, 900099};
    for (int number : nonPalindromeNumber) {
      assertFalse(isPalindrome.test((long) number + 1), "Failed for " + number);
    }

  }

  @Test
  public void whenGivenNumberOfDigits_thenGetsTheMaxThatCouldBeFormedByProduct() {
    int numberOfDigits = 2;
    assertEquals(
        9801,
        obj.getLargestPossibleNumberFromProductOfDigits(numberOfDigits),
        " 99 * 99 did not yield expected results.");

    numberOfDigits = 3;
    assertEquals(
        998001,
        obj.getLargestPossibleNumberFromProductOfDigits(numberOfDigits),
        " 999 * 999 did not yield expected results.");
  }

  @Test
  public void whenGivenNumberOfDigits_thenGetLargestPalindromicNumber() {
    int numberOfDigits = 2;
    long expected = 9009;
    long actual = obj.getLargestPalindromicNumber(numberOfDigits);
    assertEquals(
        expected,
        actual,
        String.format(" for %d digits, %d != %d", numberOfDigits, expected, actual));

    expected = 9779;
    assertNotEquals(
        expected,
        actual,
        String.format(" for %d digits, %d == %d", numberOfDigits, expected, actual));

    numberOfDigits = 3;
    expected = 906609;
    actual = obj.getLargestPalindromicNumber(numberOfDigits);
    assertEquals(
        expected,
        actual,
        String.format(" for %d digits, %d != %d", numberOfDigits, expected, actual));
  }

  @Test
  public void whenGivenANumberAndRange_CheckIfNumberIsEqualToProductOfTwoNumbersInRange() {
    int numOfDigits, potentialPalindromeNumber;

    potentialPalindromeNumber = 9779;
    numOfDigits = 2;
    assertFalse(
        obj.isProductOfTwoNumbersWithinAllowedRange(numOfDigits, potentialPalindromeNumber));

    potentialPalindromeNumber = 9009;
    numOfDigits = 2;
    assertTrue(obj.isProductOfTwoNumbersWithinAllowedRange(numOfDigits, potentialPalindromeNumber));
  }
}
