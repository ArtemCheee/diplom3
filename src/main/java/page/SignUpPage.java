package page;

import UserData.ClientModel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private final WebDriver webDriver;

    private final By NAME_FIELD = By.xpath("(//input[@type='text' and @name='name'])[1]");

    private final By EMAIL_FIELD = By.xpath("(//input[@type='text' and @name='name'])[2]");

    private final By PASSWORD_FIELD = By.xpath("//input[@name='Пароль']");

    private final By SIGN_UP_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    private final By WRONG_PASSWORD_FAILURE = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    private final By SIGN_UP_PAGE_LOGIN_BUTTON = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");


    public SignUpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Ввод имени")
    public void enterName(String email) {
        webDriver.findElement(NAME_FIELD).sendKeys(email);
    }

    @Step("ввод почты")
    public void enterEmail(String name) {
        webDriver.findElement(EMAIL_FIELD).sendKeys(name);
    }

    @Step("ввод пароля")
    public void enterPassword(String password) {
        webDriver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("клик кнопки зарегистрироваться")
    public void clickSignUpButton() {
        webDriver.findElement(SIGN_UP_BUTTON).click();
    }

    @Step("проверка появления ошибки при вводе не валидного пароля")
    public Boolean isWrongPasswordFailureDisplayed() {
        return webDriver.findElement(WRONG_PASSWORD_FAILURE).isDisplayed();

    }

    @Step("автозаполнение формы регистрации")
    public void createClient(ClientModel client) {
        enterName(client.getName());
        enterEmail(client.getEmail());
        enterPassword(client.getPassword());
        clickSignUpButton();

    }

    @Step("клик кнопки войти на странице регистрации")
    public void clickSignUpPageLoginButton(){
        webDriver.findElement(SIGN_UP_PAGE_LOGIN_BUTTON).click();
    }

}