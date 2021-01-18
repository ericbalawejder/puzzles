package com.packt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ImperativeAndFunctionalExamples {
    public static void main(String...args) {

        List<Employee> emptyList = new ArrayList<>();

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Welvin", 20),
                new Employee("Jack", 200000),
                new Employee("Chad", 100000),
                new Employee("Adam", 300000),
                new Employee("Adam", 500000),
                new Employee("Joe", 400000),
                new Employee("Lindsay", 400000),
                new Employee("Sarah", 1000000),
                new Employee("Timmy", 400000)
        ));

        System.out.println(getAllNames(employees));
        System.out.println(getAllNamesFunctionalLambda(employees));
        System.out.println(getAllNamesFunctionalMethodReference(employees));
        System.out.println(getAllNamesFunctional(employees));

        System.out.println(groupBySalary(employees));
        System.out.println(groupBySalaryBrackets(employees));

        System.out.println(averageSalary(employees));
        System.out.println(averageSalary(emptyList));

        System.out.println(salaryBudget(employees));
    }

    static String getAllNames(List<Employee> employees) {
        StringBuilder names = new StringBuilder();
        for (Employee employee : employees) {
            names.append(employee.getName());
        }
        return names.toString();
    }

    static String getAllNamesFunctionalLambda(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(() -> new StringBuilder(),
                        (StringBuilder builder, String s) -> builder.append(s),
                        (StringBuilder builder1, StringBuilder builder2) -> builder1.append(builder2))
                .toString();
    }

    static String getAllNamesFunctionalMethodReference(List<Employee> employees) {
        return employees.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    static String getAllNamesFunctional(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());
    }

    static Map<Integer, List<Employee>> groupBySalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
    }

    static Map<Integer, List<Employee>> groupBySalaryBrackets(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getSalary() / 1000));
    }

    static OptionalDouble averageSalary(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .average();
    }

    static int salaryBudget(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

}
