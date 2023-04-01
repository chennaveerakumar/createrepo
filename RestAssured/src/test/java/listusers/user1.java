package listusers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
public class user1 {
	//https://reqres.in/api/users?page=2&id=5
	//@Test
     public void TestPathAndQueryParam1() {
    	given()
    	   .pathParam("myPath", "users")
    	   .queryParam("page", 2)
    	   .queryParam("id", 4)
    	 .when()
    	   .get("https://reqres.in/api/{myPath}")
    	 .then()
    	   .statusCode(200)
    	   .log().all();
    	 
     }
	//@Test(priority = 1)
	public void TestPathAndQueryParam2() {
		HashMap map = new HashMap();
		map.put("name", "Cvk");
		map.put("location", "Switzerland");
		map.put("phone", "125521125");
		
		String fit[] = {"Running","Jumping"};
		map.put("fitness",fit);
		
		given()
		  .contentType("application/json")
		  .body(map)
		
         .when()
		  .post("http://localhost:3000/cricket")
		  
		.then()
		  .statusCode(201)
		  .body("name",equalTo("Cvk"))
		  .body("location", equalTo("Switzerland"))
		  .body("phone", equalTo("125521125"))
		  .body("fitness[0]", equalTo("Running"))
		  .body("fitness[1]", equalTo("Jumping"))
		  
		  .log().all();
	}
	
	//http://localhost:3000/cricket
	@Test(priority = 1)
	public void getCvk() {
		Response res = given()
         .pathParam("myPath", "cricket")
        // .queryParam("name", "Cvk")
		.when()
		  .get("http://localhost:3000/{myPath}");
		  String id = res.jsonPath().get("id");
				  
		  System.out.println(id);
		  
		res.then()
		 .statusCode(200);
//		 .body("name",equalTo("Cvk"))
//		 .body("location", equalTo("Switzerland"))
//		 .body("phone", equalTo("125521125"));
		
	}
}
