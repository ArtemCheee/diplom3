package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private final WebDriver webDriver;

    private final By nameField = By.xpath("(//input[@type='text' and @name='name'])[1]");

    private final By emailField = By.xpath("(//input[@type='text' and @name='name'])[2]");

    private final By passwordField = By.xpath("//input[@name='Пароль']");

    private final By signUpButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    private final By wrongPasswordFailure = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    public SignUpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterName(String email){
        webDriver.findElement(nameField).sendKeys(email);
    }

    public void enterEmail(String name){
        webDriver.findElement(emailField).sendKeys(name);
    }

    public void enterPassword(String password){
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void ckickSignUpButton(){
        webDriver.findElement(signUpButton).click();
    }

    public Boolean isWrongPasswordFailureDisplayed() {
        return webDriver.findElement(wrongPasswordFailure).isDisplayed();

    }

}
