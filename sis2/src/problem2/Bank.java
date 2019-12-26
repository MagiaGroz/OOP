package problem2;

import java.util.Vector;

public class Bank {

	private Vector<Account> v;
	Bank(Vector<Account> v){
		this.v=v;
	}
	public void update(){
		for(int i=0;i<v.size();i++) {
			v.get(i).deposit(150.0);
			v.get(i).withdraw(30.0);
		}
		System.out.println(v.toString());
		for(int i=0;i<v.size();i++) {
			if(v.get(i) instanceof SavingsAccount) {
			SavingsAccount s = (SavingsAccount)v.get(i);
			s.addin();
			}
			else if(v.get(i) instanceof CheckingAccount) {
				CheckingAccount c = (CheckingAccount)v.get(i);
				c.deductFee();
			}
		}
	}
			void openAcc(int number) {
				v.add(new Account(number));
			}
			void openAcc(int number,double inter) {
				v.add(new SavingsAccount(number,inter));	
					}
			void openAcc(int number, int freetr) {
				v.add(new CheckingAccount(number,freetr));
			}
			
			void closeAcc(int number) {
				for(int i=0;i<v.size();i++) {
					if(v.get(i).getAccountNumber()==number) {
						v.remove(i);
						break;
					}
				}
			}
			
		Vector<Account> getVector() {
			return v;
		}
			
	
	public static void main(String[] args) {
		
		Account e1 = new Account(23315);
		SavingsAccount e2 = new SavingsAccount(23316,0.1);
		CheckingAccount e3 = new CheckingAccount(23317,1);
		Vector<Account> v = new Vector<Account>();
		v.add(e1);
		v.add(e2);
		v.add(e3);
		
		Bank b = new Bank(v);
	//	b.openAcc(9348345, 0.2);
		System.out.println(b.getVector().toString());
		
		b.update();
		System.out.println(b.getVector().toString());
		
	}

}
