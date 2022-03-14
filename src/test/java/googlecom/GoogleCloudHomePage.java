package googlecom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudHomePage {
    private WebDriver webDriver;

    @FindBy(name = "q")
    WebElement searchBox;

    public GoogleCloudHomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public GoogleSearchResultPage getResultSearchPage(String textForSearch) {
        searchBox.click();
        searchBox.sendKeys(textForSearch + Keys.ENTER);
        return new GoogleSearchResultPage(webDriver);
    }

}
