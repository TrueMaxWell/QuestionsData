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
        boolean check;
        for (Person person : personList) {
            check = true;
            for (int i = 2; i < person.getPersonFullInfo().length; i++) {
                if (Integer.parseInt(person.getPersonFullInfo()[i]) > max)  {
                    check = false;
                }
            }
            if (check){
                filterEco.add(person);
            }

        }
        return filterEco;
    }
}
