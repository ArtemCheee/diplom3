package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver webDriver;

    private final By forgotPasswordPageLoginButton = By.xpath("//a[contains(text(), 'Войти')]");

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickForgotPasswordPageLoginButton(){
        webDriver.findElement(forgotPasswordPageLoginButton).click();
}
}
