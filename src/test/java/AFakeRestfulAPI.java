import io.restassured.http.ContentType;
import logger.Log;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.* ;

public class AFakeRestfulAPI {
    // BE SURE THAT YOU HAVE 3 GUESTS IN YOUR DB BECAUSE THIS CODE WILL ADD 4TH GUESS
    // open terminal and create connection :
    // cd node_modules
    // cd json-server
    // npx json-server --watch db.json
    //
    logger.Log log;
    /**
     * Get all guests from localhost:300
     * Test whether statusCode is 200 or not
     */
    @Test(priority = 1)
    public void test_getGuests(){
        log = new Log();
        baseURI = "http://localhost:3000/";
        given().get("/guests").then().log().all().statusCode(200);
        log.info("guests are listed from localhost");
    }
    /**
     * Get guests which has roomId parameter as 3
     * Test whether statusCode is 200 or not
     */
    @Test(priority = 2)
    public void test_getGuestsWithQueryParamRoomId(){
        log = new Log();
        baseURI = "http://localhost:3000/";
        given().
                param("roomId",3).
                get("/guests").
                then().log().all().
                statusCode(200);
        log.info("guests are listed with query parameter of roomId");
    }
    /**
     * Create new JSONObject and put all parameter values
     * Post new guest with all parameter
     * Test whether statusCode is 201 or not
     */
    @Test(priority = 3)
    public void test_postGuest(){
        log = new Log();
        JSONObject request = new JSONObject();
        request.put("name","Sevgi");
        request.put("surname","YASAR");
        request.put("roomId",2);
        request.put("start-date","04.06.2022");
        request.put("end-date","10.06.2022");

        baseURI = "http://localhost:3000/";
        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().post("/guests").
                then().statusCode(201).log().all();
        log.info("new guest is posted to localhost database");
    }
    /**
     * Create new JSONObject and put all parameter values
     * PUT method is used to update informations for data
     * It needs all parameter whether all of it changed or not
     * Put new parameter values in data
     * Test whether statusCode is 200 or not
     */
    @Test(priority = 4)
    public void test_putGuest(){
        log = new Log();
        JSONObject request = new JSONObject();
        request.put("name","Sevgi");
        request.put("surname","YASAR");
        request.put("roomId",1);
        request.put("start-date","10.06.2022");
        request.put("end-date","17.06.2022");

        baseURI = "http://localhost:3000/";
        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().put("/guests/4").
                then().statusCode(200).log().all();
        log.info("new posted data is updated by put method");
    }
    /**
     * Create new JSONObject and put parameter which you want to change it
     * PATCH method is used to update informations for data
     * It needs parameter to change but you dont have to give all parameter into body
     * Put new parameter values in data
     * Test whether statusCode is 200 or not
     */
    @Test(priority = 5)
    public void test_patchGuest(){
        log = new Log();
        JSONObject request = new JSONObject();
        request.put("start-date","16.07.2022");
        request.put("end-date","22.07.2022");
        baseURI = "http://localhost:3000/";
        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().patch("/guests/4").
                then().statusCode(200).log().all();
        log.info("new posted data's dates are updated by patch method");
    }
    /**
     * Delete method is used to delete data which is given in URI
     * Test whether status code is 200 or not
     */
    @Test(priority = 6)
    public void test_deleteGuest(){
        log = new Log();
        baseURI = "http://localhost:3000/";
        when().delete("/guests/4").
                then().statusCode(200);
        log.info("new posted data is deleted from localhost db");
    }
}
