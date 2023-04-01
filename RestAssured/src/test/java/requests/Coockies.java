package requests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class Coockies {
	
	public void CoockiesTest1() {
		given()
		.when()
		   .get("https://www.google.com")
		   
		.then()
		 // .cookie("ACE","ARSKqsLPyk_BXLeMc8W5yDdO8AZ2aEYWLqQkb8g0YVynf42-1yxGvf_PaA")
		  .log().all();
	}
	
	@Test(priority = 1)
   public void CoockiesTest2() {
	   Response res = given()

	   .when()
	      .get("https://www.google.com/");
	   
	 String Coockie_value = res.getCookie("ACE");
	 System.out.println(Coockie_value);
	 
	 Map<String, String> coockieinfo = res.getCookies();
	 
	 for(String k:coockieinfo.keySet()) {
		 String values_Of_Coockie = res.getCookie(k);
		 System.out.println(values_Of_Coockie);
		 System.out.println(k);      //Coockies values
		 
	 }      
   }
	
}
