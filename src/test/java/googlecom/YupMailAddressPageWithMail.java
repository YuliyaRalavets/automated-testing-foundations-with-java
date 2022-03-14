package googlecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YupMailAddressPageWithMail {
    private WebDriver webDriver;

    @FindBy()
    WebElement totalEstimateMonthlyCostField;

    public YupMailAddressPageWithMail(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String getTotalEstimateMonthlyCost() {
        webDriver.switchTo().frame("ifmail");
        return new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mail\"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")))
                .getText()
                .replaceAll("USD ", "");
    }
}
