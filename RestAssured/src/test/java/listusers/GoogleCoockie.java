package listusers;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GoogleCoockie {
	//@Test
   public void gooogleCoockie() {
	   given()

	   .when()
	      .get("https://www.google.com/")
	      
	   .then()
	       .statusCode(200)
	       .header("Content-Type", "text/html; charset=ISO-8859-1")
	       .header("Content-Encoding", "gzip")
	       .header("Server", "gws")
	      
	        .log().cookies();
	   //   .log().body()
	   //   .log().headers();
	   //   .log().all();
	   } 
	//@Test
	public void getHeader() {
		Response res = given()
		.when()
		   .get("https://www.google.com/");
		   String header = res.getHeader("Content-Type");
		   System.out.println("header "+header);
		   
		  
		  
	}
	@Test
	public void getHeaders() {
		Response res = given()
		.when()
		   .get("https://www.google.com/");
		   String header = res.getHeader("Content-Type");
		   Headers headersInfo = res.getHeaders();
		   for(Header hd:headersInfo) {
		   System.out.println(hd.getName()+" "+hd.getValue());
		   }
		  
	}
	
	
}
