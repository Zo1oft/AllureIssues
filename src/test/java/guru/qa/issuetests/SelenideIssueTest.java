package guru.qa.issuetests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideIssueTest {

@BeforeEach
void preconditionBrowser() {
    Configuration.browserSize = "1920x1080";
}
@AfterEach
void closeBrowser() {
    Selenide.closeWebDriver();
}

    @Test
    public void testSimpleIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Zo1oft/Homework2");
        $(".header-search-input").submit();

        $(By.linkText("Zo1oft/Homework2")).click();
        $(withText("Issues")).should(Condition.exist);
    }



}
