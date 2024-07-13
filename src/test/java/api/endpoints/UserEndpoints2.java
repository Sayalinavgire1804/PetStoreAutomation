package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//User enpoints .java created for perform crud operations
public class UserEndpoints2 {
	
	public static ResourceBundle geturl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("PropertiesFile");//load the properties file
		return routes;
		
	}
	public static Response createuser(User payload)//payload -request body
	{
		String post_url=geturl().getString("post_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		  .post(post_url);
		return response;
		
		
		
	}
	
	public static Response readeuser(String username)//payload -request body
	{
		String get_url=geturl().getString("get_url");
		Response response=given()
		.pathParam("username", username)
		.when()
		  .get(get_url);
		return response;
		
		
		
	}
	
	public static Response updateuser(String username,User payload)//payload -request body
	{
		String update_url=geturl().getString("update_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("username", username)
		.when()
		  .put(update_url);
		return response;
		
		
		
	}
	public static Response deleteuser(String username)//payload -request body
	{
		String delete_url=geturl().getString("delete_url");
		Response response=given()
		
		.pathParam("username", username)
		.when()
		  .delete(delete_url);
		return response;
		
		
	}

}
