package ui_tests.tests;

import apiTest.pages.PageObject;
import org.junit.jupiter.api.BeforeEach;
import ui_tests.test_data.DataHelper;
import org.junit.jupiter.api.Test;
import ui_tests.test_data.MonthAndYear;

import static com.codeborne.selenide.Selenide.open;

public class ValidTests {

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    // Сценарий 4 - Проверяем открытие формы анкеты после нажатия на кнопку "Купить"

    public void openFormAfterClickOnButtonBuy() {
        PageObject page = new PageObject();
        page.openFormAfterClickOnButtonBuy();
    }

    @Test
    // Сценарий 15 - Открываем форму после нажатия на кнопку "Купить в кредит"

    public void openFormAfterClickOnButtonCredit() {
        PageObject page = new PageObject();
        page.openFormAfterClickOnButtonCredit();
    }


    @Test
    //Сценарий 1 - Отправляем валидные данные через сервис платежей

    public void successfulTestWithPaymentGate() {
        PageObject page = new PageObject();
        page.pressTheBuyButton();
        page.fillTheFiledOfCardNumber(DataHelper.validCardNumber());
        MonthAndYear fill = new MonthAndYear();
        fill.validFillTheMonthAndYearFields();
        page.fillTheFieldOfName(DataHelper.getName());
        page.fillTheFieldOfCvv(DataHelper.getCVV());
        page.pressTheEnterButton();
        page.successNotification();
    }

    @Test
    //Сценарий 17 - Отправляем валидные данные через кредитный сервис

    public void successfulTestWithCreditGate() {
        PageObject page = new PageObject();
        page.pressTheCreditButton();
        page.fillTheFiledOfCardNumber(DataHelper.validCardNumber());
        MonthAndYear fill = new MonthAndYear();
        fill.validFillTheMonthAndYearFields();
        page.fillTheFieldOfName(DataHelper.getName());
        page.fillTheFieldOfCvv(DataHelper.getCVV());
        page.pressTheEnterButton();
        page.successNotification();
    }
}

