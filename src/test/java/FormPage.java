import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

    private WebDriver driver;
    private By submitButtonLocator = By.cssSelector("[class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default']");
    private By nameErrorTextLocator = By.id("name-err");
    private By emailErrorTextLocator = By.id("email-err");
    private By agreeErrorTextLocator = By.id("agree-err");
    private By nameForm = By.id("name");
    private By emailForm = By.id("email");
    private By agreeLabel = By.cssSelector("[for='agree']");


    public FormPage ( WebDriver driver){
        this.driver = driver;
    }

    public void clickSubmitButton(){
        driver.findElement(submitButtonLocator).click();
    }

    public void assessPageErrors(){
        Assertions.assertEquals("Your name is required",driver.findElement(nameErrorTextLocator).getText());
        Assertions.assertEquals("Your email is required",driver.findElement(emailErrorTextLocator).getText());
        Assertions.assertEquals("You must agree to continue",driver.findElement(agreeErrorTextLocator).getText());
    }

    public void enterCorrectPageData(){
        driver.findElement(nameForm).sendKeys("test");
        driver.findElement(emailForm).sendKeys("a@a.com");
    }

    public void clickAgreeButton(){
        driver.findElement(agreeLabel).click();
    }

    public void assessLackOfPageErrors(){
        Assertions.assertTrue(driver.findElements(agreeErrorTextLocator).size() == 0);
        Assertions.assertTrue(driver.findElements(nameErrorTextLocator).size() == 0);
        Assertions.assertTrue(driver.findElements(emailErrorTextLocator).size() == 0);
    }



}
