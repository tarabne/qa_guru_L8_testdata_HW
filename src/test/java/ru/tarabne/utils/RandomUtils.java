package ru.tarabne.utils;

import com.github.javafaker.Faker;

import java.io.File;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker();
    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        String sb = new String();

        for (int i = 0; i < len; i++)
            sb += AB.charAt(rnd.nextInt(AB.length()));

        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(5) + "@" + getRandomString(5) + ".com";
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {

        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi","Gurgaon","Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra","Lucknow","Merrut");
            case "Haryana":
                return faker.options().option("Karnal","Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur","Jaiselmer");
        }
        return state;
    }

}
