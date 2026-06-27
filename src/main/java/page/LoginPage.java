package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.NoSuchElementException;

public class LoginPage {

    private final WebDriver webDriver;

    private final By SIGN_UP = By.xpath("/html/body/div/div/main/div/div/p[1]/a");

    private final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");

    private final By EMAIL_ON_LOGIN_PAGE = By.xpath("//input[@name='name']");

    private final By PASSWORD_ON_LOGIN_PAGE = By.xpath("//input[@name='Пароль']");

    private final By FORGOT_PASSWORD_BUTTON = By.xpath("//a[contains(text(), 'Восстановить пароль')]");


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickSignUp() {
        webDriver.findElement(this.SIGN_UP).click();
    }

    @Step("Проверка видна ли кнопка войти")
    public boolean isLoginButtonDisplayed() {
        try {
            return webDriver.findElement(LOGIN_BUTTON).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Вовод email")
    public void enterEmail(String email){
        webDriver.findElement(EMAIL_ON_LOGIN_PAGE).sendKeys(email);
    }

    @Step("ввод пароля")
    public void enterPassword(String password){
        webDriver.findElement(PASSWORD_ON_LOGIN_PAGE).sendKeys(password);
    }

    @Step("клик кнопки войти")
    public void cliclLoginButton(){
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Клик кнопки восстановить пароль")
    public void clickForgotPasswordButton(){
        webDriver.findElement(FORGOT_PASSWORD_BUTTON).click();
    }

}
