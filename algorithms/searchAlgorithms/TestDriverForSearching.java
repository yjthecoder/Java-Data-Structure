package algorithms.searchAlgorithms;

import java.util.Scanner;

import algorithms.sortingAlgorithms.insertionSort;
import randomStaff.RandomArrayGenerator;

public class TestDriverForSearching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] theArray=RandomArrayGenerator.generateRandomArray(15, 60);

		RandomArrayGenerator.showTheArray(theArray);
		insertionSort.iterativeSort(theArray);
		RandomArrayGenerator.showTheArray(theArray);

		
		
		
		
		Scanner inputGetter = new Scanner(System.in);
		System.out.print("Enter the number to search:");
		
		int key = inputGetter.nextInt();
		@SuppressWarnings("unused")
		String dummy1 = inputGetter.nextLine();
		
		BinarySearcher<Integer> bsearcher =  new BinarySearcher<Integer>();
		
		//int returnedIndex=  bsearcher.recursiveSearch(key, theArray, 0, theArray.length-1);
		int returnedIndex=  bsearcher.iterativeSearch(key, theArray);

		if(returnedIndex == -1){
			System.out.println("Key not found!");
			System.out.println("Input index is: "+ bsearcher.insertIndex);
			theArray = new randomStaff.RandomArrayGenerator().doubleTheCurrentArray(theArray);
			
			//make room for the inserted search key
			for(int i= theArray.length/2 -1;i>=bsearcher.insertIndex; i--){
				theArray[i+1] = theArray[i];
			}

			theArray[bsearcher.insertIndex] = new Integer(key);
			
			System.out.println("The new array after insertion is: ");
			RandomArrayGenerator.showTheArray(theArray);

			
			
		}else{
			System.out.println(theArray[returnedIndex]+" is at the "+ returnedIndex+" place");
		}
		
		inputGetter.close();
	}

}





















