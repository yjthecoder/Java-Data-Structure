package algorithms.sortingAlgorithms;

public class insertionSort {
	
	
	public static void iterativeSort(Integer[] targetArray){
		
		
		
		//get the current element starting with index 1, compare to all previous element
		// once THE RIGHT PLACE is spotted, do the insert
			// the insert: shift the element on the left to right by 1 element,
		// keep doing the same thing until no element left
		
		// the right place: element on hold< element being inspected
				
		for(int i=1; i<targetArray.length;i++){
			
			//Integer currentElement = new Integer(targetArray[i].intValue());
//			Integer currentElement = targetArray[i];// java中各种赋值只是改变ref 和 obj的关联关系
//			//scan the left of the current element to find the right place to insert
//			for(integer j=i-1; j>-1; j--){
//				if(currentElement.intValue() < targetArray[j].intValue()){
//					//shift the element to right by 1 step
//					targetArray[j+1] = targetArray[j];  // note: messed up with the index cause bugs，shift是相对于当前index的
//
//					if(j==0){
//						targetArray[j]= currentElement;
//						break;
//					}
//				}else{
//					//insert once the right spot is found
//					targetArray[j+1] = currentElement;
//					break;
//				}
//			}
//			
//			//Note: it is a bad idea to use for loop here, because you do not know exactly how many it will run
//			// While generally better for quit upon condition (compound conditions, especially)
//			// for loop is generally better for quit upon fixed times of iteration
			
			int j=i-1;
			Integer current = targetArray[i];  // this step is essential, you must keep a ref before it is overwritten to other ref
			while(j>=0 && (current.intValue() < targetArray[j].intValue())){
				targetArray[j+1] = targetArray[j]; 
				j--;
			}
			
			//there always an insertion after breaking out the loop
			targetArray[j+1] = current;
		}
		
	}
	
	

	
	

}
