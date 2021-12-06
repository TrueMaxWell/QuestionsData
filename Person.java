package com.company.Data;

public class Person {
    private final String[] personFullInfo;

    public Person(String[] personFullInfo) {
        this.personFullInfo = personFullInfo;
    }

    public String[] getPersonFullInfo() {
        return personFullInfo;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : personFullInfo) {
            stringBuilder.append(key).append("|");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }
}
