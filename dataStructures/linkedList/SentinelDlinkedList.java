package dataStructures.linkedList;

public class SentinelDlinkedList<T extends Comparable<T>> {


	private DlistNode<T> sentinel;
	private int size;


	public SentinelDlinkedList(){

		this.sentinel = new DlistNode<T>(null);

		this.sentinel.setNext(this.sentinel);
		this.sentinel.setPrev(this.sentinel);

		this.size = 0;
	}



	public boolean empty(){
		return this.size == 0;
	}

	public int size(){

		int result = 0;
		DlistNode<T> current = this.sentinel;
		while(current.getNext() != this.sentinel){
			result++;
			current = current.getNext();
		}

		return result;

	}

	public void appendAtEnd(T newElement){
		DlistNode<T> newNode = new DlistNode<>(newElement);

		newNode.setPrev(this.sentinel.getPrev());
		this.sentinel.getPrev().setNext(newNode);

		sentinel.setPrev(newNode);
		newNode.setNext(sentinel);


		size++;
	}


	public boolean hasNext(){
		return this.sentinel.getNext() != sentinel;
	}



	public T getElementAt( int place){

		if(size == 0 || place<1 || place> size){
			return null;
		}

		DlistNode<T> current = this.sentinel.getNext();

		int count= 1;
		while(count<place){
			current=current.getNext();
			count++;
		}


		return current.getElement();
	}



	public void deleteFromHead(){
		this.sentinel.getNext().getNext().setPrev(sentinel);
		this.sentinel.setNext(this.sentinel.getNext().getNext());
		size--;
	}


	public int searchForElement(T key){
		DlistNode<T> current = this.sentinel.getNext();
		int index = 0;

		while(current != sentinel){
			index++;
			if(current.getElement().equals(key)){
				return index;
			}
			current= current.getNext();
		}
		return -1; //-1 signify the key not found
	}



	public void insertionSortDoublyLinkedList() {


		//To illustrate my total understanding of insertion sort
		//I am going to sort backward and in a decrease manner, from left to right

		DlistNode<T> rightBoundOfUnsorted = this.sentinel.getPrev().getPrev();



		while( rightBoundOfUnsorted != this.sentinel ){

			DlistNode<T> currentInUnsorted = rightBoundOfUnsorted;

			DlistNode<T> leftBoundOfSorted = rightBoundOfUnsorted.getNext();
			DlistNode<T> currentInSorted = leftBoundOfSorted;


			while(currentInSorted != this.sentinel 
					&& currentInSorted.getElement().compareTo(currentInUnsorted.getElement())>0){

				currentInSorted = currentInSorted.getNext();
			}


			//must keep a ref of the unshifted pointer, we still need it after rearrange
			rightBoundOfUnsorted = rightBoundOfUnsorted.getPrev();
			currentInSorted.insertBefore(currentInUnsorted);

			if(currentInUnsorted.getElement().compareTo(leftBoundOfSorted.getElement())>0){
				leftBoundOfSorted = currentInUnsorted;
			}

			rightBoundOfUnsorted.setNext(leftBoundOfSorted);
			leftBoundOfSorted.setPrev(rightBoundOfUnsorted);


			//

			System.out.println(this.toString());
		}

	}


	public void insertionSortDoublyLinkedListVersion2() {


		//To illustrate my total understanding of insertion sort
		//I am going to sort backward and in a decrease manner, from left to right

		DlistNode<T> rightBoundOfUnsorted = this.sentinel.getPrev().getPrev();



		while( rightBoundOfUnsorted != this.sentinel ){

			DlistNode<T> currentInUnsorted = rightBoundOfUnsorted;

			DlistNode<T> leftBoundOfSorted = rightBoundOfUnsorted.getNext();
			DlistNode<T> currentInSorted = leftBoundOfSorted;

			boolean shifted = false;
			while(currentInSorted != this.sentinel 
					&& currentInSorted.getElement().compareTo(currentInUnsorted.getElement())>0){

				currentInSorted = currentInSorted.getNext();
				shifted = true;
			}

			rightBoundOfUnsorted = rightBoundOfUnsorted.getPrev();
			
			if(shifted){
				currentInSorted.insertBefore(currentInUnsorted);			
				rightBoundOfUnsorted.setNext(leftBoundOfSorted);
				leftBoundOfSorted.setPrev(rightBoundOfUnsorted);
			}



			System.out.println(this.toString());


		}

	}






	@Override
	public String toString(){
		String result = "This list contains:\n[ ";

		DlistNode<T> current = this.sentinel.getNext();

		while(current != sentinel){

			result+= current.toString()+", ";
			current=current.getNext();
		}


		result+= "\b\b ]";
		return result;
	}






}
