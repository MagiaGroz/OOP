package problem4;


class Time implements Comparable<Time>{
	@Override
	public int compareTo(Time o) {
		if(this.hour-o.hour==0) {
			if(this.minute-o.minute==0) {
				if(this.second-o.second==0) {
					return 0;
				}
				return this.second-o.second;
			}
			return this.minute-o.minute;
		}
		return this.hour-o.hour;
	}
	
	int hour;
	int minute;
	int second;
	
	Time(int hour, int minute, int second){
		if(hour>23 || minute>59 || second>59)
			System.out.println("Input is invalid");
		else {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
			 }
	}
	
	@Override
	public String toString() {
		return toUniversal();
	}
	String toUniversal(){
		String s="";
		s+=checker(s);		
		return s;
	}
	
	String checker(String s) {
		if(hour<10)
			s="0"+hour+":";
		else 
			s=hour+":";
		if(minute<10)
			s+="0"+minute+":";
		else
			s+=minute+":";
		if(second<10)
			s+="0"+second;
		else
			s+=second;
		return s;
	}
	
	String toStandard(){
		String s = "";
		String m ="AM";
		boolean otnyaliHour = false;
		if(hour>12) {
			hour-=12;
			m="PM";
			otnyaliHour = true;
		}
		s+=checker(s);		
		s+=" "+m;
		if(otnyaliHour)
			hour+=12;
		return s;
	}
	
	void add(Time t2) {
		if((hour+t2.hour)>23)
		hour+=t2.hour-24;
		else
			hour+=t2.hour;
		if((minute+t2.minute)>59)
		minute+=t2.minute-60;
		else
			minute+=t2.minute;
		if((second+t2.second)>59)
		second+=t2.second-60;
		else 		
			second+=t2.second;
		
	}

	
}