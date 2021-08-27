import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait driverWaitTime;
    private By activePageErrorLocator = By.cssSelector("[class= 'v-messages__message']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.driverWaitTime = new WebDriverWait(driver,3);
    }

    public void clickProfileIcon(){
        driver.findElement(By.cssSelector("[aria-label='users']")).click();
    }

    private WebElement getActivePageElement(){
        return driver.findElement(By.className("v-dialog--active"));
    }

    public void clickActiveElementLoginButton(){
        getActivePageElement().findElement(By.id("loginButton")).click();
    }

    public void waitUntilActiveElementErrorAppears(){
        driverWaitTime.until(ExpectedConditions.presenceOfElementLocated(activePageErrorLocator));
    }

    private List<WebElement> getListOfErrorsOnActivePage(){
        return getActivePageElement().findElements(activePageErrorLocator);
    }

    public void assessActiveErrorCodes(){
        for (WebElement error: getListOfErrorsOnActivePage())
        {
            Assertions.assertEquals("Invalid user and password",error.getText());
        }
    }

}
