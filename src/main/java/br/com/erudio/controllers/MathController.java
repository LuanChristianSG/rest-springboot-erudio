package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;
import br.com.erudio.request.validators.NumberValidator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {
    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberValidator.isNumeric(numberOne) || !NumberValidator.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        return SimpleMath.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }



    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberValidator.isNumeric(numberOne) || !NumberValidator.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        return SimpleMath.subtraction(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }


    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberValidator.isNumeric(numberOne) || !NumberValidator.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        if(NumberConverter.convertToDouble(numberTwo) == 0)
            throw new UnsupportedMathOperationException("Cannot divide by zero.");
        return SimpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberValidator.isNumeric(numberOne) || !NumberValidator.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        return SimpleMath.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareroot(
            @PathVariable("number") String number
    ) throws Exception {
        if(!NumberValidator.isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        return SimpleMath.squareroot(NumberConverter.convertToDouble(number));
    }
}
