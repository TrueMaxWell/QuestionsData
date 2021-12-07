package com.company.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PersonWriterIO implements PersonWriter {

    @Override
    public void writePersons(String path, List<Person> personList) {
        try {
            FileOutputStream out = new FileOutputStream(path.substring(0, path.lastIndexOf(".")) +
                    "_IO" + path.substring(path.lastIndexOf(".")));
            out.write("id|name|waterCount|gasCount1|gasCount2|electroCount1|electroCount2)\n".getBytes());
            for (Person person : personList) {
                out.write((person.toString() + "\n").getBytes());
            }
            System.out.println("File at : " + path.substring(0, path.lastIndexOf(".")) + "_IO" +
                    path.substring(path.lastIndexOf(".")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
