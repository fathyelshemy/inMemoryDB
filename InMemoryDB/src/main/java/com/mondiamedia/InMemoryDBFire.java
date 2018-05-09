package com.mondiamedia;

import java.util.ArrayList;
import java.util.Scanner;

import com.mondiamedia.service.EmployeeFactory;
import com.mondiamedia.service.OperationValidator;

public class InMemoryDBFire {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		while(true) {
		String commandLine=input.nextLine();
			OperationValidator operationValidator=new OperationValidator();
			operationValidator.createTableStructure();
			EmployeeFactory employeeFactory= new EmployeeFactory();
			employeeFactory.operationsFactoryMethod(commandLine);
		}
	}
}
