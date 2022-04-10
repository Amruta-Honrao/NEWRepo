package RestAssured_April10.RestAssured_April10;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClass {
	
	@DataProvider
	public Object[][] callexcel() throws IOException
	
		{
		ReadExcel obj3 = new ReadExcel();
		Object[][] arr1 = obj3.Fetchdata("Sheet1");
		return arr1;	
	}

@Test(dataProvider="callexcel")

public void APITest(String name, double id){
		
	RestAssured.basePath= "https://reqres.in/api/users";
	RequestSpecification Req = RestAssured.given();
	JSONObject jb = new JSONObject();
	jb.put(name, id);
	Req.header("Content-Type", "application/JSON");
	Req.body(jb.toJSONString());   ///Request attached to the body 
	Response Res = Req.post(RestAssured.basePath);
	Res.body().prettyPrint();
	System.out.println("Hello");
	
	
		}

}
