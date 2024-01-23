package ru.tarabne.tests;

import org.junit.jupiter.api.Test;
import ru.tarabne.pages.RegistrationPage;
import ru.tarabne.testdata.RegistrationTestData;

public class RegistrationPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationTestData registrationTestData = new RegistrationTestData();

    @Test
    void fillFullFormTest() {
        registrationPage.openPage()
                .setFirstName(registrationTestData.firstName)
                .setLastName(registrationTestData.lastName)
                .setEmail(registrationTestData.userEmail)
                .setGender(registrationTestData.userGender)
                .setUserNumber(registrationTestData.phoneNumber)
                .setDateOfBirth(registrationTestData.birthdayDay, registrationTestData.birthdayMonth, registrationTestData.birthdayYear)
                .setSubjects(registrationTestData.subject)
                .setHobbies(registrationTestData.hobby)
                .uploadPicture(registrationTestData.picture)
                .setCurrentAddress(registrationTestData.currentAddress)
                .setState(registrationTestData.state)
                .setCity(registrationTestData.city)
                .submit();

        registrationPage.checkResult("Student Name", registrationTestData.firstName + " " +
                        registrationTestData.lastName)
                .checkResult("Student Email", registrationTestData.userEmail)
                .checkResult("Gender", registrationTestData.userGender)
                .checkResult("Mobile", registrationTestData.phoneNumber)
                .checkResult("Date of Birth", registrationTestData.birthdayDay + " " +
                        registrationTestData.birthdayMonth + "," + registrationTestData.birthdayYear)
                .checkResult("Subjects", registrationTestData.subject)
                .checkResult("Hobbies", registrationTestData.hobby)
                .checkResult("Picture", registrationTestData.picture)
                .checkResult("Address", registrationTestData.currentAddress)
                .checkResult("State and City", registrationTestData.state +
                        " " + registrationTestData.city);
    }

    @Test
    void fillOnlyRequiredFieldsFormTest() {
        registrationPage.openPage()
                .setFirstName(registrationTestData.firstName)
                .setLastName(registrationTestData.lastName)
                .setGender(registrationTestData.userGender)
                .setUserNumber(registrationTestData.phoneNumber)
                .setDateOfBirth(registrationTestData.birthdayDay, registrationTestData.birthdayMonth, registrationTestData.birthdayYear)
                .submit();

        registrationPage.checkResult("Student Name", registrationTestData.firstName + " " +
                        registrationTestData.lastName)
                .checkResult("Student Email", "\t")
                .checkResult("Gender", registrationTestData.userGender)
                .checkResult("Mobile", registrationTestData.phoneNumber)
                .checkResult("Date of Birth", registrationTestData.birthdayDay + " " +
                        registrationTestData.birthdayMonth + "," + registrationTestData.birthdayYear)
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
                .setFirstName(registrationTestData.firstName)
                .setLastName(registrationTestData.lastName)
                .setGender(registrationTestData.userGender)
                .setUserNumber(registrationTestData.invalidPhoneNumber)
                .submit();

        registrationPage.registrationFailureCheck();

    }
}