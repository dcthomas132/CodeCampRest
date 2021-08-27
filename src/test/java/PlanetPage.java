import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PlanetPage {

    private final WebDriver driver;


    public PlanetPage(WebDriver driver)
    {
        this.driver = driver;

    }

    private List<WebElement> getPlanetList()
    {
        return driver.findElements(By.className("planet"));
    }

    private List<Planet> convertWebElementToPlanets(){
        List<Planet> planets = null;
        for (WebElement planet:getPlanetList()) {

            if (planets != null) {
                planets.add(new Planet(planet));
            }

        }
        return planets;
    }

    public Planet findPlanetWithName(String planetName){
        for (WebElement webObject:getPlanetList())
        {
            if(webObject.findElement(By.className("name")).getText().equals(planetName))
            {
               return new Planet(webObject);
            }

        }
        return null;
    }

    public Planet getPlanet(Matchable matchable) throws ParseException {

        for (Planet planet:getPlanetsListAsPlanets())
        {
            if(matchable.match(planet))
            {
                return planet;
            }
        }
        return null;
    }


    public List<Planet> getPlanetsListAsPlanets()
    {
        List<Planet> planets = new ArrayList<>();
        for (WebElement planet: driver.findElements(By.className("planet"))) {
            planets.add(new Planet(planet));

        }
        return planets;
    }




}
