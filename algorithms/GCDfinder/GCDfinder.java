package algorithms.GCDfinder;

import java.util.Scanner;

public class GCDfinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputGetter = new Scanner(System.in);
		System.out.print("Enter the first positive integer:");
		
		int firstNum = inputGetter.nextInt();
		@SuppressWarnings("unused")
		String dummy1 = inputGetter.nextLine();
		System.out.print("Enter the second positive integer:");
		
		int secondNum= inputGetter.nextInt();
		@SuppressWarnings("unused")
		String dummy2 = inputGetter.nextLine();

		
		int result = getTheGCDOf(firstNum,secondNum);
		
		System.out.println("The GCD of "+firstNum+" and "+secondNum+ " is "+ result+".");
		
		inputGetter.close();
	}
	
	

	public static int getTheGCDOf(int a,int b){
		
		if(a<b){
			int temp= a;
			b=a;
			b=temp;
		}
		
		if(a%b == 0){
			return b;
		}
		
		return getTheGCDOf(b, a%b);
		
	}
	
	public int getTheGCDVersion2(int a, int b){
		if(b == 0){
			return a;
		}
		
		return getTheGCDVersion2(b, a%b);
	}
	
	
	
}
