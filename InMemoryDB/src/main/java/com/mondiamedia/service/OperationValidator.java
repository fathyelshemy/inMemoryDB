package com.mondiamedia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import com.mondiamedia.model.Employee;

public class OperationValidator {
	private EmployeeOperations empOperations= new EmployeeOperations();

	public Employee addValidation(String commandLine) {
		Employee employee=null;
		String[] splitedadd=new String[4];
		splitedadd=commandLine.split("\\-");
		boolean isNumber=NumberUtils.isNumber(splitedadd[0]);
		if(isNumber==true) {
			employee= new Employee();
			employee.setEmployee_id(Integer.valueOf(splitedadd[0]));
			employee.setEmployee_name(splitedadd[1]);
			employee.setDesignation(splitedadd[2]);
			employee.setSalary(Double.valueOf(splitedadd[3]));
			
			System.out.println(employee.toString());		
		}
		return employee;
	}
	
	public int delValidation(String commandLine) {
		int employeeId=0;
		boolean isNumber=NumberUtils.isNumber(commandLine);

		if(isNumber==true) {
			 employeeId=Integer.valueOf(commandLine);
			 return employeeId;
		}
		return employeeId;
	}
	
	public int printValidation(String commandLine) {
		int employeeId=0;
		boolean isNumber=NumberUtils.isNumber(commandLine);

		if(isNumber==true) {
			 employeeId=Integer.valueOf(commandLine);
			 return employeeId;
		}
		return employeeId;
	}
	
	public List<String>updateValidation(String commandLine){
		List<String>updateArguments=new ArrayList<>();
		String [] splitedUpdate=commandLine.split("\\-");
		EmployeeOperations empOperations=new EmployeeOperations();
		if(splitedUpdate.length==3) {
			boolean isNumber=NumberUtils.isNumber(splitedUpdate[0]);
			if(isNumber==true) {
				String employeeId=splitedUpdate[0];
				updateArguments.add(employeeId);
				String propertyName=splitedUpdate[1];
				updateArguments.add(propertyName);
				String propertyValue=splitedUpdate[2];
				updateArguments.add(propertyValue);
			}
			else {
				return updateArguments=null;
			}
		}
		return updateArguments;
	}

	public String printAll(String commandLine) {
		String sortType=null;
		if(commandLine.equalsIgnoreCase("ASC")) {
			sortType="ASC";
			return sortType;
		}else if(commandLine.equalsIgnoreCase("DESC")) {
			sortType="DESC";
			return sortType;
		}
		return sortType;
		
	}
	
	public  void createTableStructure() {
		
		empOperations.createDBStructure();

	}

}
