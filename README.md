# FakeRestfulAPI-HotelAPITest
API tests for fake restful api ; DataProvider and Excel datas are used

First install json-server, go to that folder and 
run npx json-server --watch db.json command in terminal

Fill that json file with guests and room informations :
Save that file and go to localhost:3000 and you should see that db.
We re ready to send methods and test api.

<img width="444" alt="Ekran Resmi 2022-09-14 23 26 53" src="https://user-images.githubusercontent.com/62858275/190255602-9cc8b678-59b3-4cbd-8917-a47bba0bf70c.png">

AFakeRestfulAPI is a test class to test each methods but each informations are given manually.
AFakeRestfulAPIDataTestDriven is a test class to test post and delete methods by using dataprovider. 
FakeRestfulAPIDataProvider class includes dataproviders for post delete methods.

ExcelUtil class is to get workbook and sheet from specific excel path. My excel is in the same folder.
Also it has methods to get row number and value from cell. 

CExcelUtilTest_Post test class uses ExcelUtil class and I initialize it with excel path name and sheetname for constructor. 
Then I get row numbers and in loop I used each cell value to put request. After I created request body, post it to localhost.
You should see new db with posted guests. 

DExcelUtilTest_Delete test class includes delete method and again I used dataProvider to delete last created ones.

