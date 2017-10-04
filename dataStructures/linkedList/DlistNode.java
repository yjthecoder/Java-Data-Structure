package dataStructures.linkedList;

public class DlistNode<T extends Comparable<T>> {
	
	private T element;
	private DlistNode<T> prev;
	private DlistNode<T> next;
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public DlistNode<T> getPrev() {
		return prev;
	}
	public void setPrev(DlistNode<T> prev) {
		this.prev = prev;
	}
	public DlistNode<T> getNext() {
		return next;
	}
	 
	public void setNext(DlistNode<T> dlistNode) {
		this.next = dlistNode;
	}

	
	
	public DlistNode( T element, DlistNode<T> prev, DlistNode<T> next){
		
		this.element = element;
		this.prev = prev;
		this.next = next;		
	}
	
	public DlistNode(T newElement){
		this(newElement, null, null);
	}
	
	public void insertBefore(DlistNode<T> newNode){
		
		if(newNode == this.getPrev()){
			return;
		}
		
		newNode.setNext(this);
		newNode.setPrev(this.getPrev());
		this.getPrev().setNext(newNode);
		this.setPrev(newNode);
		
	}

	
	@Override
	public String toString(){
		return element.toString();
	}

}
