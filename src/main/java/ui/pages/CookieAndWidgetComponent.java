package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookieAndWidgetComponent {

    @FindBy(xpath = "//button[@data-test-id='initial-message-close-button']")
    private WebElement initialMessageCloseButton;

    @FindBy(xpath = "//iframe[@title='chat widget']")
    private WebElement widgetFrame;

    @FindBy(id = "hs-eu-decline-button")
    private WebElement declineCookieButton;

    private WebDriver driver;

    @Autowired
    public CookieAndWidgetComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearPage() {
        driver.switchTo().frame(widgetFrame);
        initialMessageCloseButton.click();
        driver.switchTo().defaultContent();
        declineCookieButton.click();
    }
}
