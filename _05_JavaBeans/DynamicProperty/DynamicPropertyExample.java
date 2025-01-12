package _05_JavaBeans.DynamicProperty;

import _05_JavaBeans.AdvancedExample.Counter;

import java.beans.Expression;
import java.beans.Statement;

public class DynamicPropertyExample {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();

        // dynamiczne ustawianie wartości właściwości count
        Statement stmt = new Statement(counter, "setCount", new Object[]{42});
        stmt.execute();

        // dynamiczne pobranie wartosci wlasciwosci cout
        Expression expr = new Expression(counter, "getCount", new Object[0]);
        int count = (int) expr.getValue();

        System.out.println("Wartość licznika: " + count); // 42
    }
}
