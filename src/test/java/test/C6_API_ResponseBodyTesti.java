package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*; // yanina yildiz koydugumuz icin equalto yada lessthan vs hepsini kapsadi.

public class C6_API_ResponseBodyTesti {
    /*
    https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request gonderdigimizde
            {
            “title”:“API”,
            “body”:“API ogrenmek ne guzel”,
            “userId”:10,
            }
            donen Response’un,
            status code’unun 201,
            ve content type’inin application/json
            ve Response Body’sindeki,
                “title”’in “API” oldugunu
                “userId” degerinin 100’den kucuk oldugunu
                “body” nin “API” kelimesi icerdigini test edin.
     */
    @Test
    public void bodyTesti2(){

        // 1-Endpoint Hazırla
        String url="https://jsonplaceholder.typicode.com/posts";

        // 2-Soruda Expected Data verilseydi Expected Data bu adımda hazırlanacaktı.

        // 3- Response Kaydet
        // Response response=given().when().get(url);---> Get Methodunda

            /*
            {
            “title”:“API”,
            “body”:“API ogrenmek ne guzel”,
            “userId”:10,
            }
             */
        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString()).post(url);

        // 4-Assertion yap
        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title",equalTo("API"),
                        "body",containsString("API"),
                        "userId",lessThan(100));









    }

}