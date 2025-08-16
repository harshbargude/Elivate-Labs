package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import entity.Employee;
import repo.DBConnection;
import service.EmployeeService;

public class EmployeeSerIMPL implements EmployeeService {
	
	List<Employee> employees = new ArrayList<>();
	
	ResultSet rs;

	public Employee createEmployee(Employee employee) {
		System.out.println(employee.toString());
		try(Connection con = DBConnection.connectToDB()) {
			String sqlQuery = "Insert into employees (employee_name,employee_email,employee_department) values(?,?,?)";
			PreparedStatement Pstmt = con.prepareStatement(sqlQuery);
			Pstmt.setString(1, employee.getName());
			Pstmt.setString(2, employee.getEmail());
			Pstmt.setString(3, employee.getDepartment());
			
			int insertData = Pstmt.executeUpdate();
			
			if (insertData > 0) {
				return employee;
			} 
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Employee> readEmployees() {
		employees.clear();
		System.out.println("in the read employees!");
		try(Connection con = DBConnection.connectToDB()){
			String sqlQuerry = "Select * from Employees";
			PreparedStatement pstmt = con.prepareStatement(sqlQuerry);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt("id"), rs.getString("employee_name"), rs.getString("employee_email"), rs.getString("employee_department"));
				employees.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee editEmployee(Employee employee, int empId) {

		String newName = employee.getName();
		String newEmail = employee.getEmail();
		String newDepartMent = employee.getDepartment();
		
		System.out.println("in the edit employees!");
		try(Connection con = DBConnection.connectToDB()){
			String sqlQuerry = "UPDATE EMPLOYEES SET employee_name = ?, employee_email = ?, employee_department = ? WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sqlQuerry);
			pstmt.setString(1, newName);
			pstmt.setString(2, newEmail);
			pstmt.setString(3, newDepartMent);
			pstmt.setInt(4, empId);
			
			int rs = pstmt.executeUpdate();
			
			if(rs>0) {
				System.out.println("Employee Updated Successfully!!");
			}else {
				System.out.println("Employee id not Found!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee deleatEmployee(int empId) {
		try(Connection con = DBConnection.connectToDB()){
			String sqlQuerry = "Delete from EMPLOYEES WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sqlQuerry);
			pstmt.setInt(1, empId);
			
			int rs = pstmt.executeUpdate();
			
			if(rs>0) {
				System.out.println("Employee Deleted Successfully!!");
			}else {
				System.out.println("Employee id not Found!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
