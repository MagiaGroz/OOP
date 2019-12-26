package lab5;

 class MaxMin{
	 
	 static class MinMaxVar { // статичный потому что он общий дл€ всех обьектов
		int max;
		int min;
		MinMaxVar(int max,int min){
			this.max=max;
			this.min=min;
		}
	
		MinMaxVar(){ // пустой конструктор
		}
	}
	
	static MinMaxVar minmax(int values[]) { // возвращает экземпл€р inner класса
		int lmx=-1; // локальные пол€
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
		

		
		MaxMin.MinMaxVar l = new MaxMin.MinMaxVar(); // экземпл€р иннер класса
	
		l = MaxMin.minmax(values); //приравн€ть наш экземпл€р , экземпл€ру который возвращает метод
		System.out.println("Max from array = " + l.max +"\n" +
						   "Min from array = " + l.min);
		
	}

}
