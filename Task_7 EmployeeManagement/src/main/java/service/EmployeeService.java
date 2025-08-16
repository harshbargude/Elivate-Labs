package service;

import java.util.List;

import entity.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	public List<Employee> readEmployees();
	public Employee editEmployee(Employee employee, int id);
	public Employee deleatEmployee(int employee_id);

}





