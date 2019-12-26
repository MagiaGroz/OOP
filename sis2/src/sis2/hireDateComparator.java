package sis2;
import java.util.Comparator;
public class hireDateComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.hireDate.compareTo(e2.hireDate);
	}

}
