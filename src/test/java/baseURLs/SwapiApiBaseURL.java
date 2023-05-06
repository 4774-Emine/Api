package baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.Before;

public class SwapiApiBaseURL {
    //Base URL--->https://swapi.dev/api
    protected RequestSpecification specification;

@Before
    public void  setUpBaseURL(){
    specification=new RequestSpecBuilder().setBaseUri("https://swapi.dev/api").build();
}

}
