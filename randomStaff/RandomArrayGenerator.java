package randomStaff;

public class RandomArrayGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		for (Integer current: generateRandomArray(10, 25)){
			System.out.println(current.intValue());
		}

	}




	public static Integer[] generateRandomArray(int size, int maxValue){
		Integer[] result= new Integer[size];

		for(int i=0; i<size;i++){
			int coreInt = (int) Math.round(Math.random()* maxValue);
			result[i] = new Integer(coreInt);
		}


		return result;
	}
	
	public static void showTheArray( Integer[] theArray){
		
		System.out.println();
		System.out.println();

		System.out.print("[");
		for (Integer current: theArray){
			if(current != null){
			System.out.print(current.intValue()+"  ");
			}
		}

		System.out.print("]");
		System.out.println();

	}
	
	public Integer[] doubleTheCurrentArray(Integer[] oldArray){
		Integer[] newArray = new Integer[(oldArray.length)*2];
		for(int i=0; i<oldArray.length;i++){
			newArray[i]= oldArray[i];
		}		
		return newArray;
	}

}