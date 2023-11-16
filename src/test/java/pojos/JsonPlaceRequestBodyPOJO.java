package pojos;

public class JsonPlaceRequestBodyPOJO {
    // 1) Tüm variable'lari Private olarak olusturalim
    /*
       Request Body

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    private String title;
    private String body;
    private int userId;
    private int id;

    // 2) Tüm variable'ler icin getter() ve setter() olusturalim

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // 3) Tüm parametreler icin constructor olusturalim
    public JsonPlaceRequestBodyPOJO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
    // 4) Default constructor olusturalim
    public JsonPlaceRequestBodyPOJO() {
    }

    // 5) toString() metodu olusturalim
    @Override
    public String toString() {
        return "JsonPlaceRequestBodyPOJO{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
