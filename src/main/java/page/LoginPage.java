package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.NoSuchElementException;

public class LoginPage {

    private final WebDriver webDriver;

    private final By SignUp = By.xpath("/html/body/div/div/main/div/div/p[1]/a");

    private final By loginButton = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickSignUp() {
        webDriver.findElement(this.SignUp).click();
    }

    public boolean isLoginButtonDisplayed() {
        try {
            return webDriver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
