package src;


public class Mark {
    private double att1;
    private double att2;
    private double finalExam;
    Course course;

    public Mark(){
        att1 = 0;
        att2 = 0;
        finalExam = 0;
    }

    public Mark(double att1, double att2, double finalExam){
       this.att1 = att1;
       this.att2 = att2;
       this.finalExam = finalExam;
    }

    public double getAtt1(){
        return att1;
    }

    public double getAtt2(){
        return att2;
    }

    public double getFinalExam(){
        return finalExam;
    }

    public double getOverall(){
        return att1 + att2 + finalExam;
    }

    public void setAtt1(double att1) {
        this.att1 = att1;
    }

    public void setAtt2(double att2) {
        this.att2 = att2;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    private boolean retake(){
        return (att1 + att2 < 30 || (getFinalExam() < 20));
    }

    public String toLetter(){
        if(retake()) return "F";
        if(getOverall() > 95) return "A";
        if (getOverall() > 90 && getOverall() < 95) return "-A";
        if (getOverall() > 85 && getOverall() < 90) return "+B";
        if (getOverall() > 80 && getOverall() < 85) return "B";
        if (getOverall() > 75 && getOverall() < 80) return "-B";
        if (getOverall() > 70 && getOverall() < 75) return "+C";
        if (getOverall() > 65 && getOverall() < 70) return "C";
        if (getOverall() > 60 && getOverall() < 65) return "-C";
        if (getOverall() > 55 && getOverall() < 60) return "D";
        if (getOverall() > 50 && getOverall() < 55) return "-D";
        return "FAIL";
    }

    public double toNumber() {
        if (getFinalExam() < 20) return 0;
        if (getOverall() > 95) return 4.0;
        else if (getOverall() > 90 && getOverall() < 95) return 3.67;
        else if (getOverall() > 85 && getOverall() < 90) return 3.33;
        else if (getOverall() > 80 && getOverall() < 85) return 3.0;
        else if (getOverall() > 75 && getOverall() < 80) return 2.67;
        else if (getOverall() > 70 && getOverall() < 75) return 2.33;
        else if (getOverall() > 65 && getOverall() < 70) return 2.0;
        else if (getOverall() > 60 && getOverall() < 65) return 1.67;
        else if (getOverall() > 55 && getOverall() < 60) return 1.33;
        else if (getOverall() > 50 && getOverall() < 55) return 1.0;
        else return 0;
    }

    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		if (Double.doubleToLongBits(finalExam) != Double.doubleToLongBits(other.finalExam))
			return false;
		if (Double.doubleToLongBits(att1) != Double.doubleToLongBits(other.att1))
			return false;
		if (Double.doubleToLongBits(att2) != Double.doubleToLongBits(other.att2))
			return false;
		return true;
	}
	
   
    public String toString() {
        return "Mark{" +
                "firstAttestation=" + att1 +
                ", secondAttestation=" + att2 +
                ", finalExam=" + finalExam +
                ", total=" + getOverall() +
                '}';
    }

}