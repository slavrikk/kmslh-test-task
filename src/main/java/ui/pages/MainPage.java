package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainPage {

    @Value("${main.page.url}")
    private String url;

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='product-item item-6']/a")
    private WebElement selfServiceButton;

    @Autowired
    private CookieAndWidgetComponent cookieAndWidgetComponent;

    @Autowired
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getSelfServicePage(){
        driver.get(url);
        cookieAndWidgetComponent.clearPage();
        selfServiceButton.click();
        System.out.println();
    }
}
