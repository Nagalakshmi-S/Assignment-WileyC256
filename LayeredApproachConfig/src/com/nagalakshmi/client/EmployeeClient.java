package com.nagalakshmi.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nagalakshmi.config.ClientConfiguration;
import com.nagalakshmi.presentation.EmployeePresentation;

public class EmployeeClient {

	public static void main(String[] args) {
		//EmployeePresentation employeePresentation=new EmployeePresentationImpl();
		
		//ApplicationContext clientContainer=new ClassPathXmlApplicationContext("ClientConfig.xml");
		AnnotationConfigApplicationContext clientContainer=new AnnotationConfigApplicationContext(ClientConfiguration.class);
		EmployeePresentation employeePresentation=(EmployeePresentation) clientContainer.getBean("EmpPresentation");
		Scanner scanner=new Scanner(System.in);
		while(true) {
			
			employeePresentation.showMenu();
			System.out.println("Enter Choice ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
			System.out.println();
			
		}

	}

}