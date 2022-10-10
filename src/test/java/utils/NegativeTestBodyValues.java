package utils;

public class NegativeTestBodyValues {
    public Object[] hotelPost = {"Simge", "ŞİŞMAN","1000","04.06.2022","04.07.2022","Breakfast"};

    public String HotelReservationBodyWithoutName = "{\n" +
            "    \"lastname\" : \"ŞİŞMAN\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-10-01\",\n" +
            "        \"checkout\" : \"2022-10-10\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    public String HotelReservationBodyWithoutLastName = "{\n" +
            "    \"name\" : \"Simge\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-10-01\",\n" +
            "        \"checkout\" : \"2022-10-10\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    public String HotelReservationBodyWithoutTotalPrice = "{\n" +
            "    \"name\" : \"Simge\",\n" +
            "    \"lastname\" : \"ŞİŞMAN\",\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-10-01\",\n" +
            "        \"checkout\" : \"2022-10-10\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    public String HotelReservationBodyWithoutDates= "{\n" +
            "    \"name\" : \"Simge\",\n" +
            "    \"lastname\" : \"ŞİŞMAN\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    public String HotelReservationBodyWithoutAdditionalNeeds = "{\n" +
            "    \"firstname\" : \"Simge\",\n" +
            "    \"lastname\" : \"ŞİŞMAN\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2022-10-01\",\n" +
            "        \"checkout\" : \"2022-10-10\"\n" +
            "    },\n" +
            "}";
}
