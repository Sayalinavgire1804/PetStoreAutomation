package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class DatadrivenTest {

@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostuser(String UserID,String UserName,String FirstName,String LastName,String Email,String Password,String Phone)
	{
	User userpayload=new User();
	userpayload.setId(Integer.parseInt(UserID));
	userpayload.setUsername(UserName);
	userpayload.setFirstName(FirstName);
	userpayload.setLastName(LastName);
	userpayload.setEmail(Email);
	userpayload.setPassword(Password);
	userpayload.setPhone(Phone);
	
	Response response =UserEndpoints.createuser(userpayload);
	Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}
@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)

public void testDeleteUserByName(String username)
{
	Response response=UserEndpoints.deleteuser(username);
	Assert.assertEquals(response.getStatusCode(), 200);
}
}
