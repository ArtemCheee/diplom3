import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUiTest {

    protected WebDriver webDriver;
    public final static String MAIN_PAGE = "https://stellarburgers.education-services.ru/";

    @Before
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.get(MAIN_PAGE);
    }

    @After

    public void tearDown(){

        webDriver.quit();
    }

}
