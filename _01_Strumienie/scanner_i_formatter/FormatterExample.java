package _01_Strumienie.scanner_i_formatter;

import java.util.Formatter;

public class FormatterExample {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("Name: %s, Age: %d, Salary: %.2f", "John Doe", 30, 4500.50);
        System.out.println(formatter);
        formatter.close();
    }
}