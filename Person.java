package com.company.Data;

public class Person {
    private final static String keys = "id|name|waterCount|gasCount1|gasCount2|electroCount1|electroCount2";
    private final String[] personFullInfo;

    public Person(String[] personFullInfo) {
        this.personFullInfo = personFullInfo;
    }

    public String[] getPersonFullInfo() {
        return personFullInfo;
    }

    public static String getKeys() {
        return keys;
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
