import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BFakeRestfulAPIDataTestDriven extends FakeRestfulAPIDataProvider{
    // BE SURE THAT YOU HAVE 3 GUESTS IN YOUR DB BECAUSE THIS CODE WILL ADD 4-5TH GUESS and they will be deleted
    // open terminal and create connection :
    // cd node_modules
    // cd json-server
    // npx json-server --watch db.json
    //
    logger.Log log;
    /**
     * dataProvider = "DataForPost" includes 2 new guests' informations
     * create JSONObject and put informations into that request object
     * give that request.toJSONString as body
     * and this test is to post that request to localhost
     */
    @Test(dataProvider = "DataForPost",priority = 1)
    public void test_postGuest(String name,String surname, int roomId, String sdate, String edate){
        log = new logger.Log();
        JSONObject request = new JSONObject();
        request.put("name",name);
        request.put("surname",surname);
        request.put("roomId",roomId);
        request.put("start-date",sdate);
        request.put("end-date",edate);
        baseURI = "http://localhost:3000/";
        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().post("/guests").
                then().statusCode(201).log().all();
        log.info("new guest with name: "+name+" is posted to localhost database: DATADRIVENTEST");
    }
    /**
     * dataProvider = "DataForDelete" includes 2 id numbers (4,5)
     * id integer comes from dataProvider
     * this test is to delete last created two new guests
     */
    @Test(dataProvider = "DataForDelete",priority = 2)
    public void test_deleteGuest(int id){
        log = new logger.Log();
        baseURI = "http://localhost:3000/";
        when().delete("/guests/"+id).
                then().statusCode(200);
        log.info("new posted data with id: "+id+ " is deleted from localhost db: DATADRIVENTEST");
    }
}
