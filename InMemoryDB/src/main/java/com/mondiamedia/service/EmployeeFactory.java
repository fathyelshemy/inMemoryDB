package com.mondiamedia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import com.mondiamedia.model.Employee;

public class EmployeeFactory {
	
	private EmployeeOperations empOperations= new EmployeeOperations();
	private OperationValidator validate= new OperationValidator();
	public void operationsFactoryMethod(String commandLine) {
		
		if(commandLine.startsWith("add")) {
			
			commandLine = commandLine.replace("add ", "");
			
			addOperation(commandLine);
			
		}else if(commandLine.startsWith("update")){
			
			commandLine=commandLine.replace("update ", "");
			
			updateOperation(commandLine);
			
		}else if(commandLine.startsWith("del")) {
			
			commandLine=commandLine.replace("del ", "");
			
			delOperation(commandLine);
			
		}else if(commandLine.startsWith("print ")) {
			
			commandLine=commandLine.replace("print ", "");
			 printOperation(commandLine);
						
		}else if(commandLine.startsWith("printall")) {
			commandLine=commandLine.replace("printall ", "");
			ptintAllOperation(commandLine);
			
		}else if(commandLine.startsWith("quit")||commandLine.startsWith("Quit")) {
			System.exit(0);
		}else {
			System.out.println("please insert valid operation");
		}
		
	}
	
	
	public void addOperation(String  commandLine){
		Employee emp = validate.addValidation(commandLine);
		if (emp.equals(null)) {
			System.out.println("failed to add employee");
		} else {
			boolean addflag = empOperations.addEmployee(emp);
			if (addflag == true) {
				System.out.println("Employee '" + emp.getEmployee_name()
						+ "' added successfully. Total no of employees = " + empOperations.employeesCounter());
			} else {
				System.out.println("faild to add new employee");
			}
		}
		
	}
	
	
	public void updateOperation(String  commandLine){
		ArrayList<String> updateArguments=(ArrayList<String>)validate.updateValidation(commandLine);
		if(updateArguments.size()==3) {
			Employee employee=empOperations.updateEmployee(Integer.valueOf(updateArguments.get(0)), updateArguments.get(1), updateArguments.get(2));
			System.out.println("Employee '"+employee.getEmployee_id()+"' updated. "
					+ "Name: "+employee.getEmployee_name()+", Designation: "+employee.getDesignation()+", Salary: "
					+employee.getSalary());
			
		}else {
			System.out.println("can't update employee ");
		}
	}
	
	public void delOperation(String  commandLine){
		int employeeId=validate.delValidation(commandLine);
		if(employeeId!=0) {
			if(empOperations.delEmployee(employeeId)==true) {
				System.out.println("Employee '"+employeeId+"' deleted successfuly");
			}else {
				System.out.println("Employee '"+commandLine+"' not found");
			}
		}else {
			System.out.println("Employee '"+commandLine+"' not found");
		}
	}
	public void printOperation(String  commandLine){
		int employeeId=validate.printValidation(commandLine);
		if(employeeId!=0) {
			Employee employee=empOperations.findEmployee(employeeId);
			System.out.println(employee.getEmployee_name()+","+employee.getDesignation()+", salary:"+employee.getSalary());
		}else {
			System.out.println("Employee '"+commandLine+"' not found");
		}

	}
	
	

	public void ptintAllOperation(String  commandLine){
		String praintALL=validate.printAll(commandLine);
		if(praintALL.equals(null)) {
			System.out.println("please insert vaild sort type (ASC || DESC)");
		}else {
			ArrayList<Employee> employees=(ArrayList<Employee>) empOperations.printAll(praintALL);
			for(Employee employee: employees) {
				System.out.println(employee.getEmployee_name()+" : "+employee.getDesignation());
			}
		}
	}
	
}
