package cricketapireqs;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class UsingHashMapBody {
	
//	int id;
	@Test(priority = 1)
   void PostReq() {
	   HashMap data = new HashMap();
	   data.put("name","Dhoni");
	   data.put("location","india");
	   data.put("phone","123456258");
	   String fitArr[]= {"YOYO","Running"};
	   data.put("fitness",fitArr);
	   
	       given()
	       .contentType("application/json")
	       .body(data)
	   .when()
	       .post("http://localhost:3000/cricket")
	     //  .jsonPath().getInt("id")
	       
	    .then()
	        .statusCode(201)
	        .body("name",equalTo("Dhoni"))
	        .body("location",equalTo("india"))
			.body("phone", equalTo("123456258"))
			.body("fitness[0]",equalTo("YOYO"))
			.body("fitness[1]",equalTo("Running"))
			.header("Content-type", "application/json; charset=utf-8")
			.log().all();
	
   }
}
