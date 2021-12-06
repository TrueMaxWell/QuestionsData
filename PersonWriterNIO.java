package com.company.Data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class PersonWriterNIO implements PersonWriter{

    @Override
    public void writePersons(String path) {
        List<Person> personList = PersonReader.readPersons(path);
        String result = PersonReader.allPersonInfoToString(personList);
        Path in = Paths.get(path);
        Path out = Paths.get(in.getParent().toString() + "\\NIO_" + in.getFileName().toString());

        try {
            Files.write(out, Collections.singleton(result), StandardCharsets.UTF_8);
            System.out.println("File at : " + in.getParent().toString() + "\\NIO_" + in.getFileName().toString() +
                    "\nContains :\n" + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeEcoPersons(String path, int max) {
        List<Person> personList = PersonReader.filterEco(PersonReader.readPersons(path), max);
        String result = PersonReader.allPersonInfoToString(personList);
        Path in = Paths.get(path);
        Path out = Paths.get(in.getParent().toString() + "\\NIO_Eco_" + in.getFileName().toString());

        try {
            Files.write(out, Collections.singleton(result), StandardCharsets.UTF_8);
            System.out.println("File at : " + in.getParent().toString() + "\\NIO_Eco_" + in.getFileName().toString() +
                    "\nContains :\n" + result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
