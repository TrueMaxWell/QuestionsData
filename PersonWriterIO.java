package com.company.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PersonWriterIO implements PersonWriter {

    @Override
    public void writePersons(String path) {
        List<Person> personList = PersonReader.readPersons(path);
        String result = PersonReader.allPersonInfoToString(personList);
        try {
            FileOutputStream out = new FileOutputStream(path.substring(0, path.lastIndexOf(".")) +
                    "_IO" + path.substring(path.lastIndexOf(".")));
            out.write(result.getBytes(StandardCharsets.UTF_8));
            System.out.println("File at : " + path.substring(0, path.lastIndexOf(".")) + "_IO" +
                    path.substring(path.lastIndexOf(".")) + "\nContains :\n" + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeEcoPersons(String path, int max) {
        List<Person> personList = PersonReader.filterEco(PersonReader.readPersons(path), max);
        String result = PersonReader.allPersonInfoToString(personList);
        try {
            FileOutputStream out = new FileOutputStream(path.substring(0, path.lastIndexOf(".")) +
                    "_IO_Eco" + path.substring(path.lastIndexOf(".")));
            out.write(result.getBytes(StandardCharsets.UTF_8));
            System.out.println("File at : " + path.substring(0, path.lastIndexOf(".")) + "_IO_Eco" +
                    path.substring(path.lastIndexOf(".")) + "\nContains :\n" + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}