package algorithms.sortingAlgorithms;

public class BubbleSort {

	public static void sort(Integer[] targetArray){
		
		for(int i=targetArray.length-1; i>0;i--){
			
			for(int j=0; j<i;j++){
				if(targetArray[j].intValue() > targetArray[j+1].intValue()){
					Integer temp= targetArray[j];
					targetArray[j] = targetArray[j+1];
					targetArray[j+1]=temp;
				}
			}
		}
		
		
		
		
		
		
		return;
		
	}
	
	
	public static int factorial(int n){
		
		
		if(n==1){
			return 1;
		}
				
		return n*factorial(n-1);
		
	}
	
	public static int sum(int n){
		if(n==1){
			return 1;
		}
		
		return n+sum(n-1);
	}

}
