package problem1;

import java.io.IOException;

abstract class Circuit {
	
		public abstract double getResistance();
		public abstract double getPotentialDiff() throws IOException; 
		public abstract void applyPotentialDiff(double V);
		public double getPower() throws IOException {
			return getPotentialDiff()*getPotentialDiff()/getResistance(); 		
			}
		

		public double getCurrent(double V) {
			return V/getResistance();   
		} 
	
	public static void main(String[] args) throws IOException {
		Circuit a = new Resistor(3.0);
		Circuit b = new Resistor(3.0);
		Circuit c = new Resistor(6.0);
		Circuit d = new Resistor(3.0);
		Circuit e = new Resistor(2.0);
		Circuit f = new Series(a, b);
		System.out.println(f.getResistance());
		Circuit g = new Parallel(c, d);
		System.out.println(g.getResistance());

		Circuit h = new Series(g, e);
		System.out.println(h.getResistance());
		Circuit circuit = new Parallel(h, f);
		circuit.applyPotentialDiff(12);
		double R = circuit.getResistance();
		System.out.println(circuit.getResistance());
		System.out.println("circuit "+circuit.getPotentialDiff());
		System.out.println("h "+h.getPotentialDiff());
		System.out.println("f "+f.getPotentialDiff());
		System.out.println("g "+g.getPotentialDiff());
		System.out.println("e "+e.getPotentialDiff());
		System.out.println("c "+c.getPotentialDiff());
		System.out.println("d "+d.getPotentialDiff());
		System.out.println("a "+a.getPotentialDiff());
		System.out.println("b "+b.getPotentialDiff());
		
	
	}
	

}
