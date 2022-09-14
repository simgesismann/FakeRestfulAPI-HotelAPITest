import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class DExcelUtilsTest_Delete extends FakeRestfulAPIDataProvider{
    // BE SURE THAT YOU HAVE 3 GUESTS IN YOUR DB BECAUSE THIS CODE WILL delete 4-5TH GUESS
    // open terminal and create connection :
    // cd node_modules
    // cd json-server
    // npx json-server --watch db.json
    //
    /**
     * Lastly new guests are added according to excel
     * Excel has two guests' informations and dataProvider = DataForDelete has two integer (4,5)
     * Test whether last created 4,5th guests are deleted from localhost or not.
     */
    logger.Log log;
    @Test(dataProvider = "DataForDelete")
    public void test_deleteGuest_fromExcel(int id){
        log = new logger.Log();
        baseURI = "http://localhost:3000/";
        when().delete("/guests/"+id).
                then().statusCode(200);
        log.info("new posted data from excel with id: "+id+ " is deleted from localhost db: DATADRIVENTEST");
    }
}

