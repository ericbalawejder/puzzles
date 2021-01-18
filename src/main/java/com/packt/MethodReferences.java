package com.packt;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {

    interface ThreadSupplier {
        Thread giveMeAThread();
    }

    public static void main(String...args) {

        // Static method
        Supplier<Thread> s1 = Thread::currentThread;

        // Nothing special about supplier
        ThreadSupplier ts = Thread::currentThread;

        // Instance method (instance specified)
        Employee frank = new Employee("Frank", 100000);

        Integer frankSalary = frank.getSalary();
        Supplier<Integer> s2 = frank::getSalary;

        System.out.println(s2.get());

        // A Common instance method (instance specified)
        Consumer<String> c1 = System.out::println;

        // Instance method (instance not specified)
        Function<Employee, Integer> f1 = Employee::getSalary;
        Integer salary = f1.apply(frank);

        main2();
    }

    public static <T> void printAll(T[] array, Function<T, String> toStringFunction) {
        int i = 0;
        for (T t: array) {
            System.out.println(i++ + ":\t" + toStringFunction.apply(t));
        }
    }

    public static void main2() {
        Employee department[] = new Employee[5];
        department[0] = new Employee("Alex", 500000);
        department[1] = new Employee("Bob", 5000000);
        department[2] = new Employee("Joe", 300000);
        department[3] = new Employee("Welvin", 200000);
        department[4] = new Employee("Chad", 50000);
        printAll(department, Employee::getName);

        System.out.println();

        // Cannot infer type from printAll()....Function<T, String>  <- Integer
        //printAll(department, Employee::getSalary);
        printAll(department, employee -> "" + employee.getSalary());
    }
}
