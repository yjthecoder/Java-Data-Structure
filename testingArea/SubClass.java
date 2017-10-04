package testingArea;

class SubClass extends SuperClass{
	
	public void subMethodA(){
		super.superMethodB();
		System.out.println("This is subMethod A");
	}

	public void subMethodB(){
	  System.out.println("This is subbMethod B");
	}
	
	public static void main(String[] args){
		SubClass subClassObj = new SubClass();
		subClassObj.subMethodA();
	}
}
