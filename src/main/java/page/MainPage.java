package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    private final WebDriver webDriver;

    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath("/html/body/div/div/header/nav/a");

    private final By MAIN_PAGE_LOGIN_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");

    private final By MAKE_ORDER_BUTTON = By.xpath("//button[text()='Оформить заказ']");

    private final By CONSTRUCTOR_BUN_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Булки']/..");

    private final By CONSTRUCTOR_SAUCE_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Соусы']/..");

    private final By CONSTRUCTOR_FILLINGS_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Начинки']/..");

    private final By ACTIVE_TAB = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc')]");



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("клик Личный кабинет в шапке")
    public void clickPersonalAccountButton(){
      webDriver.findElement(this.PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Клик кнопки Войти в аккаунт")
    public void clickMainPageLoginButton(){
        webDriver.findElement(MAIN_PAGE_LOGIN_BUTTON).click();
    }

    @Step("Проверка отображения кнопки Оформить заказ после успешного логина")
    public boolean isMakeOrderButtonDisplayed(){
        return webDriver.findElement(MAKE_ORDER_BUTTON).isDisplayed();
    }

    @Step("Клик по булке в конструкторе бургера")
    public void clickConstructorBunTab(){
        webDriver.findElement(CONSTRUCTOR_BUN_TAB).click();
    }

    @Step("Клик по соусы в конструкторе бургера")
    public void clickConstructorSauceTab(){
        webDriver.findElement(CONSTRUCTOR_SAUCE_TAB).click();
    }

    @Step("клик по начинки в конструкторе бургера")
    public void clickConstructorFillingsTab(){
        webDriver.findElement(CONSTRUCTOR_FILLINGS_TAB).click();
    }

    @Step("Получаем текст активной вкладки")
    public String getActiveTabName(){
        return webDriver.findElement(ACTIVE_TAB).getText();
    }

    }
