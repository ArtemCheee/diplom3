package page;

import UserData.ClientModel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    private final WebDriver webDriver;

    private final WebDriverWait wait;

    private final By NAME_FIELD = By.xpath("(//input[@type='text' and @name='name'])[1]");

    private final By EMAIL_FIELD = By.xpath("(//input[@type='text' and @name='name'])[2]");

    private final By PASSWORD_FIELD = By.xpath("//input[@name='Пароль']");

    private final By SIGN_UP_BUTTON = By.xpath("//form//button[text()='Зарегистрироваться']");

    private final By WRONG_PASSWORD_FAILURE = By.xpath("//fieldset[3]//p[contains(@class, 'error')]");

    private final By SIGN_UP_PAGE_LOGIN_BUTTON = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");


    public SignUpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Step("Ввод имени")
    public void enterName(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_FIELD)).sendKeys(email);
    }

    @Step("ввод почты")
    public void enterEmail(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD)).sendKeys(name);
    }

    @Step("ввод пароля")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(password);
    }

    @Step("клик кнопки зарегистрироваться")
    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_UP_BUTTON)).click();
    }

    @Step("проверка появления ошибки при вводе не валидного пароля")
    public Boolean isWrongPasswordFailureDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WRONG_PASSWORD_FAILURE));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("автозаполнение формы регистрации")
    public void createClient(ClientModel client) {
        enterName(client.getName());
        enterEmail(client.getEmail());
        enterPassword(client.getPassword());
        clickSignUpButton();

    }

    @Step("клик кнопки войти на странице регистрации")
    public void clickSignUpPageLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SIGN_UP_PAGE_LOGIN_BUTTON)).click();
    }

}