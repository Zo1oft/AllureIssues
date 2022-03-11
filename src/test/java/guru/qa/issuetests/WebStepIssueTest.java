package guru.qa.issuetests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class WebStepIssueTest {

    private static final String repo = "Zo1oft/Homework2";

    @Test
    public void testAnnotatedIssueSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsIssueTest steps = new StepsIssueTest();

        steps.openMainPage();
        steps.searchForRepository(repo);
        steps.openRepository(repo);
        steps.shouldSeeIssue();
        steps.takeScreenshot();
    }
}
