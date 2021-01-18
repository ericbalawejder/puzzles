package com.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanTest {

    @Test
    void preLambdaSort() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Sarah", 10));

        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });

        assertEquals("Jack", humans.get(0).getName());
    }

    @Test
    void lambdaSort() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Sarah", 10));

        humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));

        assertEquals("Jack", humans.get(0).getName());
    }

    @Test
    void lambdaSortWithTypeInference() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Sarah", 10));

        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));

        assertEquals("Jack", humans.get(0).getName());
    }

    @Test
    void lambdaSortWithReferenceToStaticMethod() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Sarah", 10));

        humans.sort(Human::compareByNameThenByAge);

        assertEquals("Jack", humans.get(0).getName());
    }

    @Test
    void lambdaSortWithReferenceToInstanceMethod() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Zach", 12));
        humans.add(new Human("Sarah", 10));

        Collections.sort(humans, Comparator.comparing(Human::getName));

        assertEquals("Jack", humans.get(0).getName());
    }

    @Test
    void lambdaSortReversed() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Jack", 12));
        humans.add(new Human("Sarah", 10));

        Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());

        assertEquals("Sarah", humans.get(0).getName());
    }

    @Test
    void lambdaSortCompareByNameThenAge() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 12));
        humans.add(new Human("Sarah", 10));
        humans.add(new Human("Zach", 12));

        humans.sort((lhs, rhs) -> {
            if (lhs.getName().equals(rhs.getName())) {
                return lhs.getAge() - rhs.getAge();
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        });

        assertEquals("Sarah", humans.get(0).getName());
    }

    @Test
    void lambdaSortCompareByNameThenAgeWithChaining() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 12));
        humans.add(new Human("Sarah", 10));
        humans.add(new Human("Zach", 12));

        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));

        assertEquals("Sarah", humans.get(0).getName());
    }

}
