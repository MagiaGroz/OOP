package problem1;

import java.io.IOException;

public class Series extends Circuit {

	Circuit r1;
	Circuit r2;
	Series(Circuit r1, Circuit r2){
		this.r1=r1;
		this.r2=r2;
	}
	@Override
	public double getResistance() {
		return r1.getResistance()+r2.getResistance();
	}

	@Override
	public double getPotentialDiff() throws IOException {
		
		return r1.getPotentialDiff()+r2.getPotentialDiff();
	}

	@Override
	public void applyPotentialDiff(double V) {
		r1.applyPotentialDiff(getCurrent(V)*r1.getResistance());
		r2.applyPotentialDiff(getCurrent(V)*r2.getResistance());
    //	r1.applyPotentialDiff(V*(r1.getResistance()/(r1.getResistance()+r2.getResistance())));
	//	r1.applyPotentialDiff(V*(r2.getResistance()/(r1.getResistance()+r2.getResistance())));

	}

}
