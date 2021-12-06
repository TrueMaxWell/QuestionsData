package com.company.Data;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\xaxax\\IdeaProjects\\Questions\\src\\com\\company\\Data\\data.csv";
        List<Person> personList = PersonReader.readPersons(path);
        List<Person> ecoPersonList = PersonReader.filterEco(personList, 500);

        PersonWriterNIO writerNIO = new PersonWriterNIO();
        writerNIO.writePersons(path,personList);
        writerNIO.writePersons(path, ecoPersonList);

        PersonWriterIO writerIO = new PersonWriterIO();
        writerIO.writePersons(path,personList);
        writerIO.writePersons(path, ecoPersonList);






    }



}
