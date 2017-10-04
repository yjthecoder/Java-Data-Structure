package javaThreadTesting;

public class Transaction implements Runnable{

	public class BankAccount{
		private int balance = 100;
		public int getBalance(){
			return balance;
		}

		public void withdraw(int amount){
			balance-=amount;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Transaction transact = new Transaction();
		Thread one = new Thread(transact);
		Thread two = new Thread(transact);
		one.setName("Ryan");
		two.setName("Monica");

		one.start();
		two.start();		
	}


	private BankAccount baccount= new BankAccount();


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			makeWithdraw();	
			if(baccount.getBalance() < 0){
				System.out.println("Overdrawn!");
			}
		}
	}

	private void makeWithdraw() {

		if(baccount.getBalance()>= 10){

			System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
			// change the place of sleep
			try {
				System.out.println(Thread.currentThread().getName()+" is going to sleep");
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() +" woke up.");
			baccount.withdraw(10);
			System.out.println(Thread.currentThread().getName() +" completes the withdrawal");
		}else{
			System.out.println("Sorry not enought for "+ Thread.currentThread().getName());
		}
	}






}
