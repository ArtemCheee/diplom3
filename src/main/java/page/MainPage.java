package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {

    private final WebDriver webDriver;
    private final By PersonalAccountButton = By.xpath("/html/body/div/div/header/nav/a");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void ckickPersonalAccountButton(){
      webDriver.findElement(this.PersonalAccountButton).click();
    }

    }
