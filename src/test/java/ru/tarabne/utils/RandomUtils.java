package ru.tarabne.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    static Faker faker = new Faker();

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