package cricketapireqs;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class UsingExternalJsonFile {
	//@Test
   void PostReq() throws FileNotFoundException {
		File f = new File("./cricket.json");
		FileReader fr = new FileReader(f);
		JSONTokener jk = new JSONTokener(fr);
		JSONObject jobj = new JSONObject(jk);
		 
	    
     		
	   given()
	       .contentType("application/json")
	       .body(jobj.toString())
	       
	   .when()
	       .post("http://localhost:3000/cricket")
	   .then()
	       .statusCode(201)
	       .body("name",equalTo("Virat"))
	       .body("location", equalTo("India"))
	       .body("phone", equalTo("1234569870"))
	       .log().all();
   }
   @Test
   public void getRes() {
	   given()
	   .when()
	     .get("http://localhost:3000/cricket")
	   .then()
	     .statusCode(200)
	     .log().all();
   }
  // @Test
   public void DeleteRes() {
	   given()
	   .when()
	      .delete("http://localhost:3000/cricket/2")
	   .then()
	    .statusCode(404)
	    .log().all();
   }
}
