package ui_tests.tests;

import apiTest.pages.PageObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui_tests.test_data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EmptyTest {

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    //Сценарий 7 - Отправляем форму с пустыми полями

    public void testWithEmptyFields() {
        PageObject page = new PageObject();
        page.fillWithEmptyFields();
    }

    @Test
    //Сценарий 8 - Отправляем форму с незаполненным полем "Номер карты"

    public void fillWithEmptyFieldOfCardNumber() {
        PageObject page = new PageObject();
        page.pressTheBuyButton();
        page.fillTheFieldOfMonth(DataHelper.getMonth());
        page.fillTheFieldOfYear(DataHelper.getYear());
        page.fillTheFieldOfName(DataHelper.getName());
        page.fillTheFieldOfCvv(DataHelper.getCVV());
        page.pressTheEnterButton();
        page.invalidFormat();
    }

    @Test
    //Сценарий 2 - Отправляем форму с данными в неверном формате в поле "Месяц"

    public void testWithEmptyFieldOfMonth() {
        PageObject page = new PageObject();
        page.pressTheBuyButton();
        page.fillTheFiledOfCardNumber(DataHelper.randomCardNumber());
        page.fillTheFieldOfYear(DataHelper.getYear());
        page.fillTheFieldOfName(DataHelper.getName());
        page.fillTheFieldOfCvv(DataHelper.getCVV());
        page.pressTheEnterButton();
        page.invalidFormat();
    }

    @Test
    //Сценарий 18 - Отправляем форму с незаполненным полем "Год"

    public void testWithEmptyFieldOfYear() {
        PageObject page = new PageObject();
        page.pressTheBuyButton();
        page.fillTheFiledOfCardNumber(DataHelper.randomCardNumber());
        page.fillTheFieldOfMonth(DataHelper.getMonth());
        page.fillTheFieldOfName(DataHelper.getName());
        page.fillTheFieldOfCvv(DataHelper.getCVV());
        page.pressTheEnterButton();
        page.invalidFormat();
    }

    @Test
    //Сценарий 13 - Отправляем форму с незаполненным полем "Владелец"

    public void testWithEmptyFieldOfOwner() {
        PageObject page = new PageObject();
        page.pressTheBuyButton();
        page.fillTheFiledOfCardNumber(DataHelper.randomCardNumber());
        page.fillTheFieldOfMonth(DataHelper.getMonth());
        page.fillTheFieldOfYear(DataHelper.getYear());
        page.fillTheFieldOfCvv(DataHelper.getCVV());
        page.pressTheEnterButton();
        page.essentialField();

    }

    @Test
    //Сценарий 19 - Отправляем форму с незаполненным полем "CVC/CVV"

    public void testWithEmptyFieldOfCvv() {
        PageObject page = new PageObject();
        page.pressTheBuyButton();
        page.fillTheFiledOfCardNumber(DataHelper.randomCardNumber());
        page.fillTheFieldOfMonth(DataHelper.getMonth());
        page.fillTheFieldOfYear(DataHelper.getYear());
        page.fillTheFieldOfName(DataHelper.getName());
        page.pressTheEnterButton();
        page.invalidFormat();
    }

}