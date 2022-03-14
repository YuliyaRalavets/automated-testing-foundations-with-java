package test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pastebincom.PastebinComHome;
import pastebincom.PastebinComPaste;

public class PastebinComTest {
    private WebDriver driver;
    PastebinComPaste pastePage;

//@BeforeSuite - Эта аннотация помечает точку входа при запуске.
// Аннотацию @BeforeSuite в TestNG можно использовать для выполнения общих функций, таких как настройка и запуск Selenium или удалённых веб-драйверов и т.д.

    @BeforeTest
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void browserSetup() {
        pastePage = new PastebinComHome(driver)
                .createNewPaste("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force", "how to gain dominance among developers");
    }

    @Test(description = "Is pages title matches Paste Name/ Title")
    public void pageTitleMatchesPasteName() {
        String expectedResultTitle = "how to gain dominance among developers";
        Assert.assertEquals(pastePage.getTitleFromNewPastePage(), expectedResultTitle);
    }

    @Test(description = "Is syntax highlighting for bash")
    public void syntaxHighLightingForBash() {
        String actual = pastePage.textFromHighlightingSyntax();
        Assert.assertEquals(actual.toLowerCase(), "bash");
    }

    @Test(description = "Is code matches the input")
    public void codeMatchesTheInput() {
        String actual = pastePage.textFromRawPasteData();
        String expected = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        Assert.assertEquals(actual, expected);
    }

    /*@AfterTest //предоставление результатов выполнения тестов(отчет,например)
    //@AfterClass - осле последнего тестового метода в текущем классе.
    //Эта аннотация в TestNG может использоваться для выполнения действий по очистке ресурсов после выполнения теста, таких как закрытие драйвера и т.п.
    public void browserClose() {
        driver.quit();
        driver = null;
    }*/
}
