package ru.tarabne.tests;

import org.junit.jupiter.api.Test;
import ru.tarabne.pages.RegistrationPage;

import ru.tarabne.testData.RegistrationTestData;

public class RegistrationPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationTestData registrationTestData = RegistrationTestData.randomUser();

    String firstName = registrationTestData.firstName,
            lastName = registrationTestData.lastName,
            userEmail = registrationTestData.userEmail,
            userGender = registrationTestData.userGender,
            phoneNumber = registrationTestData.phoneNumber,
            birthdayDay = registrationTestData.birthdayDay,
            birthdayMonth = registrationTestData.birthdayMonth,
            birthdayYear = registrationTestData.birthdayYear,
            subject = registrationTestData.subject,
            hobby = registrationTestData.hobby,
            picture = registrationTestData.picture,
            currentAddress = registrationTestData.currentAddress,
            state = registrationTestData.state,
            city = registrationTestData.city,
            invalidPhoneNumber = registrationTestData.invalidPhoneNumber;


    @Test
    void fillFullFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(birthdayDay, birthdayMonth, birthdayYear)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " +
                        lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", birthdayDay + " " +
                        birthdayMonth + "," + birthdayYear)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void fillOnlyRequiredFieldsFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(birthdayDay, birthdayMonth, birthdayYear)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " +
                        lastName)
                .checkResult("Student Email", "\t")
                .checkResult("Gender", userGender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", birthdayDay + " " +
                        birthdayMonth + "," + birthdayYear)
                .checkResult("Subjects", "\t")
                .checkResult("Hobbies", "\t")
                .checkResult("Picture", "\t")
                .checkResult("Address", "\t")
                .checkResult("State and City", "\t")
                .registrationSuccessCheck();
    }

    @Test
    void allFieldsAreEmptyTest() {
        registrationPage.openPage()
                .submit();

        registrationPage.registrationFailureCheck();

    }

    @Test
    void phone9DigitsTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(invalidPhoneNumber)
                .submit();

        registrationPage.registrationFailureCheck();

    }
}
