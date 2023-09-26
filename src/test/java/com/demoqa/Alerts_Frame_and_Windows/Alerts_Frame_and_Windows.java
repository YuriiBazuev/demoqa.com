package com.demoqa.Alerts_Frame_and_Windows;

import com.demoqa.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Alerts_Frame_and_Windows extends Base {

    protected final By alertsFrameAndWindowsAccordion = By.xpath("//div [@class = 'accordion']//div [@class = 'element-group'][3]/*[1]");
    protected final By browserWindowsAlertsFrame = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
    protected final By buttonsAlertsAlertsFrame = By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']");
    protected final By buttonNewWindows = By.xpath("//button[@id = 'windowButton']");
    protected final By buttonNewTab = By.xpath("//button[@id = 'tabButton']");
    protected final By buttonClickMeSeeAlert = By.xpath("//button[@id= 'alertButton']");
    protected final By buttonClickMeAfterFive = By.xpath("//button[@id= 'timerAlertButton']");
    protected final By buttonClickMeConfirmBoxAppear = By.xpath("//button[@id= 'confirmButton']");
    protected final By buttonClickMePromptBoxAppear = By.xpath("//button[@id= 'promtButton']");
    protected final String testData = "Test name";
    protected final By getTextConfirmBox = By.xpath("//span[@id = 'confirmResult']");
    protected final By getTextPrompBox = By.xpath("//span[@id = 'promptResult']");


    public void clickAlertsFrameAccordion() {

        WebElement clickAlerts = driver.findElement(alertsFrameAndWindowsAccordion);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(250, 0)"); //смещение
        jse.executeScript("scroll(0, 250)");

        clickAlerts.click();
    }

    public void clickBrowserWindowsAlertsFrame() {
        WebElement clickBrowserWindows = driver.findElement(browserWindowsAlertsFrame);
        clickBrowserWindows.click();
    }

    public void clickNewTab() {
        WebElement openNewTab = driver.findElement(buttonNewTab);
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        openNewTab.click();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public void clickNewWindow() {
        WebElement openNewWindows = driver.findElement(buttonNewWindows);
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        openNewWindows.click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(originalWindow);

    }

    public void clickButtonAlerts() {
        WebElement buttonAlerts = driver.findElement(buttonsAlertsAlertsFrame);
        buttonAlerts.click();
    }

    public void setButtonClickMeSeeAlerts() {
        WebElement buttonClickMe = driver.findElement(buttonClickMeSeeAlert);
        buttonClickMe.click();
        driver.switchTo().alert().accept();
    }

    public void setButtonClickMeFiveSeconds() {
        WebElement buttonFiveSeconds = driver.findElement(buttonClickMeAfterFive);
        buttonFiveSeconds.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void setButtonClickMeConfirmBox() {
        WebElement buttonConfirmBox = driver.findElement(buttonClickMeConfirmBoxAppear);
        buttonConfirmBox.click();
        driver.switchTo().alert().accept();
    }

    public String getTextConfirmBox() {
        WebElement findText = driver.findElement(getTextConfirmBox);
        String text = findText.getAttribute("textContent");
        return text;
    }

    public void setButtonClickMePrompBox() {
        WebElement buttonPermanentBox = driver.findElement(buttonClickMePromptBoxAppear);
        buttonPermanentBox.click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys(testData);
        prompt.accept();
    }

    public String getTextPrompBox() {
        WebElement findText = driver.findElement(getTextPrompBox);
        String textPromp = findText.getAttribute("textContent");
        return textPromp;
    }


}
