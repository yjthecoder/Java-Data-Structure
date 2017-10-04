package algorithms.searchAlgorithms;

public class BinarySearcher<T> {
	
	int insertIndex = -1;  // keep track of the place to insert if the search failed to find anything
	
	public int  recursiveSearch(int key, Integer[] targetArray, int bottomIndex, int topIndex){
		
		if(bottomIndex>topIndex){
			insertIndex = bottomIndex;
			return -1;
		}
		
		int midIndex = (int)((bottomIndex+topIndex)/2);
		
		if(key == targetArray[midIndex].intValue()){
			insertIndex = midIndex;
			return midIndex;
		}else if(key < targetArray[midIndex].intValue()){
			return recursiveSearch(key, targetArray, bottomIndex, midIndex-1);
		}else{
			return recursiveSearch(key, targetArray, midIndex+1, topIndex);
		}
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public  int  recursiveSearchGeneric(T key, T[] bjectsArray, int bottomIndex, int topIndex){
	
		if(bottomIndex>topIndex){
			insertIndex = bottomIndex;
			return -1;
		}
		
		int midIndex = (int)((bottomIndex+topIndex)/2);
		
		if(key.equals(bjectsArray[midIndex])){
			return midIndex;
		}else if(((Comparable<Character>) key).compareTo((Character) bjectsArray[midIndex])< 0){
			return recursiveSearchGeneric(key, bjectsArray, bottomIndex, midIndex-1);
		}else{
			return recursiveSearchGeneric(key, bjectsArray, midIndex+1, topIndex);
		}
	}
	
	
	
	
	// now it is the time to improve this algorithm
	// if not found, it should return an index as a cue for the insert of the key
	
	public int iterativeSearch(int key,Integer[] targetArray){
		
		int upperBoundIndex = targetArray.length;
		int lowerBoundIndex = 0;
		
		int midIndex= (int) (targetArray.length/2);
		
		while(true){
			
			if(lowerBoundIndex > upperBoundIndex){
				insertIndex = lowerBoundIndex;
				return -1;
			}
			if(targetArray[midIndex].intValue() == key){
				insertIndex = midIndex;
				return midIndex;
			}else if(targetArray[midIndex].intValue() < key){
				
				lowerBoundIndex = midIndex+1;
				midIndex = (int) (lowerBoundIndex+upperBoundIndex)/2;
			}else{
				upperBoundIndex = midIndex-1;
				midIndex = (int) (lowerBoundIndex+upperBoundIndex)/2;
			}
		}
		
	}
	
	
	
	
	

}
