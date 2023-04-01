package requests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetHeaders {
	@Test(priority = 1)
   void Header() {
	   given()
	   .when()
	       .get("https://www.google.com/")
	       
	   .then()
	       .header("Content-Type", "text/html; charset=ISO-8859-1")
	       .header("Content-Encoding", "gzip")
	       .header("Server", "gws")
	       .log().body();
//	       .log().headers()
//	       .log().cookies();
	      // .log().all();
   } 
	
	//@Test(priority = 2)
	void HeaderAccess() {
		Response res = given()
		.when()
		   .get("https://www.google.com/");
		   String value = res.getHeader("Content-Type");
		System.out.println("Content-Type Header "+value);
		Headers myheaders = res.getHeaders();
		
		for(io.restassured.http.Header hd: myheaders ) {
			System.out.println(hd.getName()+"             "+hd.getValue());
		}
	
	}

}
