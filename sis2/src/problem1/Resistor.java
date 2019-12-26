package problem1;

public class Resistor extends Circuit {
	double resistance;
	double pottentialDifference;
	Resistor(double resistance){
		this.resistance=resistance;
	}
	@Override
	public double getResistance() {
		return resistance;
	}

	@Override
	public double getPotentialDiff() {
		return pottentialDifference;
	}

	@Override
	public void applyPotentialDiff(double V) {
			this.pottentialDifference=V;
	}

}
