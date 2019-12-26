package problem1;

import java.io.IOException;

public class Parallel extends Circuit {

	Circuit r1;
	Circuit r2;
	Parallel(Circuit r1, Circuit r2){
		this.r1=r1;
		this.r2=r2;
	}
	@Override
	public double getResistance() {
		return 1/(1/r1.getResistance()+1/r2.getResistance());
	}

	@Override
	public double getPotentialDiff() throws IOException {
		if(r1.getPotentialDiff()==r2.getPotentialDiff())
			return r1.getPotentialDiff();
		throw new IOException();
	}

	@Override
	public void applyPotentialDiff(double V) {
		r1.applyPotentialDiff(V);
		r2.applyPotentialDiff(V);
	}

}
