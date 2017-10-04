package assignments.datastructure.udemy.assignment04;

import dataStructures.linkedList.SlinkedList;

public class TestDriverForLinkedListAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SlinkedList<Integer> integerList = new SlinkedList<>();
		integerList.appendAtEnd(new Integer(1));
		integerList.appendAtEnd(new Integer(2));
		integerList.appendAtEnd(new Integer(3));
		integerList.appendAtEnd(new Integer(4));
		integerList.appendAtEnd(new Integer(5));
		integerList.appendAtEnd(new Integer(6));
		integerList.appendAtEnd(new Integer(7));
		integerList.appendAtEnd(new Integer(8));
		integerList.appendAtEnd(new Integer(9));
		integerList.appendAtEnd(new Integer(10));
		integerList.appendAtEnd(new Integer(11));
		integerList.appendAtEnd(new Integer(12));
		integerList.appendAtEnd(new Integer(13));
		
		System.out.println(integerList.toString());
		
		/*
		 * problem 1
		 */
		//integerList.moveNodesFromEndToBeginVersion2(4);
		//integerList.moveNodesFromEndToBegin(4);
		
		/*
		 * problem 2
		 */
		
		//integerList.reverse();
		
		/*
		 * problem 3
		 */
	
		System.out.println(integerList.findKthFromEnd(5));
		

	}

}
