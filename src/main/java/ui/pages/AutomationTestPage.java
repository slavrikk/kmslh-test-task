package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import ui.service.RandomDataGeneratorService;

@Component
public class AutomationTestPage {

    @Value("${automation.page.url}")
    private String url;

    @Value("${success.greeting}")
    private String successGreeting;

    @Value("${success.greeting.touch}")
    private String successGreetingTouch;

    @Autowired
    private RandomDataGeneratorService randomDataGenerator;

    @FindBy(id = "firstname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private WebElement firstNameInput;

    @FindBy(id = "lastname-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private WebElement lastNameInput;

    @FindBy(id = "email-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private WebElement emailInput;

    @FindBy(id = "phone-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private WebElement phoneInput;

    @FindBy(id = "company-9de5ebd5-2ab3-48fe-bac8-bfc25cfc5814")
    private WebElement companyInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[@class='elementor-heading-title elementor-size-small']")
    private WebElement successSubmittedText;

    private WebDriver driver;

    @Autowired
    private CookieAndWidgetComponent cookieAndWidgetComponent;

    @Autowired
    public AutomationTestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitRegistrationWithRandomData() {
        driver.get(url);
        cookieAndWidgetComponent.clearPage();
        inputRandomData();
        submitButton.click();
        Assert.assertTrue(successSubmittedText.isDisplayed(), "Message is not displayed!");
        Assert.assertTrue(successSubmittedText.getText().contains(successGreeting), "Obtaining text doesn`t contain the greeting message!");
        Assert.assertTrue(successSubmittedText.getText().contains(successGreetingTouch), "The second greeting message doesn`t match expected text!");
    }

    private void inputRandomData() {
        firstNameInput.sendKeys(randomDataGenerator.getRandomString(5));
        lastNameInput.sendKeys(randomDataGenerator.getRandomString(5));
        emailInput.sendKeys(randomDataGenerator.getRandomEmail(5, 4));
        phoneInput.sendKeys(randomDataGenerator.getRandomNumber(9));
        companyInput.sendKeys(randomDataGenerator.getRandomString(5));
    }
}
