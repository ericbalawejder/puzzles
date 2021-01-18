package com.packt;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda1 {

    @SuppressWarnings("unused")
    public static void main(String...args) {

        Comparator<Employee> byName = new Comparator<Employee>() {
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        // Our first lambda expression
        Comparator<Employee> byNameLambda1 =
                (Employee a, Employee b) -> { return a.getName().compareTo(b.getName()); };

        // Using type inference
        Comparator<Employee> byNameLambda2 =
                (a, b) -> { return a.getName().compareTo(b.getName()); };

        // Removing braces and return
        Comparator<Employee> byNameLambda3 =
                (a, b) -> a.getName().compareTo(b.getName());

        // Using method reference
        Comparator<Employee> byNameLambda4 = Comparator.comparing(Employee::getName);


        // Expression with no parameters
        Runnable r = () -> { System.out.println("A Compact Runnable"); };
        Thread t1 = new Thread(r);

        // No need to even mention Runnable
        Thread t2 = new Thread( () -> { System.out.println("An Implicit Runnable"); } );

        // No need for braces here
        Thread t3 = new Thread( () -> System.out.println("An Implicit Runnable") );

        // Expression with one parameter
        Consumer<String> lengthPrinter = s -> System.out.println(s.length());
    }
}
