package testClass;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;

import commonFunction.API_Common_Function;
import commonFunction.Utility_Common_Functions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepository.Post_req_repository;

public class Post_tc_1
{
	public static void execute() throws IOException 
	{
		for(int i=0;i<5;i++)
		{
			
	    int res_statuscode=API_Common_Function.response_statusCode(Post_req_repository.base_URI(),Post_req_repository.post_resource(),Post_req_repository.post_req_tc1());
	    if( res_statuscode == 201 ) 
	    {
    	String res_responseBody=API_Common_Function.responseBody(Post_req_repository.base_URI(),Post_req_repository.post_resource(),Post_req_repository.post_req_tc1());	
	    Post_tc_1.validator(res_responseBody, res_statuscode);
	    Utility_Common_Functions.evedenceFileCreator("Post_tc_1",Post_req_repository.post_req_tc1(),res_responseBody);
	    break;
	    }
	    else
	    {
	    	System.out.println("Correct status code is not found hence retrying the API");
	    }
		}
		
	}		
		
	public static void validator(String res_responseBody,int res_statuscode) throws IOException 
	{
		//parse	the response body
		JsonPath jsp=new JsonPath(res_responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
	//	String res_id=jsp.getString("id");
	//	String res_createdAt=jsp.getString("createdAt");
		//System.out.println(res_name);
		System.out.println(res_name);
		System.out.println(res_job);
	//	System.out.println(res_id);
	//	System.out.println(res_createdAt);

		//request body
		JsonPath jspreq=new JsonPath(Post_req_repository.post_req_tc1());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
				//validate response body 
		Assert.assertEquals(res_statuscode,201);
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
//		Assert.assertNotNull(res_id,"15");
//		Assert.assertNotNull(res_createdAt,"2023-05-05T08:28:13.425Z");

	}
}







































































/*package testClassPackage;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import commonFunctionPackage.API_Common_Function;
import commonFunctionPackage.Utility_Common_Functions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_req_repository;

public class Post_tc_1
{
	public static void execute() throws IOException 
	{
		for(int i=0;i<5;i++)
	    {
			String baseURI=Post_req_repository.base_URI();
			String res_requestBody=Post_req_repository.post_req_tc1();
					
			String resource=Post_req_repository.post_resource();
			int res_statusCode=API_Common_Function.response_statusCode(baseURI, res_requestBody, resource);
			if(res_statusCode==201)
			{
				String res_responseBody=API_Common_Function.responseBody(baseURI, res_requestBody, resource);
			//System.out.println(responseBody);
			Post_tc_1.validator(res_responseBody, res_statusCode, res_requestBody);
			Utility_Common_Functions.evedenceFileCreator("Post_tc_1",Post_req_repository.post_req_tc1(),res_responseBody); 
				
			break;
			}
			else
			{
			
	    	System.out.println("Correct status code is not found hence retrying the API");
	    }
		}
		
	}		
		
	public static void validator(String res_responseBody,int res_statuscode,String res_requestBody) 
	{
		//parse	the response body
		JsonPath jsp=new JsonPath(res_responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
	//	String res_id=jsp.getString("id");
	//	String res_createdAt=jsp.getString("createdAt");
		//System.out.println(res_name);
		System.out.println(res_name);
		System.out.println(res_job);
	//	System.out.println(res_id);
	//	System.out.println(res_createdAt);
		//parse request body and its parameters
				JsonPath jspreq=new JsonPath (res_requestBody);
				String req_name=jspreq.getString("name");
				String req_job=jspreq.getString("job");
				
		//validate response body 
		Assert.assertEquals(res_statuscode,201);
		Assert.assertEquals(res_name,"morpheus");
		Assert.assertEquals(res_job,"leader");
//		Assert.assertNotNull(res_id,"15");
//		Assert.assertNotNull(res_createdAt,"2023-05-05T08:28:13.425Z");

	}
}*/