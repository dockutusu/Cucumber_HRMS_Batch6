package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {
	
		@Given("user navigates to AddEmployeePage")
		public void user_navigates_to_AddEmployeePage() {
			dashboard.navigateToAddEmployee();
		}
		@When("user enters employees first name and last name")
		public void user_enters_employees_first_name_and_last_name() {
			sendText(addEmp.firstName, "Atacan");
			sendText(addEmp.lastName, "Ata");
		}
		@When("user clicks save button")
		public void user_clicks_save_button() {
			click(addEmp.saveBtn);
		}
		@Then("employee is added successfully")
		public void employee_is_added_successfully() {
			String actual = pdetails.profilePic.getText();
			String expected = "Atacan Ata";
			Assert.assertEquals(expected, actual);
		}
		@When("user deletes employee id")
		public void user_deletes_employee_id() {
			addEmp.employeeId.clear();
		}
		@When("user clicks on create login checkbox")
		public void user_clicks_on_create_login_checkbox() {
			jsClick(addEmp.checkboxLoginDetails);
		}
		@When("user enters login credentials")
		public void user_enters_login_credentials() {
			addEmp.createEmpLoginCR();
		}
}
