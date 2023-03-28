package customsortingemp;

import java.util.Comparator;

import employeedatabasemanagementsystem.Empolyee;

public class SortEmployeeByName implements Comparator<Empolyee>{
 public int compare( Empolyee e1, Empolyee e2) {
	  String x= e1.getName();
	  String y=e2.getName();
	  return x.compareTo(y);
 }
}
