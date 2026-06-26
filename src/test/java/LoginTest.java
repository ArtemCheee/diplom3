import UserData.ClientData;
import UserData.ClientModel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.MainPage;
import page.SignUpPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseUiTest{

   @Test
   @DisplayName("вход по кнопке «Войти в аккаунт» на главной")

   public void loginByMainPageLoginButtonTest() throws InterruptedException{

       ClientModel clientModel = ClientData.generateRandomUser();

       new MainPage(webDriver).clickPersonalAccountButton();
       new LoginPage(webDriver).clickSignUp();
       new SignUpPage(webDriver).createClient(clientModel);

       webDriver.get(BaseUiTest.MAIN_PAGE);

       MainPage mainPage = new MainPage(webDriver);

       mainPage.clickMainPageLoginButton();

       LoginPage loginPage = new LoginPage(webDriver);
       loginPage.enterEmail(clientModel.getEmail());
       loginPage.enterPassword(clientModel.getPassword());
       loginPage.cliclLoginButton();

       Thread.sleep(2000);
       assertTrue(mainPage.isMakeOrderButtonDisplayed());

   }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")

    public void loginByMainPagePersonalAccountButtonTest() throws InterruptedException{

        ClientModel clientModel = ClientData.generateRandomUser();

        new MainPage(webDriver).clickPersonalAccountButton();
        new LoginPage(webDriver).clickSignUp();
        new SignUpPage(webDriver).createClient(clientModel);

        webDriver.get(BaseUiTest.MAIN_PAGE);

        MainPage mainPage = new MainPage(webDriver);

        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterEmail(clientModel.getEmail());
        loginPage.enterPassword(clientModel.getPassword());
        loginPage.cliclLoginButton();

        Thread.sleep(2000);
        assertTrue(mainPage.isMakeOrderButtonDisplayed());

    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")

    public void loginBysignUpPageLoginButtonTest() throws InterruptedException{

        ClientModel clientModel = ClientData.generateRandomUser();

        new MainPage(webDriver).clickPersonalAccountButton();
        new LoginPage(webDriver).clickSignUp();
        new SignUpPage(webDriver).createClient(clientModel);

        webDriver.get(BaseUiTest.MAIN_PAGE);

        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        SignUpPage signUpPage = new SignUpPage(webDriver);

        mainPage.clickPersonalAccountButton();
        loginPage.clickSignUp();
        signUpPage.clickSignUpPageLoginButton();


        loginPage.enterEmail(clientModel.getEmail());
        loginPage.enterPassword(clientModel.getPassword());
        loginPage.cliclLoginButton();

        Thread.sleep(2000);
        assertTrue(mainPage.isMakeOrderButtonDisplayed());

    }


    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")

    public void loginByForgotPasswordButtonTest() throws InterruptedException{

        ClientModel clientModel = ClientData.generateRandomUser();

        new MainPage(webDriver).clickPersonalAccountButton();
        new LoginPage(webDriver).clickSignUp();
        new SignUpPage(webDriver).createClient(clientModel);

        webDriver.get(BaseUiTest.MAIN_PAGE);

        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);

        mainPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordButton();
        forgotPasswordPage.clickForgotPasswordPageLoginButton();


        loginPage.enterEmail(clientModel.getEmail());
        loginPage.enterPassword(clientModel.getPassword());
        loginPage.cliclLoginButton();

        Thread.sleep(2000);
        assertTrue(mainPage.isMakeOrderButtonDisplayed());

    }

}
