package assinments;

	import static io.restassured.RestAssured.*;
	import org.testng.annotations.Test;
	import io.restassured.path.json.JsonPath;
	public class Assign2 {
	       @Test
			void get() {
				
String response=given()

			    .pathParam("mypath", "data")
				.queryParam("drilldowns", "Nation")
				.queryParam("measures", "Population")
				
		.when()
				.get("https://datausa.io/api/{mypath}")
				
		.then().extract().response().asString();
				System.out.println(response);
				JsonPath js=new JsonPath(response);
				String sourcename=js.getString("source[0].annotations.source_name");
				String sourcedescription=js.getString("source[0].annotations.source_description");
				System.out.println("This is source_name "+sourcename);
				System.out.println("This is source_description "+sourcedescription);
			}
		}






