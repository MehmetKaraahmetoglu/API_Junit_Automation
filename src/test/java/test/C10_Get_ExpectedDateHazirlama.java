package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C10_Get_ExpectedDateHazirlama {
     /*
 https://jsonplaceholder.typicode.com/posts/22 url'ine
 bir GET request yolladigimizda donen response body'sinin
 asagida verilen ile ayni oldugunu test ediniz

Response body :
 {
 "userId":3,
 "id":22,
 "title":"dolor sint quo a velit explicabo quia nam",
 "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
 }
  */

    @Test
    public void getExp(){
        // 1 - Endpint hazirlama
        String url ="https://jsonplaceholder.typicode.com/posts/22";

        // 2 - Expected data hazirlama
        JSONObject expBody = new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //System.out.println("expBody:" + expBody);

        // 3 - Response kaydetme islemi
        Response response = given().when().get(url); //dönen cevabin icindeki verileri inceleyebilmek icin
                                                     //bir JSONPath objesi icine dönen cevabi yerlestirdik.
        //ve testimizi birbirine denk objeler ile yapabildik.

        // 4 - Assertion islemi
        JsonPath respJP = response.jsonPath();
        Assert.assertEquals(expBody.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expBody.get("id"),respJP.get("id"));
        Assert.assertEquals(expBody.get("title"),respJP.get("title"));
        Assert.assertEquals(expBody.get("body"),respJP.get("body"));
    }
}
