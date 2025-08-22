package br.com.erudio.math;

import br.com.erudio.exception.UnsupportedMathOperationException;

public class SimpleMath {
    public static Double sum(
            Double numberOne,
            Double numberTwo
    ){
        return numberOne + numberTwo;
    }

    public static Double subtraction(
            Double numberOne,
            Double numberTwo
    ) {
        return numberOne - numberTwo;
    }

    public static Double division(
            Double numberOne,
            Double numberTwo
    ) {
        return numberOne / numberTwo;
    }

    public static Double mean(
            Double numberOne,
            Double numberTwo
    ) {
        return (numberOne + numberTwo) / 2;
    }

    public static Double squareroot(
            Double number
    ) {
        return java.lang.Math.sqrt(number);
    }
}
