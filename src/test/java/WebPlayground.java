import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;

public class WebPlayground {

    private WebDriver drive;
    private WebDriver formDrive;
    private WebDriver planetDriver;
    private String correctPlanet;

    @BeforeEach
    public void BeforeTests(){
        drive = new ChromeDriver();
        drive.get("https://d1iw6mb9di5l9r.cloudfront.net/#/");
        formDrive = new ChromeDriver();
        formDrive.get("https://d1iw6mb9di5l9r.cloudfront.net/#/forms");
        planetDriver = new ChromeDriver();
        planetDriver.get("https://d1iw6mb9di5l9r.cloudfront.net/#/planets");

    }


    @Test
    public void WebTest()
    {
        drive.findElement(By.cssSelector("a[role = 'button']")).click();
    }

    @Test
    public void LoginButtonTest(){
       HomePage homePage = new HomePage(drive);
       homePage.clickProfileIcon();
       homePage.clickActiveElementLoginButton();
       homePage.waitUntilActiveElementErrorAppears();
       homePage.assessActiveErrorCodes();
    }



    @Test
    public void ConfirmFormLoginDialogTest()
    {
        var formPage = new FormPage(formDrive);
        formPage.clickSubmitButton();
        formPage.assessPageErrors();
    }


    @Test
    public void ConfirmThatNoErrorsAppearOnValidDataEntry()
    {
        var formPage = new FormPage(formDrive);
        formPage.enterCorrectPageData();
        formPage.clickAgreeButton();
        formPage.assessLackOfPageErrors();
    }

    @Test
    public void ConfirmPlanetDistanceFromSunTest() throws ParseException {
        Assertions.assertEquals(149600000,new PlanetPage(planetDriver).findPlanetWithName("Earth").getDistance());
    }

    @Test
    public void ConfirmRadiusOfPlanet() throws ParseException {
        Assertions.assertEquals(6371.0,new PlanetPage(planetDriver).findPlanetWithName("Earth").getRadius());

    }

    @Test
    public void FindPlanetMostDistantFromSunTest() throws ParseException {
        var planetPage = new PlanetPage(planetDriver);
        Assertions.assertTrue(planetPage.getPlanet(new CheckIfDistanceIsLarger(4495000))!=(null), "Neptune wasn't the furtherest planet");

    }

    @Test
    public void FindMostDistantPlanetTest()
    {
        var planetPage = new PlanetPage(planetDriver);
        long dis = 0;

        for (Planet planet:planetPage.getPlanetsListAsPlanets()) {


        }

    }


    @Test
    public void matchablePlanetTest() throws ParseException {
        var planetPage = new PlanetPage(planetDriver);
        Assertions.assertEquals("Earth",planetPage.getPlanet(new MatchByName("Earth")).getName());


    }



    @AfterEach
    public void AfterTests(){
        drive.quit();
        formDrive.quit();
        planetDriver.quit();
    }



}
