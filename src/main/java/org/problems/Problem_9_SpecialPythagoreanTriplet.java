package main.java.org.problems;

/**
 A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 a^2 + b^2 = c^2
 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 Find the product abc.
 */
public class Problem_9_SpecialPythagoreanTriplet {

  public long getProductOfSpecialPythagoreanTriple(){
    long result = 0l;

    for(int a = 1; a <= 1000; a++){
      for(int b = 1; b <= 1000; b++){
        if((Math.pow(10, 6) - 2*(a+b)*Math.pow(10, 3) + 2*a*b) == 0){
          return a * b * (1000 - a - b);
        }
      }
    }

    return result;
  }

  public long getProductOfSpecialPythagoreanTripleUsingEqualityConstraint(){
    long result = 0l;

    for(int c = 1;c < 1000; c++){
      for(int b = 1;b < c; b++){
        for(int a = 1;a < b; a++){
          if((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) && a + b + c == 1000){
            return a * b * c;
          }
        }
      }
    }

    return result;
  }
}
