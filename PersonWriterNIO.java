package com.company.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class PersonWriterNIO implements PersonWriter {

    @Override
    public void writePersons(String path, List<Person> personList) {
        Path in = Paths.get(path);
        Path out = Paths.get(in.getParent().toString() + "\\NIO_" + in.getFileName().toString());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id|name|waterCount|gasCount1|gasCount2|electroCount1|electroCount2)\n");

        for (Person person : personList) {
            stringBuilder.append(person.toString() + "\n");
        }

        try {
            Files.write(out, Collections.singleton(stringBuilder));
            System.out.println("File at : " + in.getParent().toString() + "\\NIO_" + in.getFileName().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
