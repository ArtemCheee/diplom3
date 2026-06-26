package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;


public class MainPage {

    private final WebDriver webDriver;
    private final By PersonalAccountButton = By.xpath("/html/body/div/div/header/nav/a");

    private final By mainPageLoginButton = By.xpath("//button[text()='Войти в аккаунт']");

    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickPersonalAccountButton(){
      webDriver.findElement(this.PersonalAccountButton).click();
    }

    public void clickMainPageLoginButton(){
        webDriver.findElement(mainPageLoginButton).click();
    }

    public boolean isMakeOrderButtonDisplayed(){

        return webDriver.findElement(makeOrderButton).isDisplayed();
    }
    }
