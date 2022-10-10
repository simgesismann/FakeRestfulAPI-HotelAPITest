import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.BodyValues;

import static io.restassured.RestAssured.given;

public class EFakeRestfulGetBody extends BodyValues {
    logger.Log log;
    /**
     *  npx json-server --watch db.json
     * in this test, I have body from BodyValues class
     * I could use that body because this class is extended from BodyValues
     * bodyValues is an Object type, To post many people I created in 2 dimensions
     * For "post" http call, I need JsonObject and then I will convert it to String
     */
    @Test(priority = 1)
    public void test_postGuest_getBody(){
        log = new logger.Log();
        JSONObject request = new JSONObject();
        for(int i=0;i<4;i++){
            request.put("name",bodyValues[i][0]);
            request.put("surname",bodyValues[i][1]);
            request.put("roomId",bodyValues[i][2]);
            request.put("start-date",bodyValues[i][3]);
            request.put("end-date",bodyValues[i][4]);
            given().contentType("application/json").
                    body(request.toJSONString()).
                    when().post( "http://localhost:3000/guests").
                    then().log().all().
                    statusCode(201);
            log.info("new data with name "+bodyValues[i][0]+" is created in db by getting body from another class");
        }
    }
}
