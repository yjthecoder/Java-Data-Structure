package com.loonycorn.stack;

public class Stack<T> {

	//make it static so it can be instantiated outside the outer class without an outer object
    public static class Element<T> {
        private T data;
        private Element<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element<T> getNext() {
            return next;
        }
 
        public void setNext(Element<T> next) {
            this.next = next;
        }

        public Element(T data, Element<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    
    public static class StackOverflowException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }

    public static class StackUnderflowException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }
    

	//stack attributes
    private static int MAX_SIZE = 40;
    private Element<T> top;
    private int size = 0;



    public void push(T data) throws StackOverflowException {
        if (size == MAX_SIZE) {
            throw new StackOverflowException();
        }

        //use the value of the pointer first, then modify its value, otherwise you lose the original value
        Element<T> elem = new Element<T>(data, top);
        top = elem;
        size++;
    }

    
    public T pop() throws StackUnderflowException {
    	//always handle exception case first, to save time
        if (size == 0) {
            throw new StackUnderflowException();
        }
        
        T data = top.getData();
        top = top.getNext();

        size--;

        return data;
    }

    public T peek() throws StackUnderflowException {
        if (size == 0) {
            throw new StackUnderflowException();
        }

        return top.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public int getSize() {
        return size;
    }


    //how to tell the exception a method throws
    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
        MAX_SIZE = 4;
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.getSize());
        System.out.println("Stack fullT: " + stack.isFull());
        System.out.println("Stack emptyT: " + stack.isEmpty());

        stack.push(4);
        System.out.println("Stack size: " + stack.getSize());
        System.out.println("Stack fullT: " + stack.isFull());
        System.out.println("Stack emptyT: " + stack.isEmpty());

        System.out.println("Stack peek: " + stack.peek());

        int data = stack.pop();
        System.out.println("Popped element: " + data);

        System.out.println("Peek again: " + stack.peek());

        try {
            stack.push(4);
            stack.push(5);
        } catch (StackOverflowException soe) {
            System.out.println("Stack is full! No room available.");
        }

        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (StackUnderflowException sue) {
            System.out.println("Stack is empty! No elements available.");
        }
    }

    

}
