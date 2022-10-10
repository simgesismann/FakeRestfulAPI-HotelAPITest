import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
public class HotelReservationAPI {
    /**
     * Token is created with body
     * when it is created, it will be shown in terminal
     * test whether token is created or not
     */
    @Test(priority = 1)
    public void createToken(){
        String body1 = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        given().contentType("application/json").body(body1).
                when().post("https://restful-booker.herokuapp.com/auth").
                then().log().all().
                statusCode(200);
        // token = ab7fac73296bc2e
    }
    /**
     * This test will give all bookingId numbers which are created in that URI
     */
    @Test(priority = 2)
    public void getBookingIds(){
        given().get("https://restful-booker.herokuapp.com/booking").then().
                log().all().statusCode(200);
    }
    /**
     * Create body in JSON type which inludes all parameter and values
     * post that request with body
     * test whether this body is posted or not
     */
    @Test(priority = 3)
    public void createBooking(){
        String body2 = "{\n" +
                "    \"firstname\" : \"Simge\",\n" +
                "    \"lastname\" : \"ŞİŞMAN\",\n" +
                "    \"totalprice\" : 1000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-10-01\",\n" +
                "        \"checkout\" : \"2022-10-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        given().contentType("application/json").
                body(body2).
                when().post("https://restful-booker.herokuapp.com/booking").
                then().log().all().
                statusCode(200);
    }
    /**
     * Partial update is done with patch method
     * create partial Body which will be updated it doesnt have to be type as original body
     * test whether original data is updated with specific informations or not
     */
    @Test(priority = 4)
    public void partialUpdateBooking(){
        String partialBody = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";
        given().contentType("application/json").
                header("Cookie","token=d37d30e7fa6ac37").
                body(partialBody).
                patch("https://restful-booker.herokuapp.com/booking/127").
                then().statusCode(200);
    }
    /**
     * Totally update is done with put method
     * create Body which will be updated, it has to be same type as original
     * test whether original data is updated or not
     */
    @Test(priority = 5)
    public void updateBooking(){
        String body3 = "{\n" +
                "    \"firstname\" : \"Simge\",\n" +
                "    \"lastname\" : \"ŞİŞMAN\",\n" +
                "    \"totalprice\" : 2000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-10-01\",\n" +
                "        \"checkout\" : \"2022-10-20\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        given().contentType("application/json").
                header("Cookie","token=d37d30e7fa6ac37").
                body(body3).
                put("https://restful-booker.herokuapp.com/booking/127").
                then().statusCode(200);
    }
    /**
     * delete method is used to delete data from URI
     * test whether data is deleted or not
     */
    @Test(priority = 6)
    public void deleteCreatedBooking(){
        given().contentType("application/json").
                header("Cookie","token=d37d30e7fa6ac37").
                delete("https://restful-booker.herokuapp.com/booking/127").
                then().statusCode(201);
    }
}
