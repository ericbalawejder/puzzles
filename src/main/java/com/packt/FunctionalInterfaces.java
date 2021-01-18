package com.packt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfaces {

    public static void main(String...args) throws FileNotFoundException {
        //System.out.println(composeHashcodes3("Hello", "World"));
        //System.out.println(composeHashcodes3("Hello", null));

        PrintWriter writer = new PrintWriter("butts.txt");
        Consumer<String> logger = writer::println;
        Consumer<String> screener = System.out::println;
        Consumer<String> both = screener.andThen(logger);
        both.accept("Program started");

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Welvin", 20),
                new Employee("Jack", 200000),
                new Employee("Chad", 100000),
                new Employee("Adam", 300000),
                new Employee("Adam", 500000),
                new Employee("Joe", 400000)
        ));

        Function<Employee, String> getName = Employee::getName;
        Function<String, Character> getFirstLetter = name -> name.charAt(0);
        Function<Employee, Character> initial = getName.andThen(getFirstLetter);

        //Comparator<Employee> byName = Comparator.comparing(Employee::getName);
        //Comparator<Employee> bySalary = Comparator.comparingInt(Employee::getSalary);
        //Comparator<Employee> byNameAndSalary = byName.thenComparing(bySalary);
        Comparator<Employee> byNameAndSalary =
                Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary);

        employees.stream()
                .filter(employee -> employee.getSalary() > 100)
                .sorted(byNameAndSalary)
                .forEach(System.out::println);
    }

    public static int composeHashcodes(Object a, Object b) {
        return a.hashCode() ^ b.hashCode();
    }

    public static String getApplicationStatus() {
        System.out.println("getApplicationStatus method");
        return "It's " + LocalTime.now();
    }

    // Using this method calls getApplicationStatus() four times.
    public static int composeHashcodes2(Object a, Object b) {
        Objects.requireNonNull(a, "a may not be null!" + getApplicationStatus());
        Objects.requireNonNull(b, "b may not be null!" + getApplicationStatus());
        return a.hashCode() ^ b.hashCode();
    }

    // Using a Supplier only builds the String when it is necessary saving on overhead.
    public static int composeHashcodes3(Object a, Object b) {
        Objects.requireNonNull(a, () -> "a may not be null!" + getApplicationStatus());
        Objects.requireNonNull(b, () -> "b may not be null!" + getApplicationStatus());
        return a.hashCode() ^ b.hashCode();
    }

}

