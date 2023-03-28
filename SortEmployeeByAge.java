package customsortingemp;

import java.util.Comparator;

import employeedatabasemanagementsystem.Empolyee;

public class SortEmployeeByAge  implements Comparator<Empolyee>{
public int compare(Empolyee e1,Empolyee e2)
{
	Integer x=e1.getAge();
	Integer y=e2.getAge();
	return x.compareTo(y);
}
}
