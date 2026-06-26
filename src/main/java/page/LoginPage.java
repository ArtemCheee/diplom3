package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.NoSuchElementException;

public class LoginPage {

    private final WebDriver webDriver;

    private final By SignUp = By.xpath("/html/body/div/div/main/div/div/p[1]/a");

    private final By loginButton = By.xpath("//button[text()='Войти']");

    private final By emailOnLoginPage = By.xpath("//input[@name='name']");

    private final By passwordOnLoginPage = By.xpath("//input[@name='Пароль']");

    private final By forgotPasswordButton = By.xpath("//a[contains(text(), 'Восстановить пароль')]");


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

    public void enterEmail(String email){
        webDriver.findElement(emailOnLoginPage).sendKeys(email);
    }

    public void enterPassword(String password){
        webDriver.findElement(passwordOnLoginPage).sendKeys(password);
    }

    public void cliclLoginButton(){
        webDriver.findElement(loginButton).click();
    }

    public void clickForgotPasswordButton(){
        webDriver.findElement(forgotPasswordButton).click();
    }

}
