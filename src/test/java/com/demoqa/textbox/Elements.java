package com.demoqa.textbox;

import com.demoqa.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends Base {

    protected final By cardElements = By.xpath("//div[@class = 'category-cards']/*[1]");
    protected final By textBoxAccordion = By.xpath("//li[@id='item-0']/*[text()='Text Box']");
    protected final By fullNameTextBox = By.xpath("//input[@id='userName']");
    protected final By emailTextBox = By.xpath("//input[@id='userEmail']");
    protected final By currentAddressTextBox = By.xpath("//textarea[@id='currentAddress']");
    protected final By permanentAddressTextBox = By.xpath("//textarea[@id='permanentAddress']");
    protected final By buttonSubmitTextBox = By.xpath("//button[@id = 'submit']");
    protected final By realDataName = By.xpath("//p[@id='name']");
    protected final By realDataEmail = By.xpath("//p[@id='email']");
    protected final By realDataCurrentAddress = By.xpath("//p[@id='currentAddress']");
    protected final By realDataPermanentAddress = By.xpath("//p[@id='permanentAddress']");
    protected final String email = "kyznecov@mail.ru";
    protected final String currentAddress = "325499, Екатеринбург, ул. Шевцова, 15-65";
    protected final String permanentAddress = "325499, Екатеринбург, ул. Шевцова, 15-65";


    private String[] fullNames;

    public Elements() {
        this.fullNames = fullNames;
    }

    public void clickElementsCard() {
        WebElement elements = driver.findElement(cardElements);
        elements.click();
    }

    public void clickTextBox() {
        WebElement textBox = driver.findElement(textBoxAccordion);
        textBox.click();
    }

    public void findFieldFullNameTextBox(String fullName) {
        WebElement fieldFullNameTextBox = driver.findElement(fullNameTextBox);
        fieldFullNameTextBox.click();

        String fullNameText = String.join(" ", fullName);
        fieldFullNameTextBox.sendKeys(fullNameText);
    }

    public String findFieldEmail() {

        WebElement fieldEmail = driver.findElement(emailTextBox);
        fieldEmail.click();
        fieldEmail.sendKeys(email);
        String expectedEmail = email;
        return expectedEmail;
    }

    public String findFieldCurrentAddress() {
        WebElement fieldCurrentAddress = driver.findElement(currentAddressTextBox);
        fieldCurrentAddress.click();
        fieldCurrentAddress.sendKeys(currentAddress);
        String expectedCurrentAddres = currentAddress;
        return expectedCurrentAddres;
    }

    public String findFieldPermanentAddress() {
        WebElement fieldCurrentAddress = driver.findElement(permanentAddressTextBox);
        fieldCurrentAddress.click();
        fieldCurrentAddress.sendKeys(permanentAddress);
        String expectedPermanentAddres = permanentAddress;
        return expectedPermanentAddres;
    }

    public void clickbuttomSubmit() {
        WebElement bottomSubmit = driver.findElement(buttonSubmitTextBox);
        bottomSubmit.click();
    }

    public String getAssertsName() {
        String assertName = driver.findElement(realDataName).getAttribute("innerText").replace("Name:", "");
        return assertName;
    }

    public String getAssertsEmail() {
        String assertEmail = driver.findElement(realDataEmail).getAttribute("innerText").replace("Email:", "");
        return assertEmail;
    }

    public String getAssertsCurrentAddress() {
        String assertCurrentAddress = driver.findElement(realDataCurrentAddress).getAttribute("innerText").replace("Current Address :", "");
        return assertCurrentAddress;
    }

    public String getAssertsPermanentAddress() {
        String assertPermanentAddress = driver.findElement(realDataPermanentAddress).getAttribute("innerText").replace("Permananet Address :", "");
        return assertPermanentAddress;
    }


}
