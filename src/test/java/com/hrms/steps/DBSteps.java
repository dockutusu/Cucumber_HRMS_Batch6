package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.DBUtils;
import com.hrms.utils.GlobalVariables;

import io.cucumber.java.en.When;

public class DBSteps {
	public static List<Map<String, String>> dbData;
	public static List<Map<String, String>> dbLastNameData;

	@When("get first name from db")
	public void get_first_name_from_db() {

		dbData = DBUtils.storeDateFromDB(
				"select emp_firstname from hs_hr_employees where employee_id=" + GlobalVariables.empID);

	}

	@When("get last name from db")
	public void get_last_name_from_db() {

		dbLastNameData = DBUtils
				.storeDateFromDB("select emp_lastname from hs_hr_employees where employee_id=" + GlobalVariables.empID);

	}

}
