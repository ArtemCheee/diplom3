import UserData.ClientModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static UserData.ClientSteps.deleteClient;

public class BaseUiTest {

    protected WebDriver webDriver;
    public final static String MAIN_PAGE = "https://stellarburgers.education-services.ru/";

    private static final boolean USE_YANDEX = false;

    protected String accessToken;

    @Before

    public void startBrowser() {
        WebDriverManager.chromedriver().setup();

        if (USE_YANDEX) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("путь к яндекс браузеру и USE_YANDEX меняем на true");
            this.webDriver = new ChromeDriver(options);
        } else {
            this.webDriver = new ChromeDriver();
        }
        this.webDriver.get(MAIN_PAGE);
    }


    @After
    public void deleteClientAfterTest() {

        if (accessToken != null && !accessToken.isEmpty()) {
            try {
                deleteClient(accessToken);

            } catch (Exception e) {
                System.out.println("Ошибка при удалении: " + e.getMessage());
            }
        }

        if (webDriver != null) {
            webDriver.quit();
          }
    }
}
