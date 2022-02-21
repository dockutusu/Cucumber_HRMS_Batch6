package com.hrms.API.utils;

import org.json.JSONObject;

import com.hrms.API.steps.practice.HardcodedExamples;

public class PayloadConstants {

	public static String updateCreatedEmpBody() {

		String updateBody = "{\r\n" + "\r\n" + "\"employee_id\": \"" + HardcodedExamples.employeeID + "\",\r\n"
				+ "  \"emp_firstname\": \"Melek\",\r\n" + "  \"emp_lastname\": \"UpdatedLastName\",\r\n"
				+ "  \"emp_middle_name\": \"UpdatedMiddleName\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
				+ "  \"emp_birthday\": \"1996-07-12\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
				+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}";

		return updateBody;
	}

	public static String createEmployeePayload() {
		JSONObject obj = new JSONObject();

		obj.put("emp_firstname", "FNAME");
		obj.put("emp_lastname", "LNAME");
		obj.put("emp_middle_name", "MNAME");
		obj.put("emp_gender", "M");
		obj.put("emp_birthday", "1992-07-12");
		obj.put("emp_status", "Employee");
		obj.put("emp_job_title", "Cloud Architect");

		return obj.toString();

	}

	public static String createEmployeeBody() {

		String createEmployeeBody = "{\r\n" + "  \"emp_firstname\": \"FNAME\",\r\n"
				+ "  \"emp_lastname\": \"LNAME\",\r\n" + "  \"emp_middle_name\": \"MNAME\",\r\n"
				+ "  \"emp_gender\": \"M\",\r\n" + "  \"emp_birthday\": \"1992-07-12\",\r\n"
				+ "  \"emp_status\": \"Employee\",\r\n" + "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}";

		return createEmployeeBody;
	}

}
