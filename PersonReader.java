package com.company.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        List<Person> filterEco = new ArrayList<>();

        for (Person person : personList) {

            if (person.getWaterCount() < 500 && person.getGasCount1() + person.getGasCount2() < 500 &&
                    person.getElectroCount1() + person.getElectroCount2() < 500) {
                filterEco.add(person);
            }

        }
        return filterEco;
    }
}
