package com.mondiamedia.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.mondiamedia.model.Employee;

public class EmployeeOperationsTest {

	private Employee emp=null;
	private EmployeeOperations ops=new EmployeeOperations();
	
	@Before
	public void initEmployee(){
		 emp= new Employee();
		 emp.setEmployee_id(326598);
		 emp.setDesignation("software engineer");
		 emp.setEmployee_name("fathy elshemy");
		 emp.setSalary(265125);
		
	}
	@Test
	public void testAddEmployee() {
		ops.addEmployee(emp);
	}

	@Test
	public void testUpdateEmployee() {
		ops.updateEmployee(emp.getEmployee_id(), "name", "fathy ahmed");
		ops.updateEmployee(emp.getEmployee_id(), "design", "developer");
		ops.updateEmployee(emp.getEmployee_id(), "salary", "12365");
	}

	@Test
	public void testDelEmployee() {
		ops.delEmployee(emp.getEmployee_id());
	}

	@Test
	public void testFindEmployee() {
		ops.findEmployee(emp.getEmployee_id());
	}

	@Test
	public void testPrintAll() {
		ops.printAll("asc");
	}



}
