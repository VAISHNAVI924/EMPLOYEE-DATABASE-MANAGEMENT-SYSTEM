package customsortingemp;

import java.util.Comparator;

import employeedatabasemanagementsystem.Empolyee;

public class SortEmployeeById  implements Comparator<Empolyee>{
	public int compare(Empolyee e1,Empolyee e2) {
		
		String x=e1.getId();
		String y=e2.getId();
		return x.compareTo(y);//rturn e1.getId().compareTo(e2.getId())
		
	}
}
