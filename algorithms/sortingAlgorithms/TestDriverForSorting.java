package algorithms.sortingAlgorithms;

import randomStaff.RandomArrayGenerator;

public class TestDriverForSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Integer[] theArray=RandomArrayGenerator.generateRandomArray(15, 60);

		RandomArrayGenerator.showTheArray(theArray);
		
		
		System.out.println(SelectionSort.findTheMinIndex(theArray));
		
		
		//BubbleSort.sort(theArray);
		//SelectionSort.recursiveSort(theArray, 0);
		//SelectionSort.iterativeSort(theArray);		
		insertionSort.iterativeSort(theArray);
		
		RandomArrayGenerator.showTheArray(theArray);
		
	
//		System.out.println(BubbleSort.factorial(5));
//		System.out.println(BubbleSort.sum(5));
		
		
		
		
	}


}