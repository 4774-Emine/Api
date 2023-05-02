package getRequest;

import baseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseURL {
       /*
        Given
            https://jsonplaceholder.typicode.com/users   --> resources farklı
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    Data uzunluğunun 10 olduğunu assert ediniz.

     */

    @Test
    public void get04() {
     /*
        1) Set URL
        2) Set Expected ata
        3) Send a Request
        4) assertion
         */

//Step 1:    https://jsonplaceholder.typicode.com/users  (parametre tanıtımı yapacağım)
        specification.pathParam("usersPath", "users");//(1 tane parametre olduğu için pathparam diyorum)

        //Step 2: Expected Data (ignore)

        //Step 3: Send Request
        Response response = given().
                spec(specification).
                when().
                get("/{usersPath}");

        response.prettyPrint();// like syso

        // Step 4: Assertion

        /*
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    Data uzunluğunun 10 olduğunu assert ediniz.
         */
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", Matchers.hasSize(10));//hasSize() 10 tane id olup plmadığına baktı


    }


}
