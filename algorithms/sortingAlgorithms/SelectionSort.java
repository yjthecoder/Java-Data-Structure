package algorithms.sortingAlgorithms;

public class SelectionSort {
	
	public static void recursiveSort(Integer[] targetArray, int startIndex){
		
		
		if(startIndex == targetArray.length-1){
			return;
		}
		
		

		Integer[] subArray = new Integer[targetArray.length-startIndex];
		
		for(int i=startIndex; i<targetArray.length; i++){
			subArray[i-startIndex] = targetArray[i];
		}
		
		int minIndex = findTheMinIndex(subArray);//find the index of the min in the subarray

		
		//swap the current min with the current first element
		// DO NOT SWAP USING A FUNCTION
		
		Integer temp = targetArray[startIndex];
		targetArray[startIndex] = targetArray[minIndex+startIndex]; // note: mapping the index
		targetArray[minIndex+startIndex] = temp;
		 
		
		//debug
		//randomStaff.RandomArrayGenerator.showTheArray(targetArray);
		//System.out.println(targetArray[startIndex].intValue());
		
		recursiveSort(targetArray, startIndex+1);
		
	}
	
	
	public static void iterativeSort( Integer[] targetArray){
		
		for(int i=0; i<targetArray.length-1;i++){
			
			int minIndex = i;
			for(int j=i+1; j<targetArray.length;j++){
				//find the smallest  and swap it with the first element
				if(targetArray[j].intValue()<targetArray[i].intValue()){
					minIndex = j;
				}			
			}
			
			Integer temp= targetArray[i];
			 targetArray[i]= targetArray[minIndex];
			 targetArray[minIndex]=temp;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static int findTheMinIndex(Integer[] targetArray){
		
		//set the first element as the min, scan the whole array to update it once condition is met
		
		Integer min	= targetArray[0];
		int minIndex = 0;
		for(int i=0; i<targetArray.length;i++){
			if(targetArray[i].intValue()<min){
				min = targetArray[i];
				minIndex = i;
			}
		}
		return minIndex;	
	}
	

}
