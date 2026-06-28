import UserData.ClientModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import page.MainPage;
import page.SignUpPage;

import java.time.Duration;

import static UserData.ClientData.generateRandomUser;
import static UserData.ClientSteps.createClient;
import static UserData.ClientSteps.deleteClient;

public class BaseUiTest {

    protected WebDriver webDriver;
    public final static String MAIN_PAGE = "https://stellarburgers.education-services.ru/";

    private static final boolean USE_YANDEX = false;

    protected String accessToken;
    protected Response clientResponse;
    protected ClientModel client;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected WebDriverWait wait;
    protected boolean needClient = true;

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
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        this.webDriver.get(MAIN_PAGE);

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        signUpPage = new SignUpPage(webDriver);
    }
@Before

    public void createClientBefore() {
    if (needClient) {

        client = generateRandomUser();

        clientResponse = createClient(client)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        accessToken = clientResponse.jsonPath().getString("accessToken");
    }
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
