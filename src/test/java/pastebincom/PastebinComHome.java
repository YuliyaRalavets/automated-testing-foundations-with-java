package pastebincom;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinComHome {
    private WebDriver webDriver;
    private final String url = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement code;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationContainer;

    @FindBy(className = "toggle__control")
    private WebElement syntaxHighlightingBtn;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingContainer;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingBash;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationIn10minutes;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteBtn;

    public PastebinComHome(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        //webDriver.get(url);
    }

    public void navigate() {
        webDriver.get(url);
    }

    public PastebinComHome setPasteFields(String codeText, String pasteNameText) {
        code.sendKeys(codeText);
        setSyntaxHighlighting();
        setPasteExpiration();
        setTextInPasteName(pasteNameText);
        return this;

    }

    private PastebinComHome setPasteExpiration() {
        //pasteExpirationContainer.click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(pasteExpirationContainer)).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(pasteExpirationIn10minutes)).click();
        //pasteExpirationIn10minutes.click();
        return this;
    }

    private PastebinComHome setSyntaxHighlighting() {
        syntaxHighlightingContainer.click();
        syntaxHighlightingBash.click();
        syntaxHighlightingBtn.click();
        return this;
    }

    private PastebinComHome setTextInPasteName(String text) {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-name"))).sendKeys(text);
        return this;
    }

    public PastebinComPaste createNewPaste(String codeText, String pasteNameText){
        setPasteFields(codeText, pasteNameText);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(createNewPasteBtn)).click();
        return  new PastebinComPaste(webDriver);
    }


    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://pastebin.com");
        PastebinComPaste newPaste = new PastebinComHome(driver)
                .createNewPaste("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force", "how to gain dominance among developers");

        System.out.println(newPaste.textFromHighlightingSyntax());
        System.out.println(newPaste.textFromRawPasteData());
        System.out.println(newPaste.getTitleFromNewPastePage());
        //driver.quit();

    }

}
