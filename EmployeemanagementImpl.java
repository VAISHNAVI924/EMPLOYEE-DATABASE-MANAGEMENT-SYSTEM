package employeedatabasemanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexceptionemp.EmployeeNotFoundException;
import customexceptionemp.InvalidChoiceException;
import customexp.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;
import customsortingemp.SortEmployeeByAge;
import customsortingemp.SortEmployeeById;
import customsortingemp.SortEmployeeByName;
import customsortingemp.SortEmpolyeeBySalary;
import sdbms.Student;

public class EmployeemanagementImpl implements EmployeeManagementSystem {
	Scanner scan=new Scanner(System.in);
	Map<String,Empolyee> db=new LinkedHashMap<String,Empolyee>(); 
	public void addemployee() {
		System.out.println("enter employee age");
		int age=scan.nextInt();
		System.out.println("enter employee name");
		String name=scan.next();
		System.out.println("enter employee salary");
		double salary=scan.nextDouble();
		Empolyee emp=new Empolyee(age,name,salary);
		db.put(emp.getId(), emp);
		System.out.println("employee record insertd successfully");
		System.out.println("employee id is"+emp.getId());
	}

	public void displayemployee() {
		System.out.println("Enter student Id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Empolyee emp=db.get(id);
			System.out.println("Id:"+emp.getId());
			System.out.println("Age:"+emp.getAge());
			System.out.println(" Name:"+emp.getName());
			System.out.println("salary:"+emp.getSalary());
		}
		else {
			try { 
				String message="employee with Id:"+id+"not found";
				throw new EmployeeNotFoundException(message);	 
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	public void displayAllemployee() {
		if(db.size()!=0) {
			System.out.println("employee details are as follows");
			System.out.println("---------------------------------");
			Set<String> keys=db.keySet();

			for(String key:keys) {
				Empolyee emp=db.get(key);
				System.out.println(emp);
			}
		}
		else {
			try {
				String message="employee database is empty ,nothing to displsay";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void removeemployee() {
		System.out.println("enter employee id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("employee record succesfully");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("employee record deleted succesfully");
		}
		else {
			try {
				String message="employee with Id:"+id+"not found";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException  e) {
				System.out.println(e.getMessage());
			}
		}
	}


	public void removeAllemployee() {
		if(db.size()!=0) {
			System.out.println("Available student record:"+db.size());	 
			db.clear();
			System.out.println("All the student record deleted successfully");
		}
		else {
			try {
				String message="employee Dtabase is Empty,Nothing to Delete";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}


	public void updateemployee() {
		System.out.println("enter student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Empolyee emp=db.get(id);
			System.out.println("1:update age\n2:update name\n3:update marks");
			System.out.println("Enter choice:");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Enter age");

			int age=scan.nextInt();
			emp.setAge(age);
			System.out.println("age is updated succesfully");
			break;

			case 2:System.out.println("Enter name");
			String name=scan.next();
			emp.setName(name);
			System.out.println("name is updated succesfully");


			case 3: System.out.println("Enter saraly");
			int salary=scan.nextInt();
			emp.setSalary(salary);
			System.out.println("salary are updated");

			default:
				try {
					throw new InvalidChoiceException("Invalid choice");
				}
				catch(Exception  e) {
					System.out.println(e.getMessage());

				}
			}
		}


	}
	public void countemployee() {
		System.out.println("Available student record:"+db.size()); 

	}

	public void sortemployee() {
		if(db.size()>=2) {
			List<Empolyee> l=new ArrayList<Empolyee>();//
			Set <String> keys =db.keySet();//storing 101 102 103
			for(String key:keys) {
				l.add(db.get(key)); //getting &adding student object in Al
			}
			System.out.println("1:sort Student By Id\n2:sort student By Age\n3:sort student By name\n4:sort student By marks");    
			System.out.println("Enter choice");  
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				Collections.sort(l,new SortEmployeeById());//at time we can use display method for avoid for each loop
				for(Empolyee emp:l) {                                     //private static void display(List<student> l)
					System.out.println(emp);                                      
				}
				break;
			case 2:
				Collections.sort(l,new SortEmployeeByAge());
				for(Empolyee emp:l) {
					System.out.println(emp);
				}
				break;
			case 3:
				Collections.sort(l,new SortEmployeeByName());
				for(Empolyee emp:l) {
					System.out.println(emp);
				}

				break;
			case 4:
				Collections.sort(l,new SortEmpolyeeBySalary());
				for(Empolyee emp:l) {
					System.out.println(emp);
				}
				break;
			}
		}
		else {

			try {
				String message="No sufficient student record to sort";
				throw new EmployeeNotFoundException(message);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}
	public void getemployeewithHighestSalary() {
		if(db.size()>=2)
		{
			List<Empolyee> l=new ArrayList<Empolyee>();

			Set<String> keys=db.keySet();
			for(String key:keys) {
				l.add(db.get(key));//getting & ADDING STudent object in AL
			}
			Collections.sort(l,new SortEmpolyeeBySalary());
			System.out.println(l.get(l.size()-1));
		}
		else {
			try {
				String message="no sufficient student records to compare";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}
	public void getemployeewithLowestSalary() {
		if(db.size()>=2)
		{
			List<Empolyee> l=new ArrayList<Empolyee>();

			Set<String> keys=db.keySet();
			for(String key:keys) {
				l.add(db.get(key));//getting & ADDING STudent object in AL
			}
			Collections.sort(l,new SortEmpolyeeBySalary());
			System.out.println(l.get(0));
		}
		else {
			try {
				String message="no sufficient student records to compare";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void addempolyee() {
		// TODO Auto-generated method stub
		
	}


}



