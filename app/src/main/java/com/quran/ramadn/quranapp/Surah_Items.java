package com.quran.ramadn.quranapp;

public class Surah_Items {
    private int number, numberOfAyahs;
    private String name, revelationType;

    public Surah_Items() {
    }

    public Surah_Items(int number, String name, int numberOfAyahs, String revelationType) {

        this.number = number;
        this.name = name;
        this.numberOfAyahs = numberOfAyahs;
        this.revelationType = revelationType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfAyahs() {
        return numberOfAyahs;
    }

    public void setNumberOfAyahs(int numberOfAyahs) {
        this.numberOfAyahs = numberOfAyahs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRevelationType() {
        return revelationType;
    }

    public void setRevelationType(String revelationType) {
        this.revelationType = revelationType;
    }
}