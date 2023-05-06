package getRequest;

import baseURLs.SwapiApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get08 extends SwapiApiBaseURL {


    /*

Given
            https://swapi.dev/api/vehicles/4
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
         Status Code un "200" olduğunu Assert et
    And
         Response body nin bu şekilde olduğunu doğrular
{
"name": "Sand Crawler",
"model": "Digger Crawler",
"manufacturer": "Corellia Mining Corporation",
"cost_in_credits": "150000",
"length": "36.8 ",
"max_atmosphering_speed": "30",
"crew": "46",
"passengers": "30",
"cargo_capacity": "50000",
"consumables": "2 months",
"vehicle_class": "wheeled",
"pilots": [],
"films": [
    "https://swapi.dev/api/films/1/",
    "https://swapi.dev/api/films/5/"
],
"created": "2014-12-10T15:36:25.724000Z",
"edited": "2014-12-20T21:30:21.661000Z",
"url": "https://swapi.dev/api/vehicles/4/"
}


 */
    @Test
    public void get08() {
/*
1)Set URL
2)Set Expected Data
3)Send a Request
4)Assertion
 */

        //Step 1: Set URL
        //https://swapi.dev/api/vehicles/4
        specification.pathParams("vehiclesPath", "vehicles", "idPath", "4");//query parametre olmadığı  için qery parameter kullanmamam gerek yok

       //Step 2:Set Expected Data(Test Case den alıyoruz)



    }


}
