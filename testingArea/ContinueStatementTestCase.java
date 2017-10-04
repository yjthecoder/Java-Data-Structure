package testingArea;

public class ContinueStatementTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<12; i++){
			if(i == 9){
				System.out.println(i + " reached!");
			}
			System.out.println(i);
			if(i == 8){
				continue;
			}
			i++;
		}
		
	
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();

//		int i = 1;
//		while(i<11){
//			System.out.println(i);
//			if(i == 8){
//				continue;
//			}
//			i++;
//		}
		

	}

}
