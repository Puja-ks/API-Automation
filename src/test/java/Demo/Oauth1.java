package Demo;
	import static io.restassured.RestAssured.given;

	import java.util.ArrayList;

	import java.util.Arrays;

	import java.util.List;

import Pojo.Api;
import Pojo.Courses;
import Pojo.GetCourses;
import Pojo.Mobile;
import Pojo.WebAutomation;
import io.restassured.RestAssured;
	import io.restassured.parsing.Parser;

	import io.restassured.path.json.JsonPath;

	import io.restassured.response.Response;

	import io.restassured.response.ResponseBody;


	public class Oauth1{



	private static final Class GetCourses = null;

	public static void main(String[] args) throws InterruptedException {

	// TODO Auto-generated method stub

		RestAssured.baseURI ="https://rahulshettyacademy.com/";
		
	String response  =   given()
	                      .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	                        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	                        .formParams("grant_type", "client_credentials")
	                        .formParams("scope", "trust")
	                        .when().log().all()
	                        .post("/oauthapi/oauth2/resourceOwner/token").asString();

	System.out.println(response);

	JsonPath jsonPath = new JsonPath(response);

	    String accessToken = jsonPath.getString("access_token");

	    System.out.println(accessToken);

	    
	GetCourses r2=    
				given().queryParams("access_token", accessToken)
	            .when()
	            .get("/oauthapi/getCourseDetails")
	            .as(GetCourses.class);

	//System.out.println(r2);
	
	System.out.println("\n" +r2.getlinkedIn()+ "\n"  + r2.getInstructor()+ "\n" +r2.getServices());
	System.out.println(r2.getCourses().getApi().get(1).getCourseTitle());
	System.out.println(r2.getCourses().getMobile().get(0).getCourseTitle());
	System.out.println(r2.getCourses().getWebAutomation().get(2).getCourseTitle());

	//Get the course names of WebAutomation
	int sum = 0;
	System.out.println(r2.getCourses().getWebAutomation().size());
	List<WebAutomation> l = r2.getCourses().getWebAutomation();
	for(int i = 0 ; i<l.size() ;i++)
	{
		System.out.println(l.get(i).getCourseTitle());
		System.out.println("\r" +l.get(i).getPrice());
		sum = sum + Integer.parseInt(l.get(i).getPrice());
	}
	
	System.out.println("\n" +sum);
		
	
	
	// to get sum of all prices.
	List<Api> l1 = r2.getCourses().getApi();
	for(int i = 0 ; i<l1.size() ;i++)
	{
		System.out.println(l1.get(i).getCourseTitle());
		System.out.println("\r" +l1.get(i).getPrice());
		sum = sum + Integer.parseInt(l1.get(i).getPrice());
	}
	System.out.println("\n" +sum);
	
	sum = sum + Integer.parseInt(r2.getCourses().getMobile().get(0).getPrice());
	
	
	 System.out.println("\n" +sum);
	

	
	


	}

	}

	



