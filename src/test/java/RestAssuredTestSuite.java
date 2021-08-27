
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class RestAssuredTestSuite {

    @Test
    public void ResponseTest(){
        given()
            .header("auth-key","3b534b7d-fb2b-4b35-abb8-0db403a47c70").param("q","Tascott").
                when().
                get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
                assertThat().statusCode(200);
    }

    @Test
    public void PostcodeTest(){
        given()
                .header("auth-key","3b534b7d-fb2b-4b35-abb8-0db403a47c70").param("q","Tascott").
                when().
                get("https://digitalapi.auspost.com.au/postcode/search.json").
                then().
                assertThat().body("localities.locality.postcode",equalTo(2250));


    }


}
