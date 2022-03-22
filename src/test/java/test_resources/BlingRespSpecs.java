package test_resources;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;


public class BlingRespSpecs {

	//private static String[] serverHeader = {"server", "Apache/2.4.18 (Ubuntu)"};
	//private static ContentType contentType = ContentType.JSON;
	
	public static ResponseSpecification responseSpec(int statusCode)
	{
		// Create a generic ResponseSpecification that can be used for all Reqres API responses (and not just for CreateUserAPU)
		ResponseSpecification placeRespSpec =	new ResponseSpecBuilder()
													.expectStatusCode(statusCode)
													.build();
		
		return placeRespSpec;
	}
	
	public static Response applyRespSpec(Response response, int statusCode)
	{
		Response appliedResponse = response.then()
				 				   .spec(responseSpec(statusCode))//.body("scope", equalTo("OK"))
				 				   .extract().response();
		
		return appliedResponse;
	}
	
	public static long applyRespTimeSpec(Response response)
	{
		long appliedResponseTime = response.getTime();
		
		return appliedResponseTime;
	}
}
