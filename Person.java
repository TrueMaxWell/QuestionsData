package com.company.Data;

public class Person {
    private final String[] personFullInfo;
    private final int id;
    private final String name;
    private final int waterCount;
    private final int gasCount1;
    private final int gasCount2;
    private final int electroCount1;
    private final int electroCount2;



    public Person(String[] personFullInfo) {
        this.personFullInfo = personFullInfo;
        this.id = Integer.parseInt(personFullInfo[0]);
        this.name = personFullInfo[1];
        this.waterCount = Integer.parseInt(personFullInfo[2]);
        this.gasCount1 = Integer.parseInt(personFullInfo[3]);
        this.gasCount2 = Integer.parseInt(personFullInfo[4]);
        this.electroCount1 = Integer.parseInt(personFullInfo[5]);
        this.electroCount2 = Integer.parseInt(personFullInfo[6]);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : personFullInfo) {
            stringBuilder.append(key).append("|");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    public String[] getPersonFullInfo() {
        return personFullInfo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public int getGasCount1() {
        return gasCount1;
    }

    public int getGasCount2() {
        return gasCount2;
    }

    public int getElectroCount1() {
        return electroCount1;
    }

    public int getElectroCount2() {
        return electroCount2;
    }
}
