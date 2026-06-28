import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.ForgotPasswordPage;


import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseUiTest{

   @Test
   @DisplayName("вход по кнопке «Войти в аккаунт» на главной")

   public void loginByMainPageLoginButtonTest() {

       mainPage.clickMainPageLoginButton();

       loginPage.createClient(client);

       assertTrue(mainPage.isMakeOrderButtonDisplayed());


   }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")

    public void loginByMainPagePersonalAccountButtonTest(){

        mainPage.clickPersonalAccountButton();

        loginPage.createClient(client);


        assertTrue(mainPage.isMakeOrderButtonDisplayed());

    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")

    public void loginBysignUpPageLoginButtonTest() {

        mainPage.clickPersonalAccountButton();
        loginPage.clickSignUp();
        signUpPage.clickSignUpPageLoginButton();

        loginPage.createClient(client);


        assertTrue(mainPage.isMakeOrderButtonDisplayed());

    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")

    public void loginByForgotPasswordButtonTest() {

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);

        mainPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickForgotPasswordPageLoginButton();


        mainPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickForgotPasswordPageLoginButton();

        loginPage.createClient(client);


        assertTrue(mainPage.isMakeOrderButtonDisplayed());

    }

}
