package problem4;

import java.util.Date;

import lab5.Employee;;
public class Sort<E> {

	 static <E> void swap(E [] numbers, int i, int j) {  
		E tempVar = numbers [j];
         numbers [j]= numbers [i];
         numbers [i] = tempVar;
	 } 
		 
	 static <E extends Comparable<E>> void bubbleSort(E [] numbers) {
		  
		         for (int i = 0; i < numbers.length; i++)
		         { 
		                  for(int j = i+1; j < numbers.length; j++)
		                  {  	 
		                          if(numbers[i].compareTo(numbers[j])>0)
		                          {
		                              swap(numbers,i,j);
		                          }
		                  }
		         }

		 }
	
		 static <E extends Comparable<E>> void quickSort(E[] source, int leftBorder, int rightBorder) {
		        int leftMarker = leftBorder;
		        int rightMarker = rightBorder;
		        E pivot = source[(leftMarker + rightMarker) / 2];
		        do {
		            // ������� ����� ������ ����� ������� ���� ������� ������, ��� pivot
		            while (pivot.compareTo(source[leftMarker])>0) {
		                leftMarker++;
		            }
		            // ������� ������ ������, ���� ������� ������, ��� pivot
		            while (pivot.compareTo(source[rightMarker])<0) {
		                rightMarker--;
		            }
		            // ��������, �� ����� �������� ������� ��������, �� ������� ��������� �������
		            if (leftMarker <= rightMarker) {
		                // ����� ������ ����� ������ ������� ������ ���� �� ������ ��������� swap
		                if (leftMarker < rightMarker) {
		                	swap(source,leftMarker,rightMarker);
		                }
		                // �������� �������, ����� �������� ����� �������
		                leftMarker++;
		                rightMarker--;
		            }
		        } while (leftMarker <= rightMarker);

		        // ��������� ���������� ��� ������
		        if (leftMarker < rightBorder) {
		            quickSort(source, leftMarker, rightBorder);
		        }
		        if (leftBorder < rightMarker) {
		            quickSort(source, leftBorder, rightMarker);
		        }
		}		 
	 
	 

		    
	 
	public static void main(String[] args) {

		Chocolate c1 = new Chocolate(150,"Alenka");
		Chocolate c2 = new Chocolate(100,"Alenka");
		Chocolate c3 = new Chocolate(90,"Alenka");
		Chocolate c4 = new Chocolate(0,"Snickers");
		Chocolate c5 = new Chocolate(-30,"Snickers");
		Chocolate[] c = new Chocolate[]{c1,c2,c3,c4,c5};
		Sort.bubbleSort(c);
		 for (int i = 0; i < c.length; i++)
         {
                   System.out.println(c[i].toString());
         }
		 
		Time t1 = new Time(23,10,43);
		Time t2 = new Time(3,1,3);
		Time t3 = new Time(22,15,46);
		Time t4 = new Time(15,19,4);
		Time[] t = new Time[] {t1,t2,t3,t4};
		Sort.quickSort(t, 0, t.length-1);
		 for (int i = 0; i < t.length; i++)
         {
                   System.out.println(t[i].toString());
         }
		 
		 Employee e1 = new Employee("John",3000,new Date(),"12032");
		 Employee e2 = new Employee("John",2000,new Date(),"12032");
		 Employee e3 = new Employee("John",6000,new Date(),"12032");
		 Employee e4 = new Employee("John",500,new Date(),"12032");
		 Employee[] e = new Employee[] {e1,e2,e3,e4};
		 Sort.quickSort(e, 0, e.length-1);
		 
		 for (int i = 0; i < t.length; i++)
         {
                   System.out.println(e[i].toString());
         }
	}

}
