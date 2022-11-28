package org.example;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Task3_64 {


    public static void main(String[] args) {
        System.out.println("sumOperator : " + sumOperator.applyAsInt(1,5));
        System.out.println("prodOperator : " + productOperator.applyAsInt(1, 5));
    }


    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator = new BiFunction<Integer, IntBinaryOperator, IntBinaryOperator>() {
        @Override
        public IntBinaryOperator apply(Integer integer, IntBinaryOperator intBinaryOperator) {
            return new IntBinaryOperator() {
                @Override
                public int applyAsInt(int left, int right) {
                    return IntStream.rangeClosed(left, right).reduce(integer, intBinaryOperator);
                }
            };
        }
    };

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = new IntBinaryOperator() {
        @Override
        public int applyAsInt(int left, int right) {
//            return IntStream.rangeClosed(left, right).reduce((x, y) -> x + y).orElse(0);
            IntBinaryOperator sum = (x, y) -> x + y;
            return reduceIntOperator.apply(0, sum).applyAsInt(left, right);
        }
    };
    // write your code here

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = new IntBinaryOperator() {
        @Override
        public int applyAsInt(int left, int right) {
//            return IntStream.rangeClosed(left, right).reduce((x, y) -> x * y).orElse(0);
            IntBinaryOperator prod = (x, y) -> x * y;
            return reduceIntOperator.apply(1, prod).applyAsInt(left, right);
        }
    };
    // write your code here

}
