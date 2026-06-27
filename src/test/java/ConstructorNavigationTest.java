import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.MainPage;

import static org.junit.Assert.assertEquals;


public class ConstructorNavigationTest extends BaseUiTest{

    @Test
    @DisplayName("Проверка, что работают переходы к разделам Булки")

    public void bunTabNavigationTest(){

        MainPage mainPage = new MainPage(webDriver);

        mainPage.clickConstructorSauceTab();
        mainPage.clickConstructorBunTab();

        assertEquals("Булки", mainPage.getActiveTabName());

    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам соусы")

    public void sauceTabNavigationTest(){

        MainPage mainPage = new MainPage(webDriver);

        mainPage.clickConstructorSauceTab();

        assertEquals("Соусы", mainPage.getActiveTabName());

    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам Начинки")

    public void fillingTabNavigationTest(){

        MainPage mainPage = new MainPage(webDriver);

        mainPage.clickConstructorFillingsTab();

        assertEquals("Начинки", mainPage.getActiveTabName());

    }


}
