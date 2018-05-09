package com.mondiamedia.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mondiamedia.dao.DBUtilities;
import com.mondiamedia.model.Employee;

public class EmployeeOperations {

	private static Logger _log=Logger.getLogger(EmployeeOperations.class);
	private DBUtilities dbUtilities= new DBUtilities();
	public boolean addEmployee(Employee emp) {
		if(emp!=null) {
			String insertQuery="insert into employee(employee_id,employee_name,designation,salary)"
					+ "values("+emp.getEmployee_id()+",'"+emp.getEmployee_name()+"',"
							+ "'"+emp.getDesignation()+"',"+emp.getSalary()+")";
			try {
				dbUtilities.executeQueries(insertQuery);
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				_log.error(e);
				return false;
			}
		}
		return false;
	}
	/*
	 * update employee data 
	*/
	public Employee updateEmployee(int employeeId, String EmployeeProperty , String propertyValue)  {
		Employee emp= findEmployee(employeeId);
		try {
		if(emp!=null) {
			 if(EmployeeProperty.equalsIgnoreCase("SALARY")) {
				 double updatedSalary=Double.valueOf(propertyValue);
				 String updateQuery="update  employee set salary="+updatedSalary+" where employee_id="+employeeId+"";
				 dbUtilities.executeQueries(updateQuery);
				 emp=findEmployee(employeeId);
				
			}else if(EmployeeProperty.equalsIgnoreCase("NAME")) {
				 String updateQuery="update  employee set employee_name='"+propertyValue+"' where employee_id="+employeeId+"";
				 dbUtilities.executeQueries(updateQuery);
				 emp=findEmployee(employeeId);
			}else if(EmployeeProperty.equalsIgnoreCase("DESIG")) {
				 String updateQuery="update  employee set designation='"+propertyValue+"' where employee_id="+employeeId+"";
				 dbUtilities.executeQueries(updateQuery);
				 emp=findEmployee(employeeId);
			}
		}
		}catch(SQLException e) {
			_log.error(e);
		}
		return emp;
	}
	
	public boolean delEmployee(int employeeId) {
		Employee emp=findEmployee(employeeId);
		if(emp!=null) {
			String delQuery="delete from employee where employee_id="+employeeId;
			try {
				dbUtilities.executeQueries(delQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
			return true;
		}
		return false;
	}

	/*
	 * find specific employee by id
	*/
	public Employee findEmployee(int employeeId) {
		Employee emp= null;
		String selectQuery="select employee_name,designation,salary from employee where employee_id= "+employeeId;
		try {
			ResultSet rs= dbUtilities.retrieveResult(selectQuery);
				
				while (rs.next()) {
					emp = new Employee();
					String employeeName = rs.getString("employee_name");
					String designation = rs.getString("designation");
					double salary = rs.getDouble("salary");
					emp.setEmployee_id(employeeId);
					emp.setEmployee_name(employeeName);
					emp.setDesignation(designation);
					emp.setSalary(salary);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		
		return emp;
	}
	/*
	 * retrieve all employees with  specific order 
	*/
	public List<Employee> printAll(String sortType) {
		String selectQuery="select employee_id,employee_name,designation,salary from employee order by employee_name "+sortType;
		ArrayList<Employee> employees= new ArrayList<>();
		try {
			ResultSet rs=dbUtilities.retrieveResult(selectQuery);
			while(rs.next()) {
				int employeeId=rs.getInt("employee_id");
				String employeeName=rs.getString("employee_name");
				String designation=rs.getString("designation");
				double salary=rs.getDouble("salary");
				Employee emp= new Employee();
				emp.setEmployee_id(employeeId);
				emp.setEmployee_name(employeeName);
				emp.setDesignation(designation);
				emp.setSalary(salary);
				employees.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	/*
	 * retrieve employees  number 
	*/
	public int employeesCounter() {
		String selectQuery="select count(employee_id)from employee";
		int counter=0;
		try {
			ResultSet rs=dbUtilities.retrieveResult(selectQuery);
			if(rs.next())
				counter=rs.getInt(1);
			return counter;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		return counter;
	}
	/*
	 * create table structure for employee table 
	*/
	public void createDBStructure() {
		String sqlQuery = "create table employee(employee_id int not null unique,employee_name varchar(50), designation varchar(50),salary double)";
		try {
			ResultSet res = dbUtilities.getConn().getMetaData().getTables(null, "APP",
					"employee".toUpperCase(), null);// Default schema name is "APP"
			if (res.next()) {
				// do some thing;
			} else {
				try {
					dbUtilities.executeQueries(sqlQuery);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					_log.error(e);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

	}
}
