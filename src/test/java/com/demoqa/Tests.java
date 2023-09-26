package com.demoqa;

import com.demoqa.Alerts_Frame_and_Windows.Alerts_Frame_and_Windows;
import com.demoqa.array.Full_Name_Random_Array;
import com.demoqa.buttons.Buttons_Page;
import com.demoqa.textbox.Elements;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BasePage {


    @Epic("Заполнение формы и проверка заполненых данных")
    @Test(priority = 0)
    public void openWebSite() {
        openWebSiteStep();
        accessFormElements();
        fillAndSubmitForm();
    }

    @Step("Открытие веб-сайта")
    public void openWebSiteStep() {
        WebPageAddress webPageAddress = new WebPageAddress();
        webPageAddress.openWebSite();
    }

    @Step("Доступ к элементам формы")
    public void accessFormElements() {
        Elements elements = new Elements();
        elements.clickElementsCard();
        elements.clickTextBox();
    }

    @Feature("Заполнение формы")
    @Step("Заполнение и отправка формы")
    public void fillAndSubmitForm() {
        Elements elements = new Elements();
        String randomFullName = createRandomFullName();
        elements.findFieldFullNameTextBox(randomFullName);
        elements.findFieldEmail();
        elements.findFieldCurrentAddress();
        elements.findFieldPermanentAddress();
        elements.clickbuttomSubmit();
        verifyFormDetails(randomFullName);
    }

    @Step("Создание случайного полного имени")
    public String createRandomFullName() {
        Full_Name_Random_Array fullNameRandomArray = new Full_Name_Random_Array();
        return fullNameRandomArray.arrayFullName();
    }

    @Feature("Проверка заполненых данных")
    @Step("Проверка деталей формы")
    public void verifyFormDetails(String randomFullName) {
        Elements elements = new Elements();
        String expectedFullName = String.join(" ", randomFullName);
        Assert.assertEquals(expectedFullName, elements.getAssertsName());
        Assert.assertEquals(elements.findFieldEmail(), elements.getAssertsEmail());
        Assert.assertEquals(elements.findFieldCurrentAddress(), elements.getAssertsCurrentAddress());
        Assert.assertEquals(elements.findFieldPermanentAddress(), elements.getAssertsPermanentAddress());
    }

    @Feature("Тесты кликабельности Buttons")
    @Story("Проверка обычного клика")
    @Test(priority = 1, description = "Тест на проверку клика по кнопкам и появления уведомлений")
    @Description("Проверяет клик по кнопкам и появление уведомлений")
    public void clickMeClick() {
        Buttons_Page buttonsPage = new Buttons_Page();
        buttonsPage.clickButtons();
        buttonsPage.clickMeClick();
        Assert.assertEquals("You have done a dynamic click", buttonsPage.expectedResultClick());
    }

    @Story("Проверка правого клика")
    @Test(priority = 2, description = "Тест на проверку правого клика")
    @Description("Проверяет правый клик по кнопке")
    public void clickRightClick() {
        Buttons_Page buttonsPage = new Buttons_Page();
        buttonsPage.clickRightClickMe();
        Assert.assertEquals("You have done a right click", buttonsPage.expectedResultRightClick());
    }

    @Story("Проверка двойного клика")
    @Test(priority = 3, description = "Тест на проверку двойного клика")
    @Description("Проверяет двойной клик по кнопке")
    public void clickDoubleClick() {
        Buttons_Page buttonsPage = new Buttons_Page();
        buttonsPage.clickDoubleClickMe();
        Assert.assertEquals("You have done a double click", buttonsPage.expectedResultDoubleClick());
    }


    @Epic("Проверка на открытие окон, вкладок")
    @Test(priority = 4, description = "Проверка на открытие окон, вкладок")
    public void alertsFrameWindows() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.clickAlertsFrameAccordion();
    }

    @Feature("Проверка окон браузера")
    @Story("Проверка открытия новой вкладки")
    @Description("Открытие новой вкладки")
    @Test(priority = 5, description = "Открытие новой вкладки")
    public void clickNewTab() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.clickBrowserWindowsAlertsFrame();
        alertsFrameAndWindows.clickNewTab();
    }

    @Story("Проверка открытия нового окна")
    @Description("Открытие нового окна")
    @Test(priority = 6, description = "Открытие нового окна")
    public void clickNewWindows() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.clickNewWindow();
    }

    @Feature("Проверка уведомлений, оповещений, предупреждений")
    @Description("Проверка функционала кнопки Alerts")
    @Test(priority = 7, description = "Проверка функционала кнопки Alerts")
    public void clickButtonAlerts() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.clickButtonAlerts();
    }

    @Story("Проверка окна оповещения")
    @Test(priority = 8, description = "Проверка всплывающего окона оповещения")
    @Description("Проверка всплывающего окона оповещения")
    public void clickButtonSeeAlert() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.setButtonClickMeSeeAlerts();
    }

    @Story("Проверка окна предупреждения(уведомления)")
    @Test(priority = 9, description = "Проверка появления окна уведомления с ожиданием 5 сек и его подтверждением")
    @Description("Проверка появления окна уведомления с ожиданием 5 сек и его подтверждением")
    public void clickButtonsFiveSeconds() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.setButtonClickMeFiveSeconds();
    }

    @Story("Проверка окна подтверждения")
    @Test(priority = 10, description = "Проверка появления окна уведомления")
    @Description("Проверка появления окна уведомления")
    public void clickButtonsConfirmBox() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.setButtonClickMeConfirmBox();
    }

    @Test(priority = 11)
    @Description("Проверка отображения текста «You selected Ok».")
    public void comparisonTextButtonConfirmBox() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        Assert.assertEquals("You selected Ok", alertsFrameAndWindows.getTextConfirmBox());
    }

    @Story("Проверка окна подсказки")
    @Test(priority = 12, description = "Проверка ввода тестовых данных в окно подсказки «Test name»")
    @Description("Проверка ввода тестовых данных «Test name» в окно подсказки")
    public void clickButtonsPromptBox() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        alertsFrameAndWindows.setButtonClickMePrompBox();
    }

    @Test(priority = 13, description = "Проверка отображения тескта «You entered Test name»")
    @Description("Проверка отображения тескта «You entered Test name»")
    public void comparisonTextButtonPrompBox() {
        Alerts_Frame_and_Windows alertsFrameAndWindows = new Alerts_Frame_and_Windows();
        System.out.println(alertsFrameAndWindows.getTextPrompBox());
        Assert.assertEquals("You entered Test name", alertsFrameAndWindows.getTextPrompBox());
    }
}

















