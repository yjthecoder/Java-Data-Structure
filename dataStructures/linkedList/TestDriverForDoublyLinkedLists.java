package dataStructures.linkedList;

public class TestDriverForDoublyLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SentinelDlinkedList<Integer> integerDlist = new SentinelDlinkedList<>();
		
		System.out.println(integerDlist.empty());
		
		integerDlist.appendAtEnd(new Integer(0));
		integerDlist.appendAtEnd(new Integer(1));
		integerDlist.appendAtEnd(new Integer(8));

		integerDlist.appendAtEnd(new Integer(2));
		integerDlist.appendAtEnd(new Integer(0));
		integerDlist.appendAtEnd(new Integer(6));
		integerDlist.appendAtEnd(new Integer(9));

		integerDlist.appendAtEnd(new Integer(3));
		integerDlist.appendAtEnd(new Integer(4));
		integerDlist.appendAtEnd(new Integer(4));
		integerDlist.appendAtEnd(new Integer(5));
		integerDlist.appendAtEnd(new Integer(6));
		integerDlist.appendAtEnd(new Integer(7));
		integerDlist.appendAtEnd(new Integer(8));
		
		
		
		for(int i=1; i<=integerDlist.size(); i++){
			System.out.println(integerDlist.getElementAt(i));
		}
		
		
		System.out.println(integerDlist.toString());
		System.out.println(integerDlist.size());
		
		integerDlist.deleteFromHead();
		System.out.println(integerDlist.toString());
		System.out.println(integerDlist.size());

		
		
		System.out.println(integerDlist.searchForElement(new Integer(10)));
		
		integerDlist.insertionSortDoublyLinkedListVersion2();
		
		
		System.out.println("\n\nSummary of new list:");
		System.out.println(integerDlist.toString());
		System.out.println(integerDlist.size());

		
		
	}

}
