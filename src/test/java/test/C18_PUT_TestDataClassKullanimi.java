package test;

import baseUrl.jsonPlaceBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJSONPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_PUT_TestDataClassKullanimi extends jsonPlaceBaseUrl {
    /*
  https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip bir PUT
  request yolladigimizda donen response'in
  status kodunun 200, content type'inin "application/json; charset=utf-8",
  Connection header degerinin "keep-alive"
  ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

  Request Body

      {
      "title":"Ali",
      "body":"Merhaba",
      "userId":10,
      "id":70
      }

  Expected Data

      {
      "title":"Ali",
      "body":"Merhaba",
      "userId":10,
      "id":70
      }
*/
    @Test
    public void put01() {
        specJsonPlace.pathParams("pp1", "posts", "pp2", 70); // endpoint hazir

        TestDataJSONPlace testDataJSONPlace = new TestDataJSONPlace();
        JSONObject reqBody = testDataJSONPlace.reqBodyOlusturJSON();

        //Expected Data
        JSONObject expdata= testDataJSONPlace.reqBodyOlusturJSON();

        //Response Kaydi
        Response response = given()
                        .spec(specJsonPlace)
                        .contentType(ContentType.JSON)
                    .when()
                        .body(reqBody.toString())
                        .put("/{pp1}/{pp2}");

        //Assertion Islemi
        JsonPath respJP = response.jsonPath();
        response.prettyPeek(); //tüm headeri getirir
        System.out.println(response.getHeader("Connection")); //connection keyi ile connection'in value sunu yazdirdik

        assertEquals(testDataJSONPlace.okStatusCode,response.getStatusCode());
        assertEquals(testDataJSONPlace.contentType,response.getContentType());
        assertEquals(testDataJSONPlace.connectionHeader,response.getHeader("Connection"));
        assertEquals(expdata.get("title"),respJP.get("title"));
        assertEquals(expdata.get("body"),respJP.get("body"));
        assertEquals(expdata.get("userId"),respJP.get("userId"));
        assertEquals(expdata.get("id"),respJP.get("id"));




    }
}
