package com.company.Data;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\xaxax\\IdeaProjects\\Questions\\src\\com\\company\\Data\\data.csv";
        PersonWriterNIO writerNIO = new PersonWriterNIO();
        writerNIO.writeEcoPersons(path,500);
        writerNIO.writePersons(path);
        PersonWriterIO writerIO = new PersonWriterIO();
        writerIO.writePersons(path);
        writerIO.writeEcoPersons(path,500);





    }



}
