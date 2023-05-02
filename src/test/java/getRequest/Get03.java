package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseURL {//BİRDEN FAZLA BASEURL İLE ÇALIŞMAM GEREKİRSE EXTEND EDEREK

/*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    title ın “quis ut nam facilis et officia qui” olduğunu verify et.,
		And
		    “completed” ın false olduğunu verify et.
		And
		    “userId” in 1 olduğunu verify et
     */

    /*
       {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }
    */


    @Test
    public void get03() {

      /*
       1) Set URL
       2) Set Expected Data
       3) Send a Request
       4) Assertion
        */

//Step 1: Set URL https://jsonplaceholder.typicode.com/todos/2
        specification.pathParams("todosPath", "todos", "idPath", "2");

//Step 2: Set the Expected data(ignore)

        //Step 3: Send Request---> Bir önceki derste requesti bu şekilde atmıştık
        //Response response=given().when().get();
        //Fakat şuan benim url im specification içinde olduğu için specificationu tanıtmam gerekecek
        //get() içerisine ise params ları tanıtmam gerekiyor
        Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");
        //Bundan sonra Java hangi url e request atacağını biliyor :)

        response.prettyPrint(); //like syso


        //Step 4: Assertion Operations
       /*
       Then
        Status Code un "200" olduğunu Assert et
       And
        Content Type ın "application/json" olduğunu assert et
       And
        title ın “quis ut nam facilis et officia qui” olduğunu verify et.,
       And
		    “completed” ın false olduğunu verify et.
       And
		    “userId” in 1 olduğunu verify et
      */



        //1.Yol

        /*
        response.then().assertThat().statusCode(200).contentType("application/json");

        //Bu saatten sonra yapacağımız iş body nin içine girmem lazım. 2 yoldan yapabiliriz

        response.then().
                assertThat().
                body("title", Matchers.equalTo("quis ut nam facilis et officia qui"),
             "completed",Matchers.equalTo(false) ,"userId",Matchers.equalTo(1));

*/


        //2.Yol
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("quis ut nam facilis et officia qui"),
                        "completed",equalTo(false) ,"userId",equalTo(1));
    }
}