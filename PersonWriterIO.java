package com.company.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PersonWriterIO implements PersonWriter {

    @Override
    public void writePersons(String path, List<Person> personList) {
        try {
            FileOutputStream out = new FileOutputStream(path.substring(0, path.lastIndexOf(".")) +
                    "_IO" + path.substring(path.lastIndexOf(".")));
            for (Person person : personList) {
                out.write((person.toString() + "\n").getBytes(StandardCharsets.UTF_8));
            }
            System.out.println("File at : " + path.substring(0, path.lastIndexOf(".")) + "_IO" +
                    path.substring(path.lastIndexOf(".")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
