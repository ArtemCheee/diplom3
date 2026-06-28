package page;

import UserData.ClientModel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver webDriver;

    private final WebDriverWait wait;

    private final By SIGN_UP = By.xpath("//p/a[text()='Зарегистрироваться']");

    private final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");

    private final By EMAIL_ON_LOGIN_PAGE = By.xpath("//input[@name='name']");

    private final By PASSWORD_ON_LOGIN_PAGE = By.xpath("//input[@name='Пароль']");

    private final By FORGOT_PASSWORD_BUTTON = By.xpath("//a[contains(text(), 'Восстановить пароль')]");


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_UP)).click();
    }

    @Step("Проверка видна ли кнопка 'Войти'")
    public boolean isLoginButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Ввод email")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_ON_LOGIN_PAGE)).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_ON_LOGIN_PAGE)).sendKeys(password);
    }


    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }

    @Step("Клик по кнопке 'Восстановить пароль'")
    public void clickForgotPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FORGOT_PASSWORD_BUTTON)).click();
    }

    @Step("автозаполнение формы регистрации")
    public void createClient(ClientModel client) {
        enterEmail(client.getEmail());
        enterPassword(client.getPassword());
        clickLoginButton();

    }

}
