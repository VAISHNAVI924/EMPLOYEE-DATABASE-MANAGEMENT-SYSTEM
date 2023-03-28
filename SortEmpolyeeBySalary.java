package customsortingemp;

import java.util.Comparator;

import employeedatabasemanagementsystem.Empolyee;

public class SortEmpolyeeBySalary implements Comparator<Empolyee>{
	public int compare(Empolyee e1,Empolyee e2) {
		Double x=e1.getSalary();
		Double y=e2.getSalary();
		return x.compareTo(y);
	}

}
