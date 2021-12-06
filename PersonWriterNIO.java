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
    public void writePersons(String path, List<Person> personList) {
        Path in = Paths.get(path);
        Path out = Paths.get(in.getParent().toString() + "\\NIO_" + in.getFileName().toString());

        try {
            for (Person person : personList) {
                Files.write(out, Collections.singleton((person.toString() + "\n")), StandardCharsets.UTF_8);
            }
            System.out.println("File at : " + in.getParent().toString() + "\\NIO_" + in.getFileName().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
