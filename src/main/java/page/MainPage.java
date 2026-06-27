package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    private final WebDriverWait wait;
    private final WebDriver webDriver;

    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//p[text()='Личный Кабинет']");

    private final By MAIN_PAGE_LOGIN_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");

    private final By MAKE_ORDER_BUTTON = By.xpath("//button[text()='Оформить заказ']");

    private final By CONSTRUCTOR_BUN_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Булки']/..");

    private final By CONSTRUCTOR_SAUCE_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Соусы']/..");

    private final By CONSTRUCTOR_FILLINGS_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Начинки']/..");

    private final By ACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc')]");



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Step("клик 'Личный кабинет' в шапке")
    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PERSONAL_ACCOUNT_BUTTON)).click();
    }

    @Step("Клик кнопки 'Войти в аккаунт'")
    public void clickMainPageLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MAIN_PAGE_LOGIN_BUTTON)).click();
    }

    @Step("Проверка отображения кнопки 'Оформить заказ' после успешного логина")
    public boolean isMakeOrderButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MAKE_ORDER_BUTTON));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Клик по вкладке 'Булки' в конструкторе")
    public void clickConstructorBunTab() {
        wait.until(ExpectedConditions.elementToBeClickable(CONSTRUCTOR_BUN_TAB)).click();
    }

    @Step("Клик по вкладке 'Соусы' в конструкторе")
    public void clickConstructorSauceTab() {
        wait.until(ExpectedConditions.elementToBeClickable(CONSTRUCTOR_SAUCE_TAB)).click();
    }

    @Step("Клик по вкладке 'Начинки' в конструкторе")
    public void clickConstructorFillingsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(CONSTRUCTOR_FILLINGS_TAB)).click();
    }

    @Step("Получение текста активной вкладки")
    public String getActiveTabName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ACTIVE_TAB)).getText();
    }
}
