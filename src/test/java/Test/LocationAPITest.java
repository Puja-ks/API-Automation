package Test;
import Pojo.AddPlace;
import Pojo.Location;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.*;


public class LocationAPITest {
	
	public static void main(String[] args) {
	AddPlace p = new AddPlace();
	p.setAccuracy("50");
	p.setAddresss("67, prithvi layout,  99");
	p.setLanguage("French-IN");
	p.setPhone_numbe("(+91) 983 703 3937");
	p.setWebsite("https://rahulshettyacademy.com");
	p.setName("1st cross house");
	
	List<String> myList =new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	p.setTypes(myList);
	
	
	
	Location l =new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);

	p.setLocation(l);
	
	Response res = given().log().all().queryParam("key", "qaclick123")
	.body(p)
	.when().post("/maps/api/place/add/json").
	then().assertThat().statusCode(200).extract().response();

	String responseString = res.asString();
	System.out.println("\n" +responseString);
	
	
	}
	
			
}
