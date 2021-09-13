package ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ui.config.ConfigUIContext;
import ui.pages.AutomationTestPage;
import ui.pages.MainPage;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.*;

@ContextConfiguration(classes = ConfigUIContext.class)
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class KmsScenariosTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AutomationTestPage automationTestPage;

    @Autowired
    private MainPage mainPage;

    @Test(description = "The first scenario")
    public void submitRegistrationTest() {
        automationTestPage.submitRegistrationWithRandomData();
    }

    @Test(description = "The second scenario")
    public void assertOpenVideoInSelfServiceTest() {
        mainPage.getSelfServicePage();
    }
}
