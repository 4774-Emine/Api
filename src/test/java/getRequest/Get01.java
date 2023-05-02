package getRequest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;

public class Get01 {

    /*
  Bizler bu zamana kadar  sizler ile birlikte POSTMAN üzerinde farklı doc. sahip olan çeşitli api lere request attık.
  Req atarken HTTP methodlarında GET, POST, PATCH, nad DELETE methodlarını kullandık.

  Bizler markette genel olarak POSTMAN ı bir otomasyon tool değil manuel test toolu olarak kullanıyoruz. Fakat dersler de işlediğimiz üzere POSTMAN ile
  test otomasytonu yapabiliyoruz.

  Api testlerimiz bundan sonra RestAssured Lib. kullanarak yapacağız.

  Testleri yapabiliyor olmak için sizlerin bir doc. ihtiyacı vardır.
  Biz test eng. bu doc. göre API leri nasıl kullanacağımız veya nasıl test edeceğimizi öğreniriz.

  Ve doc.lara göre çeşitli senaryolar oluşturabiliriz. Tıpkı ne gibi?
  Selenium Web UI testleri koıştuğumuz gibi.

  Test Case:
  --> Expected Result

  -->Actual Result  ====>>>>  Responseden alacağım.

  Given ---> Testin yapılabilmesi içiin ön hazırlık/ön şart
  When ---> Action --> Gerçekleştirilecek eylemler
  Then --> Assertion için kullanıyoruz.
  And --> Öncesinde kullanılan keywordu etkisinin hala devam ettiğini bizlere gösterir.

    */


/*
    Given
        https://restful-booker.herokuapp.com/booking/781
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.

     */

    @Test  //main method gibi
    public void get() {

        /*
        4 tane adımımız var:
        1)URL İ tanımlamam lazım
        2)Expected dataları tanımlamam lazım.Expected datalrı set etmem lazım.Expected datalar test case den alınır.
        Doc dan alınır.(Şuan için bu step ignore edilecektir.)
        3)Request gönder
        4)Assertion işlemi

         */

        //Step 1: URL i set ediniz(https://restful-booker.herokuapp.com/booking/781)
        String URL = " https://restful-booker.herokuapp.com/booking/781";


        //Step 2:Expected dataları set et.(İgnore edilmiştir)

        //Step3: Request gönder
        Response response = given().when().get(URL);

        System.out.println("RESPONSE");
        response.prettyPrint();// -->prettyPrint() sout gibidir.

        //Step 4: Assertion işlemleri

       /* Then
        Status Code un "200" olduğunu Assert et
                And
        Content Type ın "application/json" olduğunu assert et
        And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.*/

//Test 1: status code ===>200
        response.then().assertThat().statusCode(200);//  Doc test case den alındı


        //Test 2: Content Type
        response.then().assertThat().contentType("application/json");

        //Test 3: Status line
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");



        //STATUS CODE U CONSOLA NASIL YAZDIRLIR
        System.out.println("Status code:" + response.getStatusCode());

        //Content Type  CONSOLA NASIL YAZDIRLIR
        System.out.println("Content Type:" + response.getContentType());

        //Status Line CONSOLA NASIL YAZDIRLIR
        System.out.println("Status Line:" + response.getStatusLine());

        //Response Time CONSOLA NASIL YAZDIRLIR
        System.out.println("Response Time: "+ response.getTime());

        //Headers leri consola nasıl yazdırabilrim
        System.out.println("Headers: "+ response.getHeaders());


    }
}