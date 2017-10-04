package headFirstJava.simpleSinkingShipGame;

import java.util.Scanner;

public class SinkingTheShipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		//game set up
		//1 generate location cell

		
		
		int[] randomLocation = new int [3];
		int startingLoc = (int) (Math.random() * 5);

		for(int i=0; i<randomLocation.length;i++){
			randomLocation[i] = startingLoc++;
			//debug
			System.out.println(randomLocation[i]);
		}

		
		ShipToSink ship1= new ShipToSink("Ship Number 1");
		ship1.setPosition(randomLocation);
		
		
		int tryCount = 0;
		
		Scanner inputStream = new Scanner(System.in);
		while(true){
			System.out.println("Enter a hit position(from 0 to 6, inclusive)");
			String hitResult = ship1.checkGuess(inputStream.next());
			tryCount++;
			System.out.println(hitResult);
			
			if(hitResult == "kill"){
				System.out.println("You got it in "+tryCount+ " tries.");
				break;
			}
		}
		
		inputStream.close();

		
		
		return;
	}


}
