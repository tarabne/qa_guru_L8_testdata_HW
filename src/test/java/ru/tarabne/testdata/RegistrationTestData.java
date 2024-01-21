package ru.tarabne.testdata;

import com.github.javafaker.Faker;
import ru.tarabne.utils.RandomUtils;

public class RegistrationTestData {
    public String firstName,
            lastName,
            userEmail,
            userGender,
            phoneNumber,
            birthdayMonth,
            birthdayYear,
            subject,
            hobby,
            currentAddress,
            state,
            city,
            picture,
            invalidPhoneNumber;
    public int birthdayDay;

    String[] months = {"January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    String[] subjects = {"Maths", "Chemistry", "Computer Science",
            "Accounting", "Arts", "Social Studies", "History"};
    String[] hobbies = {"Sports", "Reading", "Music"};
    String[] pictures = {"1.jpeg", "2.jpeg", "3.jpeg"};
    String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    String[] genders = {"Male", "Female", "Other"};


    public static RegistrationTestData randomUser() {
        Faker faker = new Faker();
        RegistrationTestData registrationTestData = new RegistrationTestData();

        registrationTestData.firstName = faker.name().firstName();
        registrationTestData.lastName = faker.name().lastName();
        registrationTestData.userEmail = faker.internet().emailAddress();
        registrationTestData.userGender = faker.options().option(registrationTestData.genders);
        registrationTestData.phoneNumber = faker.phoneNumber().subscriberNumber(10);
        registrationTestData.invalidPhoneNumber = faker.number().digits(9);
        registrationTestData.birthdayDay = faker.number().numberBetween(1, 28);
        registrationTestData.birthdayMonth = faker.options().option(registrationTestData.months);
        registrationTestData.birthdayYear = String.valueOf(faker.number().numberBetween(1900, 2100));
        registrationTestData.subject = faker.options().option(registrationTestData.subjects);
        registrationTestData.hobby = faker.options().option(registrationTestData.hobbies);
        registrationTestData.picture = faker.options().option(registrationTestData.pictures);
        registrationTestData.currentAddress = faker.address().fullAddress();
        registrationTestData.state = faker.options().option(registrationTestData.states);
        registrationTestData.city = RandomUtils.getRandomCity(registrationTestData.state);

        return registrationTestData;
    }

}