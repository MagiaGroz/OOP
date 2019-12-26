package problem2;

public class Account {  
	private double balance;  //The current balance 
	private int accNumber; //The account number    
	
	public Account(int a) 
	{      
		balance=0.0;  
		accNumber=a;
	}  
	
	public void deposit(double sum) {
		balance+=sum;
	
	} 
	public void withdraw(double sum) {
		balance-=sum;
	}  
	public double getBalance(){
		return balance;
	}  
	public double getAccountNumber(){
		return accNumber;
	} 
	public void transfer(double amount, Account other){
		other.deposit(amount);
		this.withdraw(amount);
	} 


public String toString() {   
	return "balance: " +balance +" accNumber: "+accNumber; 
						}
public final void print()  {  
 System.out.println( toString() );  
}

}



class SavingsAccount extends Account {

	double inrate;
	public SavingsAccount(int a, double inrate) {
		super(a);
		this.inrate=inrate;
	}
	
	void addin() {
		double interest = super.getBalance()*inrate;
		deposit(interest);
	}
	
	public String toString() {
		return super.toString()+" inrate: "+inrate+"\n";
	}
	
	
}

class CheckingAccount extends Account{
	private int counter;
	private int FREE_TRANSACTIONS;
	public CheckingAccount(int a,int free) {
		super(a);
		counter=0;
		this.FREE_TRANSACTIONS=free;
	}
	public void withdraw(double sum) {
		counter++;
		super.withdraw(sum);
	}
	public void deposit(double sum) {
		counter++;
		super.deposit(sum);
	} 
	void deductFee(){
		withdraw((counter-FREE_TRANSACTIONS)*0.02);
	}
	public String toString() {
		return super.toString()+" NUMBER OF FREE TRANSACTIONS: "+ FREE_TRANSACTIONS+"\n";
	}
	
}