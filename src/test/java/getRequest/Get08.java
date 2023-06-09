package getRequest;

import baseURLs.SwapiApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.expect;
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
        //Burada expected dataları bir map içerisine dolduracağım.
        //Trick 1---> Her zaman içeriden başlayın yani expected map içerisinde önce films leri liste atarak başlayalım
        List<String> filmsList = new ArrayList<>();
        filmsList.add("https://swapi.dev/api/films/1/");
        filmsList.add("https://swapi.dev/api/films/5/");

        List<String> pilotsList = new ArrayList<>();
        System.out.println(pilotsList);

        //Listler dışında tüm veriler String olarak key ve value şeklinde,bir tane map create edelim
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("name","Sand Crawler");
        expectedDataMap.put("model","Digger Crawler");
        expectedDataMap.put("manufacturer","Corellia Mining Corporation");
        expectedDataMap.put("length","36.8 ");
        expectedDataMap.put("max_atmosphering_speed","30");
        expectedDataMap.put("crew","46");
        expectedDataMap.put("cost_in_credits","150000");
        expectedDataMap.put("passengers","30");
        expectedDataMap.put("cargo_capacity","50000");
        expectedDataMap.put("consumables","2 months");
        expectedDataMap.put("vehicle_class","wheeled");
        expectedDataMap.put("pilots",pilotsList);
        expectedDataMap.put("films",filmsList);
        expectedDataMap.put("created","2014-12-10T15:36:25.724000Z");
        expectedDataMap.put("edited","2014-12-20T21:30:21.661000Z");
        expectedDataMap.put("url","https://swapi.dev/api/vehicles/4/");
        System.out.println("Expected Data:" + expectedDataMap);


        //Step 3: Send Request
        Response response=given().spec(specification).when().get("/{vehiclesPath}/{idPath}");

        System.out.println("Response : ");
        response.prettyPrint();

        //Step 4:Assertion operations
       /*

       1.Way

       response.then().assertThat().statusCode(200).
                body("name",equalTo(expectedDataMap.get("name")),
                        "model",equalTo(expectedDataMap.get("model")),
                        "manufacturer",equalTo(expectedDataMap.get("manufacturer")),
                        "length",equalTo(expectedDataMap.get("length")),
                        "max_atmosphering_speed",equalTo(expectedDataMap.get("max_atmosphering_speed")),
                        "crew",equalTo(expectedDataMap.get("crew")),
                        "cost_in_credits",equalTo(expectedDataMap.get("cost_in_credits")),
                        "passengers",equalTo(expectedDataMap.get("passengers")),
                        "cargo_capacity",equalTo(expectedDataMap.get("cargo_capacity")),
                        "films",equalTo(expectedDataMap.get("films")),
                        "pilots",equalTo(expectedDataMap.get("pilots")));

*/

        //2.Way
        //Bu yolda bu bu defa response dan gelen dataları map içerisine atcağız
        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("Actual Data:"+actualData);
/*
Bu yönteme GSON diyoruz.--->Deserializaiton
Deserializaiton-->Json objesini JAVA objesine convert etmek(çevirmek) demektir.Bunu yapabilmek için pom.xml e
dependency ekledik bunu da maven repo dan aldık

 */
assertEquals(expectedDataMap.get("name"),actualData.get("name"));//hard essertion
assertEquals(expectedDataMap.get("max_atmosphering_speed"),actualData.get("max_atmosphering_speed"));
assertEquals(expectedDataMap.get("films"),actualData.get("films"));
assertEquals(expectedDataMap.get("passengers"),actualData.get("passengers"));
assertEquals(expectedDataMap.get("model"),actualData.get("model"));
assertEquals(expectedDataMap.get("pilots"),actualData.get("pilots"));
assertEquals(expectedDataMap.get("url"),actualData.get("url"));
assertEquals(expectedDataMap.get("model"),actualData.get("model"));

//3.yol
        assertEquals(expectedDataMap,actualData);

//HOMEWORKS
        /*
        jSONpATH ---->Softassert kullanark çözümünü yapınız
         */
    }


}
