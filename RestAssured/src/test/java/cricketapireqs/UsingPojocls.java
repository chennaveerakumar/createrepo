package cricketapireqs;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import pojocls.CricketPojo;

public class UsingPojocls {
	
	Object id;
@Test
public void PostReq() {
	Random temp = new Random();
	int random = temp.nextInt(100);
	
     CricketPojo data = new CricketPojo();
	data.setName("Sachin"+random);
	data.setLocation("India");
	data.setPhone("123456"+random);
	String fit[]= {"YOYO","Wrist"};
	data.setFitness(fit);
	
	Response reponce = given()
	   .contentType(ContentType.JSON)
	   .body(data)
	.when()
	   .post("http://localhost:3000/cricket");
	    id=reponce.jsonPath().getInt("id");
	  // id = reponce.jsonPath().get("id");
	   System.out.println(id);
	reponce.then()
	   .statusCode(201)
	   .log().all()
	   .body("name",equalTo("Sachin"+random))
	   .body("location",equalTo("India"))
	   .body("phone", equalTo("123456"+random))
	   .body("fitness[0]",equalTo("YOYO"))
	   .body("fitness[1]",equalTo("Wrist"))
	   .header("Content-Type", "application/json; charset=utf-8")
	   .contentType(ContentType.JSON);
	 
//		given()
//		.pathParam("srcId", id)
//		.when()
//		  .delete("http://localhost:3000/cricket/{srcId}")
//		.then()
//		  .statusCode(200)
//		  .log().all();
	 
	  //System.out.println(res);
	  
     }

@Test(priority = 2)
public void DeleteReq() {
	given()
	.pathParam("srcId", id)
	.when()
	  .delete("http://localhost:3000/cricket/{srcId}")
	.then()
	  .statusCode(200)
	  .log().all();  
	
	
}
}
