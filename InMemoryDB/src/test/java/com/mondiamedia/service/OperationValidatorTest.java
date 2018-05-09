package com.mondiamedia.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.mondiamedia.model.Employee;

public class OperationValidatorTest {
	OperationValidator valiator= new OperationValidator();
	@Test
	public void testAddValidation() {
		String commandLine="1002-fathy elshemy-software engineer-1111";
		Employee emp=valiator.addValidation(commandLine);
		assertEquals(1002, emp.getEmployee_id());
		assertEquals(1111, (int)emp.getSalary());
		assertEquals("fathy elshemy", emp.getEmployee_name());
		assertEquals("software engineer", emp.getDesignation());	}

	@Test
	public void testDelValidation() {
		String commandLine="1001";
		String commandLine2="lsdfns";
		int employeeId=valiator.delValidation(commandLine);
		int commandNumber=Integer.valueOf(commandLine);
		assertEquals(commandNumber, employeeId);
		int employeeId2=valiator.delValidation(commandLine2);
		assertEquals(employeeId2, 0);	}

	@Test
	public void testPrintValidation() {
		String commandLine="1111";
		int employeeId=valiator.printValidation(commandLine);
		int commandNumber=Integer.valueOf(commandLine);
		assertEquals(commandNumber, employeeId);
		String commandLine2="safsdas";
		int employeeId2=valiator.printValidation(commandLine2);
		assertEquals(0, employeeId2);
	}

	@Test
	public void testUpdateValidation() {
		String commandLine="1002-name-ahmed fathy";
		ArrayList<String> arguments=(ArrayList<String>) valiator.updateValidation(commandLine);
		assertEquals(arguments.size(), 3);
		assertEquals("1002", arguments.get(0));
		assertEquals("name", arguments.get(1));
		assertEquals("ahmed fathy", arguments.get(2));
	}

	@Test
	public void testPrintAll() {
		String sortType="ASC";
		assertEquals(sortType, valiator.printAll(sortType));
		String sortType2="DESC";
		assertEquals(sortType2, valiator.printAll(sortType2));
		}

}
