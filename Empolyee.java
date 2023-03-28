package employeedatabasemanagementsystem;

public class Empolyee {
 String id;
 int age;
 String name;
 double salary;
 int count=101;
 Empolyee(int age,String name,double salary){
	 this.id="jsp"+id;
	 this.age=age;
	 this.name=name;
	 this.salary=salary;
	 count++;
	  }
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
@Override
public String toString() {
	return "Empolyee [id=" + id + ", age=" + age + ", name=" + name + ", salary=" + salary + ", count=" + count + "]";
}
 
 
 
 
 
 
}
