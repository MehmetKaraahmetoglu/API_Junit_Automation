package testDatas;

import org.json.JSONObject;

public class TestDataJSONPlace {
    public int okStatusCode=200;
    public String contentType="application/json; charset=utf-8";
    public String connectionHeader ="keep-alive";


    public JSONObject expBodyOlusturJSON(){
        JSONObject expBody = new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBody;

    }

    public JSONObject reqBodyOlusturJSON(){
        /*
          Request Body

      {
      "title":"Ali",
      "body":"Merhaba",
      "userId":10,
      "id":70
      }
         */
        JSONObject expBody = new JSONObject();
        expBody.put("title","Ali");
        expBody.put("body","Merhaba");
        expBody.put("userId",10);
        expBody.put("id",70);

        return expBody;

    }
}
