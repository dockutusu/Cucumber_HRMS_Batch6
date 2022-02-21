package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;

import com.hrms.API.utils.PayloadConstants;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples {

	/**
	 * Rest Assured given - prepare your request when - you are making call to
	 * endPoint then - validating
	 * 
	 * @param args
	 */

	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU5MDQ1NjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTk0Nzc2OCwidXNlcklkIjoiODA3In0.EMjyGYJFW5qiBTF2DV6yquxqBZMJwGbNzCuXdYK-S0E";
	public static String employeeID;

	public void sampleTestNotes() {

		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16671A").log().all();
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
		getOneEmployeeResponse.prettyPrint();

		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	@Test
	public void aPOSTcreateEmployee() {

		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body("{\r\n" + 
						"  \"emp_firstname\": \"FNAME\",\r\n" + 
						"  \"emp_lastname\": \"LNAME\",\r\n" + 
						"  \"emp_middle_name\": \"MNAME\",\r\n" + 
						"  \"emp_gender\": \"M\",\r\n" + 
						"  \"emp_birthday\": \"1992-07-12\",\r\n" + 
						"  \"emp_status\": \"Employee\",\r\n" + 
						"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
						"}").log().all();
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		createEmployeeResponse.prettyPrint();
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		System.out.println(employeeID);

		createEmployeeResponse.then().assertThat().statusCode(201);
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("FNAME"));

		createEmployeeResponse.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
	}

	@Test
	public void bGETcreatedEmployee() {
		System.out.println(employeeID);
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		getCreatedEmployeeResponse.prettyPrint();

		String empID = getCreatedEmployeeResponse.jsonPath().getString("employee[0].employee_id");
		System.out.println(empID);

		boolean verifyingEmployeeIDsMatch = empID.equalsIgnoreCase(employeeID);
		Assert.assertTrue(verifyingEmployeeIDsMatch);

		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		String response = getCreatedEmployeeResponse.prettyPrint();

		
		//bu kon onemli- ise yarar bir kod
		JsonPath js = new JsonPath(response);

		String emplID = js.getString("employee[0].employee_id");
		System.out.println(emplID);

	}

	@Test
	public void cGETallEmployees() {
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).log().all();
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

	//	 String allEmployees = getAllEmployeesResponse.getBody().asString();
		 String allEmployees = getAllEmployeesResponse.jsonPath().toString();

	//	JsonPath allEmployees = getAllEmployeesResponse.jsonPath();
	//	int sizeOfEmp = allEmployees.getInt("Employees.size()");

		
		// System.out.println(allEmployees);

		// allEmployees.contains(employeeID);
		// allEmployees.matches(employeeID);

		JsonPath js = new JsonPath(allEmployees);

		int sizeOfEmp = js.getInt("Employees.size()");

		System.out.println(sizeOfEmp);

		/*
		 * this code also get the size of array (array of object of maps)
		 * List<Map<String, String>> list = js.getList("Employees");
		 * System.out.println(list.size());
		 * 
		 * 
		 */

		/*
		 * for (int i = 0; i < sizeOfEmp; i++) {
		 * 
		 * String empIDs = js.getString("Employees["+i+"].employee_id");
		 * 
		 * if (employeeID.contentEquals(empIDs)) {
		 * 
		 * System.out.println(js.getString("Employees["+i+"].emp_firstname")); break; }
		 * 
		 * 
		 * }
		 */

	}

	@Test
	public void dPUTupdateCreatedEmployee() {

		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstants.updateCreatedEmpBody());

		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
//		String response = updateCreatedEmployeeResponse.getBody().asString();
//		System.out.println(response);

		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		System.out.println(updateCreatedEmployeeResponse.jsonPath().getString("Message"));
		
		String empID = updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		Assert.assertTrue(empID.contentEquals(employeeID));
		System.out.println("passed");
	
	}
	
	@Test
	public void eGETUpdatedEmployee() {
	RequestSpecification getUpdatedEmployeeRequest =	given().header("Content-Type", "application/json").header("Authorization", token)
		.queryParam("employee_id", employeeID);
	
	Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
	//String updatedEmp = getUpdatedEmployeeResponse.getBody().asString();
	String updatedEmp = getUpdatedEmployeeResponse.jsonPath().toString();

	System.out.println(updatedEmp);
	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("Melek"));
	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo(employeeID));

	}
	
	@Test
	public void fPATCHEmployee () {
	RequestSpecification partiallyUpdatingEmployeeRequest =	given().header("Content-Type", "application/json").header("Authorization", token)
			.body("        {\r\n" + 
					"            \"employee_id\": \""+employeeID+"\",\r\n" + 
					"            \"emp_firstname\": \"Mehmet\"\r\n" + 
					"         \r\n" + 
					"        }");
	Response partiallyUpdatingEmployeeResponse = partiallyUpdatingEmployeeRequest.when().patch("/updatePartialEmplyeesDetails.php");
	partiallyUpdatingEmployeeResponse.prettyPrint();
	partiallyUpdatingEmployeeResponse.then().assertThat().statusCode(201);
	partiallyUpdatingEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
	
	}
	
	@Test 
	public void gDELETEemployee(){
		RequestSpecification deleteEmployeeRequest =	given().header("Content-Type", "application/json").header("Authorization", token)
				.queryParam("employee_id", employeeID);
		
	Response deleteEmployeeResponse =	deleteEmployeeRequest.when().delete("/deleteEmployee.php");
	deleteEmployeeResponse.prettyPrint();
	 deleteEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
	 System.out.println("deleted");
		
		
	}

}
