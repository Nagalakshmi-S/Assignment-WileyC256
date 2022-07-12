package com.nagalakshmi.presentation;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.nagalakshmi.bean.Employee;
import com.nagalakshmi.bean.EmployeePayslip;
import com.nagalakshmi.bean.Project;
import com.nagalakshmi.service.EmployeeService;
import com.nagalakshmi.service.EmployeeServiceImpl;
import com.nagalakshmi.service.ProjectAllocationService;
import com.nagalakshmi.service.ProjectAllocationServiceImpl;

public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService=new EmployeeServiceImpl();
	private ProjectAllocationService projectAllocService=new ProjectAllocationServiceImpl();
	
	@Override
	public void showMenu() {
		System.out.println("1. Show All Employees");
		System.out.println("2. Search Employee By ID");
		System.out.println("3. Add employee details");
		System.out.println("4. Delete employee details");
		System.out.println("5. Generate Payslip ");
		System.out.println("---------------------------");
		System.out.println("6. Show All Projects");
		System.out.println("7. Search Project By ID");
		System.out.println("8. Add Project details");
		System.out.println("9. Delete Project details");
		System.out.println("---------------------------");
		System.out.println("10. Show the current status of allocated projects");
		System.out.println("11. Allocate a Project to an Employee");
		System.out.println("12. Deallocate an Employee from a Project");
		System.out.println("13. Shift an Employee to a different project");
		System.out.println("14. Exit");

	}

	@Override
	public void performMenu(int choice) {
		
		try(Scanner scanner=new Scanner(System.in);) {
		switch (choice) {
		case 1:
			Set<Employee> employees=employeeService.getAllEmployees();
			for(Employee employee:employees) {
				System.out.println(employee.getEmpId()+"  "+employee.getEmpName());
			}
			break;

		case 2:
			System.out.println("Enter Employee ID : ");
			int id=scanner.nextInt();
			Employee empl=employeeService.searchEmployeeById(id);
			if(empl!=null) {
				System.out.println(empl.getEmpId()+"  "+empl.getEmpName());
			}
			else
				System.out.println("Employee with id "+id+" does not exist");
			break;
		case 3:
			System.out.println("Enter empid :");
			int empid=scanner.nextInt();
			System.out.println("Enter employee name:");
			String name=scanner.next();
			System.out.println("Enter employee designation:");
			String designation=scanner.next();
			System.out.println("Enter employee department:");
			String department=scanner.next();
			System.out.println("Enter employee salary:");
			double salary=scanner.nextDouble();
			boolean emp=employeeService.addEmployeeDetails(new Employee(empid,name,designation,department,salary));
			if(emp!=false) {
				System.out.println("Record added succesfully");
			}
			else {
				System.out.println("Unable to add record!");
			}
			break;
		case 4:
			System.out.println("Enter id of employee to delete from records:");
			int empID=scanner.nextInt();
			boolean employee=employeeService.deleteEmployeeDetails(empID);
			if(employee==false) {
				System.out.println("Record mismatch! Check the ID and enter again!");
			}
			else {
				System.out.println("Successfully deleted the Employee records with ID :"+empID);
			}
			break;
		
		case 5:
			System.out.println("Enter employee id to generate payslip : ");
			int empId=scanner.nextInt();
			EmployeePayslip epay=employeeService.generatePayslip(empId);
			Employee e=epay.getEmployee();
			System.out.println(e+"\nHR :"+epay.getHr()+"\nPF : "+epay.getPf()+"\nDA : "+epay.getDa()+"\nTotal Salary : "+epay.getTotalSalary());
			break;
			
		case 6:
			Set<Project> projects=projectAllocService.getAllProjects();
			for(Project p:projects) {
				System.out.println(p.getProjectId()+"  "+p.getProjectName());
			}
			break;
		case 7:
			System.out.println("Enter Project ID : ");
			int id1=scanner.nextInt();
			Project proj=projectAllocService.getProjectById(id1);
			if(proj!=null) {
				System.out.println(proj.getProjectId()+"  "+proj.getProjectName());
			}
			else
				System.out.println("Project with id "+id1+" does not exist");
			break;
		case 8:
			System.out.println("Enter project Id :");
			int projid=scanner.nextInt();
			System.out.println("Enter project name:");
			String pName=scanner.next();
			boolean project=projectAllocService.addNewProject(new Project(projid,pName));
			if(project!=false) {
				System.out.println("Project added succesfully");
			}
			else {
				System.out.println("Unable to add Project!");
			}
			break;
		case 9:
			System.out.println("Enter id of project to delete from records:");
			int projID=scanner.nextInt();
			boolean proje=projectAllocService.deleteProject(projID);
			if(proje==false) {
				System.out.println("Record mismatch! Check the ID and enter again!");
			}
			else {
				System.out.println("Successfully deleted the project records with ID :"+projID);
			}
			break;
		case 10:
			System.out.println("All projects adn employee list:");
			Map<Project, Set<Employee>> empInAProjMap=projectAllocService.getAllEmpInProject();
			for(Project p:empInAProjMap.keySet()) {
				System.out.println(p+"\t"+empInAProjMap.get(p));
			}
			break;
		case 11:
			System.out.print("Enter Employee ID: ");
			empID=scanner.nextInt();
			System.out.print("Enter Project ID: ");
			projID=scanner.nextInt();
			if(projectAllocService.allocateProject(empID, projID))
				System.out.println("Allocation Successful!");
			else
				System.out.println("Allocation Failed!!!!!");
			break;
		case 12:
			System.out.print("Enter Employee ID: ");
			empID=scanner.nextInt();
			System.out.print("Enter Project ID: ");
			projID=scanner.nextInt();
			if(projectAllocService.deAllocateProject(empID, projID))
				System.out.println("Deallocation Successful!");
			else
				System.out.println("Deallocation Failed!!!!!");
			break;
		case 13:
			System.out.print("Enter Employee ID: ");
			empID=scanner.nextInt();
			System.out.print("Enter new Project ID: ");
			projID=scanner.nextInt();
			if(projectAllocService.shiftToAProject(empID, projID))
				System.out.println("Employee shifted successfully!");
			else
				System.out.println("Failed! Employee could not be shifted");
			break;
		case 14:
			System.out.println("Thanks for using Employee Management System");
			System.exit(0);
		default:
			System.out.println("Invalid Coice");
			break;
		}
		}
		catch(Exception exception) {
			
		}
	}
}
