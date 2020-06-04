package test.java.org.example;

import main.java.org.problems.Problem_9_SpecialPythagoreanTriplet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem_9_SpecialPythagoreanTripleTest {

  private Problem_9_SpecialPythagoreanTriplet obj = new Problem_9_SpecialPythagoreanTriplet();

  @Test
  public void pythagoreanTripleProductTest(){
    assertEquals(31875000, obj.getProductOfSpecialPythagoreanTriple());

    assertEquals(31875000, obj.getProductOfSpecialPythagoreanTripleUsingEqualityConstraint());
  }
}
