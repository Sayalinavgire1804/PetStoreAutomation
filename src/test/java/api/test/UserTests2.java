package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	Faker faker;
	User userpayload;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		//logs
		logger=LogManager.getLogger(this.getClass());
		logger.debug("debugging........");
	}
	@Test(priority=1)
	public void testPostuser()
	{
    logger.info("*************Creating user*************");
	Response response =UserEndpoints2.createuser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************User is created*************");
	}
	@Test(priority=2)
	public void testgettuser()
	{
	    logger.info("*************Reading User Info*************");

		//String user_name=userpayload.getUsername();
		Response response=UserEndpoints2.readeuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	    logger.info("*************User info is displayed*************");

		
	}
	@Test(priority=3)
	public void testupdatetuser()
	{
	    logger.info("*************User information updating*************");

		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		//String user_name=userpayload.getUsername();
		Response response=UserEndpoints2.updateuser( this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Response responseAfterupdate=UserEndpoints2.readeuser(this.userpayload.getUsername());
		responseAfterupdate.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	    logger.info("*************User information updated*************");

	}
	@Test(priority=4)

	public void testdeleteuser()
	{
	    logger.info("*************User information deleting*************");

		//String user_name=userpayload.getUsername();
		Response response=UserEndpoints2.deleteuser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	    logger.info("*************User information deleted*************");

	}
	}


