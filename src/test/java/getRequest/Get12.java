package getRequest;

import baseURLs.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestCoApiPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends GoRestCoBaseURL {
         /*


        Given
            https://gorest.co.in/public/v2/users/702440
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

    {
    "id": 702440,
    "name": "Adheesh Chopra",
    "email": "adheesh_chopra@schamberger-langosh.biz",
    "gender": "male",
    "status": "active"
}
     */

    @Test
    public void get12() {


        //Step 1: Set URL
        //https://gorest.co.in/public/v2/users/702440
        specification.pathParams("usersPath","users",
                "idPath","702440");

        //Step 2: Set Expected Data
        //Expected dataları daha öncesinde java objelerine dönüştürmüştük
        //Şimdi farklı bir yol deniyoruz
        //Object Maper
        //Object mapper i kullanabilmek için maven projelerinde pom.xml dependency eklemem gerekiyor--->maven repodan
        String expectedData = "{\n" +
                "    \"id\": 702440,\n" +
                "    \"name\": \"Adheesh Chopra\",\n" +
                "    \"email\": \"adheesh_chopra@schamberger-langosh.biz\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        System.out.println("Expected Data: "+ expectedData);

        GoRestCoApiPojo goRestCoApiPojo = JsonToJava.convertJsonToJavaObject(expectedData, GoRestCoApiPojo.class);
        System.out.println("goRestCoApiPojo: " + goRestCoApiPojo);


        HashMap<String,Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap: " + expectedDataMap );



        //Step 3: Send Request
        //pathParams("usersPath","users",
        //               "idPath","724790");
        Response response = given().
                spec(specification).
                when().
                get("/{usersPath}/{idPath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();


        //Step 4: Assertion:

        HashMap<String,Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("Actual Data: " + actualDataMap);


        assertEquals(expectedDataMap.get("gender"),actualDataMap.get("gender"));
        assertEquals(expectedDataMap.get("name"),actualDataMap.get("name"));
        assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("email"),actualDataMap.get("email"));
        assertEquals(expectedDataMap.get("status"),actualDataMap.get("status"));


    }

}

