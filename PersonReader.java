package com.company.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonReader {

    public static List<Person> readPersons(String path) {
        List<Person> personList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(path));
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                String[] info;
                while (scanner.hasNextLine()) {
                    info = scanner.nextLine().split("\\|");
                    personList.add(new Person(info));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Incorrect path");
        }
        return personList;
    }

    public static List<Person> filterEco(List<Person> personList, int max) {
        return new ArrayList<>(personList).stream().filter(person -> person.getWaterCount() < max &&
                person.getGasCount1() + person.getGasCount2() < max && person.getElectroCount1() +
                person.getElectroCount2() < max).collect(Collectors.toList());
    }
}
