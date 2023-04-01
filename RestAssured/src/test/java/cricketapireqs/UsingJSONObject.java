package cricketapireqs;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class UsingJSONObject {
  void PostReq() {
	 JSONObject jobj = new JSONObject();
	 jobj.put("name", "Smith");
	 jobj.put("location", "Aus");
	 jobj.put("phone", "1242536");
	 
	 String fit[]= {"Jumpping","Running"};
	 
	 jobj.put("fitness", fit);
	  given()
	     .contentType("application/json")
	     .body(jobj)
	  .when()
	      .post("http://localhost:3000/cricket")
	  .then()
	      .statusCode(201)
	      .body("name", equalTo("Smith"))
	      .body("location", equalTo("Aus"))
	      .body("phone", equalTo("1242536"))
	      .body("fitness[0]", equalTo("Jumpping"))
	      .body("fitness[1]", equalTo("Running"))
	      .log().all();
	  }
}
