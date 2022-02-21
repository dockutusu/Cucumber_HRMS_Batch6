package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewEmployeePageElements {

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;

	@FindBy(id = "empsearch_id")
	public WebElement empID;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")
	public List<WebElement> tableFirstName;

	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td[4]/a")
	public List<WebElement> tableLastName;

	@FindBy(id = "resultTable")
	public WebElement employeesTable;

	public boolean isTableDisplayed() {
		return employeesTable.isDisplayed();
	}

	public List<Map<String, String>> getFirstNameFromTable() {
		List<Map<String, String>> uiName = new ArrayList<>();
		for (WebElement row : tableFirstName) {
			Map<String, String> storeUiNames = new LinkedHashMap<>();
			storeUiNames.put("emp_firstname", row.getText());
			uiName.add(storeUiNames);
		}
		return uiName;
	}

	public List<Map<String, String>> getLastNameFromTable() {
		List<Map<String, String>> listMap = new ArrayList<>();
		for (WebElement rowLastName : tableLastName) {
			Map<String, String> storeLastName = new LinkedHashMap<>();
			storeLastName.put("emp_lastname", rowLastName.getText());
			listMap.add(storeLastName);
		}
		return listMap;
	}

	public ViewEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
