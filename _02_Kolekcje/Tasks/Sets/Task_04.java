package _02_Kolekcje.Tasks.Sets;

import java.util.*;

public class Task_04 {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>(Set.of(
                new Employee(1, "Mateusz", 12500),
                new Employee(2, "Maria", 10500),
                new Employee(3, "Jacek", 17500),
                new Employee(4, "Michał", 4500)
        ));

        set.removeIf(employee -> employee.getSalary() < 5000);

        Set<Employee> treeSet = new TreeSet<>(set);
        // Set<Employee> treeSet = new TreeSet<>(Comparator.comparingDouble(Employee::getSalary).reversed());
        // treeSet.addAll(set);

        System.out.println(treeSet);
    }
}

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(other.salary, this.salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;
        return this.id == employee.id && Double.compare(this.salary, employee.salary) == 0 && Objects.equals(this.name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
