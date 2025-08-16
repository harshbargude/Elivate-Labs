import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Employee;
import service.EmployeeService;
import service.impl.EmployeeSerIMPL;

public class Main {
	public static void main(String[] args) {
		
		EmployeeSerIMPL eImpl = new EmployeeSerIMPL();

        Scanner input = new Scanner(System.in);
        boolean run = true;
        int choice = 5;
        while (run) {
        	
        	List<Employee> empList;
        	
            System.out.println(
                    "\nEmployee Management System CLI:\nSelect the operation\n1] Create Employee\n2] Read Employees\n3] Edit Employees\n4] Delete Employee\n5] Exit Program");

            try {
                System.out.print("Enter the Operation Number: ");
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (Exception e) {
                break;
            }

            switch (choice) {
                case 1:
                    Employee newEmployee = new Employee();
                    System.out.print("Enter Employee Name: ");
                    newEmployee.setName(input.nextLine().trim());
                    System.out.print("Enter employee email: ");
                    newEmployee.setEmail(input.nextLine().trim());
                    System.out.print("Enter Employee Depeartment: ");
                    newEmployee.setDepartment((input.nextLine().trim()));

                    eImpl.createEmployee(newEmployee);
                    System.out.println("Employee Added Successfully!");
                    break;
                case 2:
                	empList = eImpl.readEmployees();
                    if (empList.size() < 1) {
                        System.out.println("No Employee Added!");
                        break;
                    }
                    System.out.println("<=====| List of Employees |====>");
                    for (Employee emp : empList) {
                        System.out.println(emp.toString());
                    }
                    break;
                case 3:
                	empList = eImpl.readEmployees();
                    if (empList.size() < 1) {
                        System.out.println("No Employee Added!");
                        break;
                    }
                    System.out.print("Enter Employee id to edit: ");
                    long std_id = Long.parseLong(input.nextLine().trim());
                    Employee empToEdit = empList.stream()
                            .filter(student -> student.getId() == std_id)
                            .findFirst()
                            .orElse(null);

                    if (empToEdit == null) {
                        System.out.println("Employee Not Found!");
                        break;
                    } else {


                        System.out.println("Employee to edit: " + empToEdit.toString());
                        boolean edit = true;
                        while (edit) {
                            System.out.println("\nWhat to edit?\n1] Employee Name\n2] Employee Email\n3] Employee Departmentn\n4] done edit!!");
                            System.out.print("Enter the Operation number.");
                            int editChoice = Integer.parseInt(input.nextLine().trim());
                            switch (editChoice) {
                                case 1:
                                    System.out.print("Enter new First name: ");
                                    String newName = input.nextLine().trim();
                                    empToEdit.setName(newName);
                                case 2:
                                    System.out.print("Enter new Email: ");
                                    String newEmail = input.nextLine().trim();
                                    empToEdit.setEmail(newEmail);
                                    break;

                                case 3:
                                    System.out.print("Enter new Department: ");
                                    String newDepartMent = input.nextLine().trim();
                                    empToEdit.setDepartment(newDepartMent);
                                    break;
                                case 4:
                                    edit = false;
                                    eImpl.editEmployee(empToEdit, empToEdit.getId());
                                    break;
                            }
                        }
                    }
                    break;
                case 4:
                    empList = eImpl.readEmployees();
                    
                    if (empList.size() < 1) {
                        System.out.println("No Employee Added!");
                        break;
                    }
                    System.out.print("Enter Employee id to delete: ");
                    int id_del = Integer.parseInt(input.nextLine().trim());
                    Employee empToDelete = empList.stream()
                            .filter(student -> student.getId() == id_del)
                            .findFirst()
                            .orElse(null);

                    if (empToDelete == null) {
                        System.out.println("Employee Not Found!");
                        break;
                    }else{
                    	eImpl.deleatEmployee(id_del);
                        System.out.println("Employee Deleted");
                    }
                    break;
                case 5:
                    run = false;
                    System.out.println("Bye!");
                    break;

                default:
                    break;
            }

        }
		
	}
}
