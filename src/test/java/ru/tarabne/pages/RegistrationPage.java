package ru.tarabne.pages;

import com.codeborne.selenide.SelenideElement;
import ru.tarabne.pages.components.CalendarComponent;
import ru.tarabne.pages.components.FileUploaderComponent;
import ru.tarabne.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            statesList = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            citiesList = $("#city"),
            submitButton = $("#submit"),
            modalContent = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();
    FileUploaderComponent fileUploaderComponent = new FileUploaderComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(int day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public  RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressTab();

        return this;
    }

    public  RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public  RegistrationPage uploadPicture(String value) {
        fileUploaderComponent.uploadFile(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        statesList.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        citiesList.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String field, String value) {
        resultTableComponent.checkResultsTable(field, value);

        return this;
    }

    public RegistrationPage registrationSuccessCheck() {
        modalContent.shouldBe(visible);

        return this;
    }

    public RegistrationPage registrationFailureCheck() {
        modalContent.shouldBe(hidden);

        return this;
    }

}