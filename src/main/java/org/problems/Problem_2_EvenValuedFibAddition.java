package main.java.org.problems;

import java.util.function.BiFunction;

public class Problem_2_EvenValuedFibAddition {

    public long getAdditionOfEvenValuedFibUptoSpecifiedLimit(long limit){
        long result = 0;
        BiFunction<Long, Long, Long> fibGenerator = (a, b) -> a + b;
        long first = 1, second = 1, temp = 0;

        while((temp = fibGenerator.apply(first, second)) <= limit){
            first = second;
            second = temp;

            if(temp % 2 == 0)
                result += temp;
        }

        return result;
    }
}
