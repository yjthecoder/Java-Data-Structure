package dataStructures.linkedList;


public class SListNode<T extends Comparable<T>> {
	
		private T element;
		private SListNode<T> next;
		
		public T getElement() {
			return element;
		}
		public void setElement(T element) {
			this.element = element;
		}
		
		
		public SListNode<T> getNext() {
			return next;
		}
		public void setNext(SListNode<T> next) {
			this.next = next;
		}
		
		//constructors
		public SListNode (T element, SListNode<T> next){
			this.element =  element;
			this.next = next;			
		}
		
		// call constructor inside a constructor
		public SListNode (T element){
			this(element, null);
		}
		
		@Override
		public String toString(){
			return this.getElement().toString();
		}
}
