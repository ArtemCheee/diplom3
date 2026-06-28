import UserData.ClientData;


import io.qameta.allure.junit4.DisplayName;

import org.junit.Test;



import static org.junit.Assert.assertTrue;

public class SignUpTest extends BaseUiTest {


    @Test
    @DisplayName("Успешная регистрация")

    public void successfulSignUpTest() {

        mainPage.clickPersonalAccountButton();

        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")

    public void wrongPasswordFailureSignUpTest() {

        String name = ClientData.generateRandomName();
        String email = ClientData.generateRandomEmail();
        String password = ClientData.generateWrongRandomPassword();

        mainPage.clickPersonalAccountButton();

        loginPage.clickSignUp();

        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.clickSignUpButton();

        assertTrue(signUpPage.isWrongPasswordFailureDisplayed());

    }

}