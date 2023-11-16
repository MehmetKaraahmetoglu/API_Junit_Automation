package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDatesPOJO {

      /*
     {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  }
     */

    private String checkin;
    private String checkout;
}
//@Data: Lombok kütüphanesinden gelir ve sınıfın temel metodlarını otomatik olarak oluşturur,
//        yani toString, equals, hashCode, getter ve setter metodlarını ekler.

//@NoArgsConstructor: Yine Lombok tarafından sağlanan bir özelliktir.
//                    Bu, sınıfa parametresiz bir constructor ekler.

//@AllArgsConstructor: Bu da Lombok'un bir özelliğidir ve sınıfa tüm alanları içeren bir constructor ekler.
