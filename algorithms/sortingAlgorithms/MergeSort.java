package algorithms.sortingAlgorithms;

import randomStaff.RandomArrayGenerator;

public class MergeSort {

	private Integer[] targetArray;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeSort mSorter = new MergeSort();
		mSorter.targetArray= RandomArrayGenerator.generateRandomArray(15, 60);
		
//		Integer[] test = {17,15,1,4};
//		
//		mSorter.targetArray = test;
		
//		
//		RandomArrayGenerator.showTheArray(mSorter.targetArray);
//
//		mSorter.targetArray = mSorter.sort(test);
//		
//		RandomArrayGenerator.showTheArray(mSorter.targetArray);


		
		RandomArrayGenerator.showTheArray(mSorter.targetArray);

		//do the sorting
		mSorter.targetArray = mSorter.sort(mSorter.targetArray);

		RandomArrayGenerator.showTheArray(mSorter.targetArray);
		
		
		
//		System.out.println("Merge test:\n");
//		Integer[] left = {17,15};		
//		Integer[] right= {1,4};	
//		
//		System.out.println("left array:\n");
//		RandomArrayGenerator.showTheArray(left);
//		System.out.println("right array:\n");
//
//		RandomArrayGenerator.showTheArray(right);
//		System.out.println("result array:\n");
//		RandomArrayGenerator.showTheArray(mSorter.merge(left, right));

	}


	public Integer[] merge (Integer[] left,Integer[] right){

		Integer[] mergedArray = new Integer[left.length+right.length];

		//append elements in left and right accordingly to mergedArray

		//using three pointers to combine the two already sorted array into one
		int lIndex=0, rIndex=0, mIndext=0;		
		while(true){

			if(left[lIndex]<right[rIndex]){
				mergedArray[mIndext] = left[lIndex];
				mIndext++;
				lIndex++;
			}else{
				mergedArray[mIndext] = right[rIndex];
				mIndext++;
				rIndex++;
			}

			//if left runs out first, append all remaining elements in the right
			if(lIndex == left.length){
				for(int i=rIndex; i<right.length;i++){
					mergedArray[mIndext] = right[i];    //bug fixed here
					mIndext++;
				}
				return mergedArray;
			}

			if(rIndex == right.length){
				for(int i=lIndex; i<left.length;i++){
					mergedArray[mIndext] = left[i];		//bug fixed here!!
					mIndext++;
				}
				return mergedArray;
			}
		}

	}

	public Integer[] sort(Integer[] targetArray){


		if(targetArray.length == 1){
			return targetArray;
		}
		
		
		int leftSize = targetArray.length/2;
		int rightSize = targetArray.length - (int) targetArray.length/2;

		Integer[] left= new Integer[leftSize];
		Integer[] right= new Integer[rightSize];

		for(int i=0; i<targetArray.length;i++){
			if(i<leftSize){
				left[i] = targetArray[i];
			}else{
				right[i-leftSize] = targetArray[i];
			}
		}
		
		return merge(sort(left), sort(right));	
	}
}


























