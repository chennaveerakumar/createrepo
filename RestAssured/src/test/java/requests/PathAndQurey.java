package requests;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PathAndQurey {
	
	
	@Test
  void PathAndQueryParameter() {
	  given()
	    .pathParam("mypath", "users")
	    .queryParam("page", 2)
	    .queryParam("id", 5)
	  .when()
	    .get("https://reqres.in/api/{mypath}")
	  .then()
	    .statusCode(200)
	    .log().all();
  }
}
