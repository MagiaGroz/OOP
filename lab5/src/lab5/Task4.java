package lab5;

 class MaxMin{
	 
	 static class MinMaxVar { // ��������� ������ ��� �� ����� ��� ���� ��������
		int max;
		int min;
		MinMaxVar(int max,int min){
			this.max=max;
			this.min=min;
		}
	
		MinMaxVar(){ // ������ �����������
		}
	}
	
	static MinMaxVar minmax(int values[]) { // ���������� ��������� inner ������
		int lmx=-1; // ��������� ����
		int lmn=10000;
		for(int i=0;i<values.length;i++) {
			if(values[i]>lmx)
				lmx=values[i];
			if(values[i]<lmn)
				lmn=values[i];
		}
		 return new MinMaxVar(lmx,lmn); 
		
	}
}
 
public class Task4 {

	public static void main(String[] args) {
		int[] values = {0,8,-3,20};
		

		
		MaxMin.MinMaxVar l = new MaxMin.MinMaxVar(); // ��������� ����� ������
	
		l = MaxMin.minmax(values); //���������� ��� ��������� , ���������� ������� ���������� �����
		System.out.println("Max from array = " + l.max +"\n" +
						   "Min from array = " + l.min);
		
	}

}
