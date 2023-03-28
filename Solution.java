package employeedatabasemanagementsystem;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
    EmployeeManagementSystem emps=new EmployeemanagementImpl();	
    while(true) {
		System.out.println("1:Add employee\n2:display employee \n3:displayAllemployee \n4:removeemployee\n5:removeAllemployee\n6:updateemployee");	
		System.out.println("7:countemployee\n8:sortemployee\n9:getemployeewithHighestsalary\n10:getemployeewithLowestsalary\n11:Exit");	
		System.out.println("enter your choice");
int choice=scan.nextInt();
switch(choice) {
case 1:
	emps.addempolyee();
	break;
case 2:
	emps.displayemployee();
	break;
case 3:
	emps.displayAllemployee();
	break;
case 4: 
	emps.removeemployee();
	break;
case 5:
	emps.removeAllemployee();
	break;
case 6:
	emps.updateemployee();
	break;
case 7:
	emps.countemployee();
	break;
case 8:
	emps. sortemployee();
	break;
case 9:
	emps.getemployeewithHighestSalary();
	break;
case 10:
	emps. getemployeewithLowestSalary();
	break;
    
case 11:
	System.out.println("Thank you");
    System.exit(0);
    
default:
	try {
		throw new InvalidChoiceException("Invalid choice");

	}
	catch(InvalidChoiceException e){
		System.out.println(e.getMessage());

	}
}
}
}

}
