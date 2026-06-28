import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class ConstructorNavigationTest extends BaseUiTest{

    public ConstructorNavigationTest() {
        needClient = false;
    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам Булки")

    public void bunTabNavigationTest(){

        mainPage.clickConstructorBunTab();

        assertEquals("Булки", mainPage.getActiveTabName());

    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам соусы")

    public void sauceTabNavigationTest(){


        mainPage.clickConstructorSauceTab();

        assertEquals("Соусы", mainPage.getActiveTabName());

    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам Начинки")

    public void fillingTabNavigationTest(){


        mainPage.clickConstructorFillingsTab();

        assertEquals("Начинки", mainPage.getActiveTabName());

    }


}
