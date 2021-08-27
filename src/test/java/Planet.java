import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;


public class Planet {

    public WebElement planetElement;

    public Planet (WebElement planet){
        this.planetElement = planet;
    }


    public String getName(){
        return planetElement.findElement(By.className("name")).getText();
    }

    public float getRadius() throws ParseException {

        String stringRadius = planetElement.findElement((By.className("radius"))).getText();
        return NumberFormat.getNumberInstance().parse(stringRadius.split(" ")[0]).floatValue();
    }


    public long getDistance() throws ParseException {
        String stringDistance = planetElement.findElement((By.className("distance"))).getText();
        return NumberFormat.getNumberInstance().parse(stringDistance.split(" ")[0]).longValue();
    }

}
