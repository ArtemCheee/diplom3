package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver webDriver;

    private final By FORGOT_PASSWORD_PAGE_LOGIN_BUTTON = By.xpath("//a[contains(text(), 'Войти')]");

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickForgotPasswordPageLoginButton(){
        webDriver.findElement(FORGOT_PASSWORD_PAGE_LOGIN_BUTTON).click();
}
}
