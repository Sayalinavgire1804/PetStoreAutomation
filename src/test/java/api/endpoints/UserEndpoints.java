package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//User enpoints .java created for perform crud operations
public class UserEndpoints {
	public static Response createuser(User payload)//payload -request body
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		  .post(Routes.post_url);
		return response;
		
		
		
	}
	
	public static Response readeuser(String username)//payload -request body
	{
		Response response=given()
		.pathParam("username", username)
		.when()
		  .get(Routes.get_url);
		return response;
		
		
		
	}
	
	public static Response updateuser(String username,User payload)//payload -request body
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("username", username)
		.when()
		  .put(Routes.update_url);
		return response;
		
		
		
	}
	public static Response deleteuser(String username)//payload -request body
	{
		Response response=given()
		
		.pathParam("username", username)
		.when()
		  .delete(Routes.delete_url);
		return response;
		
		
	}

}
