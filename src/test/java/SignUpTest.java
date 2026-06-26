import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.LoginPage;
import page.MainPage;
import page.SignUpPage;

import static org.junit.Assert.assertTrue;

public class SignUpTest extends BaseUiTest {


    @Test
    @DisplayName("Успешная регистрация")

    public void successfulSignUpTest() throws InterruptedException{

        String name = ClientData.generateRandomName();
        String email = ClientData.generateRandomEmail();
        String password = ClientData.generateRandomPassword();


        MainPage mainPage = new MainPage(webDriver);
        mainPage.ckickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickSignUp();

        SignUpPage signUpPage = new SignUpPage(webDriver);

        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.ckickSignUpButton();

        Thread.sleep(2000);

        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")

    public void WrongPasswordFailureSignUpTest() {

        String name = ClientData.generateRandomName();
        String email = ClientData.generateRandomEmail();
        String password = ClientData.generateWrongRandomPassword();


        MainPage mainPage = new MainPage(webDriver);
        mainPage.ckickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickSignUp();

        SignUpPage signUpPage = new SignUpPage(webDriver);

        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.ckickSignUpButton();

        assertTrue(signUpPage.isWrongPasswordFailureDisplayed());

    }

}