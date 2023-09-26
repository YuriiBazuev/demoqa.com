package com.demoqa.buttons;

import com.demoqa.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Buttons_Page extends Base {

    protected final By buttonsMain = By.xpath("//*[@id = 'item-4']/*[text()='Buttons']");
    protected final By buttonsClickMe = By.xpath("//button[text()='Click Me'][@type = 'button']");
    protected final By buttonsRightClickMe = By.xpath("//button[@id = 'rightClickBtn']");
    protected final By buttonsDoubleClickMe = By.xpath("//button[@id = 'doubleClickBtn']");

    protected final By expectedResultClickMe = By.xpath("//p[@id = 'dynamicClickMessage']");
    protected final By expectedResultRightClickMe = By.xpath("//p[@id = 'rightClickMessage']");
    protected final By expectedResultDoubleClickMe = By.xpath("//p[@id = 'doubleClickMessage']");

    public void clickButtons() {
        WebElement buttonButtons = driver.findElement(buttonsMain);
        buttonButtons.click();
    }

    public void clickMeClick() {
        WebElement clickButtonClickMe = driver.findElement(buttonsClickMe);
        clickButtonClickMe.click();
    }

    public String expectedResultClick() {
        String expectedResultClick = driver.findElement(expectedResultClickMe).getAttribute("textContent");
        return expectedResultClick;
    }

    public void clickRightClickMe() {
        WebElement clickButtonRightClickMe = driver.findElement(buttonsRightClickMe);
        new Actions(driver).contextClick(clickButtonRightClickMe).perform();
    }

    public String expectedResultRightClick() {
        String expectedResultRightClick = driver.findElement(expectedResultRightClickMe).getAttribute("textContent");
        return expectedResultRightClick;
    }

    public void clickDoubleClickMe() {
        WebElement clickButtonDoubleClickMe = driver.findElement(buttonsDoubleClickMe);
        new Actions(driver).doubleClick(clickButtonDoubleClickMe).perform();
    }

    public String expectedResultDoubleClick() {
        String expectedResultDoubleClick = driver.findElement(expectedResultDoubleClickMe).getAttribute("textContent");
        return expectedResultDoubleClick;

    }


}
