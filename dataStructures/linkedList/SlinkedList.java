package dataStructures.linkedList;

public class SlinkedList<T extends Comparable<T>> {

	private SListNode<T> head;
	private int length;

	public SlinkedList() {
		head = new SListNode<T>(null);
		length = 0;
	}

	public void insertAtBegin(T newElement){

		SListNode<T> newNode = new SListNode<T>(newElement);

		newNode.setNext(this.head);
		head = newNode;
		length++;		
	}

	public void appendAtEnd(T newElement){
		SListNode<T> newNode = new SListNode<>(newElement);
		
		if(this.length ==0){
			head = newNode;
			length++;
			return;
		}
		
		SListNode<T> current = head;
		while(current.getNext()!= null){
			current= current.getNext();
		}
		current.setNext(newNode);
		length++;
	}


	public SListNode<T> getNodeAt(int pos){

		if(pos>this.length || pos <= 0){
			return null;
		}

		int count = 1;
		SListNode<T> current = head;
		while(count< pos){
			current= current.getNext();
			count++;
		}
		return current;
	}

	// assignment 4 problem 1
	public int moveNodesFromEndToBegin(int n){
		if(n>this.length || n <= 0){
			return -1; 
		}else if(n == length){
			return 0;
		}else{
			//get n-1 th node
			SListNode<T> start = getNodeAt(this.length - n);
			SListNode<T> end = getNodeAt(this.length);
			//wire the pointer
			end.setNext(head);
			head=start.getNext();
			start.setNext(null);

			return 1;
		}
	}
	
	// assignment 4 problem 1 version 2
	public int moveNodesFromEndToBeginVersion2(int n){
		if(n>this.length || n <= 0){
			return -1; 
		}else if(n == length){
			return 0;
		}else{
			SListNode<T> left = this.head;
			SListNode<T> right = this.head;
			
			for(int i=0; i<n; i++){
				right = right.getNext();
			}
			
			while(right.getNext() != null){
				left = left.getNext();
				right = right.getNext();
			}
			
			right.setNext(this.head);
			this.head = left.getNext();
			left.setNext(null);
			
			return 1;
		}
	}
	
	// assignment 4 problem 2
	public void reverse(){
		SListNode<T> current = this.head;
		SListNode<T> prev = null;
		
		while(current != null){
			SListNode<T> next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		this.head = prev;
	}
	
	//assignment 4 problem 3
	public T findKthFromEnd(int k){
		
		if(k>= this.length || k <= 0){
			return null;
		}else{
			SListNode<T> left = this.head;
			SListNode<T> right = this.head;
			
			for(int i=0; i<k; i++){
				right = right.getNext();
			}
			
			while(right!= null){
				left = left.getNext();
				right = right.getNext();
			}
			
			
			return left.getElement();
		}
		
	}
	
	
	@Override
	public String toString(){
		String result = "This list contains:\n[ ";

		SListNode<T> current = this.head;

		while(current != null){

			result+= current.toString()+", ";
			current=current.getNext();
		}


		result+= "\b\b ]";
		return result;
	}
	
}//end of class





