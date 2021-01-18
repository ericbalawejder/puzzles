package com.exercises;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Flattener {

    public static void main(String[] args) {
        List<List<?>> nestedList = asList(
                asList("one"),
                asList(3, 4),
                singletonList(singletonList(2)),
                asList(asList("two", 'd', "5656")),
                asList("three", "three:two", "three:three", "three:four"));

        List<?> list = asList(0,
                '2',
                asList(null, asList(2, "three"),
                        '8',
                        100,
                        "four",
                        singletonList(singletonList(singletonList(50)))), "-2");


        //flattenListOfLists(asList(0, '1', "two"));

        System.out.println(nestedList);
        //System.out.println(flattenListOfListsStream(nestedList));


        List<List<Object>> StringList = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(StringList);

        System.out.println(StringList
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

        System.out.println(list);

        Flattener flattener = new Flattener();
        System.out.println(flattener.flatten(list));
    }

    public static List<?> flattenListOfListsStream(List<List<?>> nestedList) {
        return nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    List<Object> flatten(List<?> nestedList) {
        return flattenToStream(nestedList)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Stream<Object> flattenToStream(List<?> nestedList) {
        return nestedList.stream()
                .flatMap(element -> element instanceof List ?
                        flattenToStream((List<?>) element) : Stream.of(element));
    }

}
