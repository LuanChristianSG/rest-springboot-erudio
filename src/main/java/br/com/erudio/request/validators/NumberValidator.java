package br.com.erudio.request.validators;

public class NumberValidator {
    public static boolean isNumeric(String strNumber) throws IllegalArgumentException {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
