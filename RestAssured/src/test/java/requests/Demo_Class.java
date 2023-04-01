package requests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Demo_Class {
	int id;
	
	Demo_Class(){}
@Test(priority = 1)
 void getUsers() {
	given()
	.when()
	   .get("https://reqres.in/api/users?page=2")
	.then()
	   .statusCode(200)
	  .log().all();
}
@Test(priority = 2)
  void createUser() {
	  HashMap<String, String> map = new HashMap<String, String>();
	  map.put("name","Smith");
	  map.put("job","King");	  
	  id=given()
	     .contentType("application/json")
	     .body(map)
	  .when()
	     .post("https://reqres.in/api/users")
	     .jsonPath().getInt("id");
//	  .then()
//	  
//	    .statusCode(201)
//	     .log().all();
  }
 @Test(priority = 3,dependsOnMethods = {"createUser"})
   void updateUser() {
	  HashMap<String, String> map = new HashMap<String, String>();
	  map.put("name", "Virat");
	  map.put("job", "King");
	  given()
	  .contentType("application/json")
	  .body(map)
	  .when()
	    .put("https://reqres.in/api/users/"+id)
	   .then()
	   	.statusCode(200)
	   	.log().all();
}	
 @Test(priority =4)
 void deleteUser() {
	 given()
	 .when()
	   .delete("https://reqres.in/api/users/"+id)
	 .then()
	  .statusCode(204)
	  .log().all();
 }

}




























