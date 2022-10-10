import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.NegativeTestBodyValues;

import static io.restassured.RestAssured.given;

public class FHotelReservationNegativeTesting extends NegativeTestBodyValues {
    @Test(priority = 1)
    public void NT_createBooking_withoutName(){
        given().contentType("application/json").
                body(HotelReservationBodyWithoutName).
                when().post("https://restful-booker.herokuapp.com/booking").
                then().log().all().
                statusCode(500);
    }
    @Test(priority = 2)
    public void NT_createBooking_withoutLastName(){
        given().contentType("application/json").
                body(HotelReservationBodyWithoutLastName).
                when().post("https://restful-booker.herokuapp.com/booking").
                then().log().all().
                statusCode(500);
    }
    @Test(priority = 3)
    public void NT_createBooking_withoutTotalPrice(){
        given().contentType("application/json").
                body(HotelReservationBodyWithoutTotalPrice).
                when().post("https://restful-booker.herokuapp.com/booking").
                then().log().all().
                statusCode(500);
    }
    @Test(priority = 3)
    public void NT_createBooking_withoutDates(){
        given().contentType("application/json").
                body(HotelReservationBodyWithoutDates).
                when().post("https://restful-booker.herokuapp.com/booking").
                then().log().all().
                statusCode(500);
    }
    // WHY THE RESPONSE İS DİFFERENT FROM OTHERS ? (AS 400)
    @Test(priority = 4)
    public void NT_createBooking_withoutAdditionalNeeds(){
        given().contentType("application/json").
                body(HotelReservationBodyWithoutAdditionalNeeds).
                when().post("https://restful-booker.herokuapp.com/booking").
                then().log().all().
                statusCode(400);
    }
    /**
     * Token is created with body which consists username and password
     * when it is created, it will be shown in terminal
     * test whether token is created without password or not
     */
    @Test(priority = 5)
    public void NT_createToken_withoutPassword(){
        String body1 = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "}";
        given().contentType("application/json").body(body1).
                when().post("https://restful-booker.herokuapp.com/auth").
                then().log().all().
                statusCode(400);
    }

    @Test(priority = 6)
    public void NT_createToken_withoutUsername(){
        String body1 = "{\n" +
                "    \"password\" : \"admin\",\n" +
                "}";
        given().contentType("application/json").body(body1).
                when().post("https://restful-booker.herokuapp.com/auth").
                then().log().all().
                statusCode(400);
    }
    @Test(priority = 6)
    public void NT_createToken_withoutBody(){
        String body = " ";
        given().contentType("application/json").body(body).
                when().post("https://restful-booker.herokuapp.com/auth").
                then().log().all().
                statusCode(400);
    }
    @Test(priority = 5)
    public void NT_getBookingIds_fromWrongURI(){
        given().get("https://restful-booker.herokuapp.com/bookingg").then().log().all().statusCode(404);
    }
    @Test(priority = 6)
    public void NT_updateData_withoutName(){
        given().contentType("application/json").
                header("Cookie","token=d37d30e7fa6ac37").
                body(HotelReservationBodyWithoutName).
                put("https://restful-booker.herokuapp.com/booking/127").then().statusCode(400);
    }
}
