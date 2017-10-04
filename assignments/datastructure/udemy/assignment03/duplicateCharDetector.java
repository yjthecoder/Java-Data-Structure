package assignments.datastructure.udemy.assignment03;

public class duplicateCharDetector {
	

	public boolean checkDuplicateCharsByRecursion(String target){
		
		//base case
		if(target.length() == 1){
			return false;
		}// only 1 left means no chance to check it against others, it is unique
		
		char firstLetter = target.charAt(0);
			
		for(int i=1; i<target.length();i++){
			if(firstLetter == target.charAt(i)){
				return true;
			}
		}
		
		target = target.substring(1);
		
		return checkDuplicateCharsByRecursion(target);
	}
	
	
	public boolean hasDuplicateChars(String s) {
		// Standard ASCII (if you want to include extended ASCII, you may use a 256 length array
		boolean[] charSet = new boolean[128]; // additional memory
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (charSet[c]){
				return true;
			}
			charSet[c] = true;
		}
		return false;
	}
	
	
	

	
	

}
