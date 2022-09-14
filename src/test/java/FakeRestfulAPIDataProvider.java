import org.testng.annotations.DataProvider;

public class FakeRestfulAPIDataProvider {
    /**
     * DataProvider helps to write data driven tests
     * Runs multiple time with set of data
     */
    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost(){
        return new Object[][]{
                {"Yigit","CAN",2,"09.04.2022","12.04.2022"},
                {"Sevim","CAN",2,"09.04.2022","12.04.2022"},
        };
    }
    @DataProvider(name = "DataForDelete")
    public Object[][] dataForDelete(){
        Object[][] data = new Object[2][1];
        data[0][0]=4;
        data[1][0]=5;
        return data;
    }
}
