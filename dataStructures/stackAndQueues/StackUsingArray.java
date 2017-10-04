package dataStructures.stackAndQueues;

public class StackUsingArray<T extends Comparable<T>> {

	private Object[] innerArray;
	private int top;
	private int size;
	
	public StackUsingArray(int size){
		top = -1;
		innerArray = new Object[size];
		this.size = size;
		
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		if(size >  0){
		return (T)innerArray[top];
		}else{
			throw new RuntimeException("Stack is empty!"); // throw a customized run time exception
		}
	}
	
	@SuppressWarnings("unchecked")
	public T pop(){
		if(size >=  0){
		T result =  (T)innerArray[top];
		top--;
		return result;
		}else{
			return null;
		}
	}
	
	public void push(T newElement){
		this.top++;
		innerArray[top] = newElement;
	}
	
	@Override
	public String toString(){
		String result = "This stack contains(from bottom to top):\n[ ";
		
		for(int i=0; i< this.size; i++){
			if(innerArray[i] != null){
			result += innerArray[i].toString()+ ", ";
			}
		}
		result+= "\b\b ]";
		return result;
	}
	//test the stack to do.
	public static void main(String args[]){
		
		StackUsingArray<Integer> theStack = new StackUsingArray<>(50);
		
		theStack.push(new Integer(0));
		theStack.push(new Integer(1));
		theStack.push(new Integer(2));
		theStack.push(new Integer(3));
		theStack.push(new Integer(4));
		theStack.push(new Integer(5));
		theStack.push(new Integer(6));
		theStack.push(new Integer(7));
		theStack.push(new Integer(8));
		theStack.push(new Integer(9));
		theStack.push(new Integer(10));
		theStack.push(new Integer(11));
		theStack.push(new Integer(12));
		System.out.println(theStack.toString());
		System.out.println(theStack.pop());
		System.out.println(theStack.peek());
	}
	
}
