package guru.qa.issuetests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsIssueTest {

    @BeforeEach
    void preconditionBrowser() {
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
    @Step("Открываем главную страницу")
    public void openMainPage() {open("https://github.com");
    }
    @Step("Ищем репоизторий Zo1oft/Homework2")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo).pressEnter();}
    @Step("Открываем репозиторий Zo1oft/Homework2")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }
    @Step("Проверяем что Issues существует")
    public void shouldSeeIssue() {
        $("#issues-tab").should((Condition.visible));
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);}
}
