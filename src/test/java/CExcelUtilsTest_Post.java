import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CExcelUtilsTest_Post {
    // BE SURE THAT YOU HAVE 3 GUESTS IN YOUR DB BECAUSE THIS CODE WILL ADD 4-5TH GUESS
    // open terminal and create connection :
    // cd node_modules
    // cd json-server
    // npx json-server --watch db.json
    //
    logger.Log log;
    /**
     * ExcelUtil constructor needs two parameter to create workbook and sheet
     * excelUtils has methods to get row count and to get cell data from that sheet
     * by getting these values, new guests' informations are put into request Json object
     * post each guest request to localhost
     * test whether each guests in excel is created or not
     */
    @Test
    public void test_postGuest_fromExcel(){
        log = new logger.Log();
        String excelPath = "/Users/simgesisman/Documents/git/HotelAPITest/src/test/java/utils/HotelGuestData.xlsx";
        String sheetName = "Sheet1";
        ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
        int rowCount = excelUtils.getRowCount();
        JSONObject request = new JSONObject();
        for(int i=1;i<rowCount;i++){
            for(int j=0;j<1;j++){
                Object name = excelUtils.getCellData(i,j);
                request.put("name",name);
                Object surname = excelUtils.getCellData(i,(j+1));
                request.put("surname",surname);
                Object roomId = excelUtils.getCellData(i,(j+2));
                request.put("roomId",roomId);
                Object startdate = excelUtils.getCellData(i,(j+3));
                request.put("start-date",startdate);
                Object enddate = excelUtils.getCellData(i,(j+4));
                request.put("end-date",enddate);
                baseURI = "http://localhost:3000/";
                given().contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        header("Content-Type","application/json").
                        body(request.toJSONString()).
                        when().post("/guests").
                        then().statusCode(201).log().all();
                log.info("new guest with name: "+name+" is posted from Excel to localhost");
            }
        }
    }
}
