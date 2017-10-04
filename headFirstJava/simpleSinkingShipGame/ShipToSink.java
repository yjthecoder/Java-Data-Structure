package headFirstJava.simpleSinkingShipGame;

/*
 * This class represent the ship to be hit
 */

public class ShipToSink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] location= {1,2,3};

		ShipToSink testShip= new ShipToSink("testShip");

		testShip.setPosition(location);

		
		String testCheck = testShip.checkGuess("4");

		if(testCheck == "hit"){
			System.out.println("Test Passed");

		}else{
			System.out.println("Test Failed");
		}



		return;
	}

	private String name;
	private int hitCount = 0; // record the state
	private int[] locationCells;
	
	public ShipToSink(String name){
		this.setName(name);
	}


	public String checkGuess(String userGuess) {

		String result="miss";
		
		//convert user guess to a number
		int guessedNum = Integer.parseInt(userGuess);
		
		for(int currenCell: locationCells){
			if(currenCell == guessedNum){
				hitCount++;
				result ="hit";			// once it hit, the return value will be set to "hit", although it may be overwrite by "kill" later
				currenCell = -1;
				break;
			}
		}
		
		if(hitCount == locationCells.length){
			result = "kill";
		}
		
		return result;		
	}

	public void setPosition(int[] randomPosition){
		//assign the random generated (but legal) position
		// to the locatioinCells[]
		locationCells = randomPosition;

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}




