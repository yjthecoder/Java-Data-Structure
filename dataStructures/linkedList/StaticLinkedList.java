//using an array to achieve linkedlist property
package dataStructures.linkedList;

import java.rmi.MarshalledObject;

import javax.swing.text.InternationalFormatter;

public class StaticLinkedList {

	class StaticNode{
		Integer data;
		int nextIndex; // refer to the node that next to it
		
		//constructors
		public StaticNode(){
			this.data = null;
			this.nextIndex = 0;
		}
		
		public StaticNode(Integer data){
			this.data =  data;
			this.nextIndex = 0;
		}
		
		public StaticNode(Integer data, int nextIndex) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.nextIndex = nextIndex;
		}
	}
	
	
	//fields of static linked list
	StaticNode headNode;
	StaticNode lastNode;
	
	int MAXSIZE;

	int length = 0;
	
	StaticNode[]  innerArray;
	
	public void initList(int maxsize){
		
		this.MAXSIZE = maxsize;
		innerArray = new StaticNode[MAXSIZE];
		
		for(int i=1; i< MAXSIZE-1; i++){
			innerArray[i].nextIndex = i+1;
		}
		headNode = new StaticNode(null, 1);
		lastNode = new StaticNode(null, 0);
		
		innerArray[0] = headNode;
		innerArray[MAXSIZE -1] = lastNode;
	}
	
	
	public StaticNode generateNode(Integer data){
		return new StaticNode(data);
	}
	
	//return the index of first available cell in the array
	public int malloc(){
		
		
		int firstFreeCell = headNode.nextIndex;
		
		if(headNode.nextIndex != 0){
			headNode.nextIndex = innerArray[firstFreeCell].nextIndex;
		}
		
		return firstFreeCell;
	}
	
	
	public boolean insertBefore(int i, Integer data){
		
		//note that valid insert place starts from 1
		if(i> length+1 || i<1){
			return false;
		}
		
		//make a new node
		StaticNode newNode=  generateNode(data);
		
		//assign a empty cell to put new node
		int newNodeIndex = malloc();
		
		if(newNodeIndex == 0){
			return false;
		}
		
		
		/*get the index of the element before the ith element*/
		//notice that j starts from the index of first valid element
		int j= lastNode.nextIndex;
		//use for loop since you know exactly how many iterations are needed
		//////////
		//////////
		////////// one step of the counter, one execution of the loop body, yes, but which happens first really matters
		//		   loop body get excecuted before the counter incrementation, so it is one step ahead when loop ends
		for(int currentloc = 1; currentloc< i-1; currentloc++){
			j = innerArray[j].nextIndex;
		}
		
		//insert the new node, the sequence matters!
		newNode.nextIndex = innerArray[j].nextIndex; 
		innerArray[j].nextIndex = newNodeIndex;
		
		length++;
		return true;
	}
	
	//postcondition: 
	//1.connet i-1 and i+1 element 
	//2.add the released cell at the beginning of the empty list part
	
	public boolean deleteAt(int i){
		//note that valid delete place starts from 1
		if(i> length+1 || i<1){
			return false;
		}
		
		//get the location of i-1 element, iIndex starts from the index of first valid element
		int indexBeforei = lastNode.nextIndex;
		
		for(int j=1; j<i-1; j++){
			indexBeforei = innerArray[indexBeforei].nextIndex;
		}
		
		int indexi= innerArray[indexBeforei].nextIndex;
		int indexAfteri= innerArray[indexi].nextIndex;
		
		innerArray[indexBeforei].nextIndex = indexAfteri;
		free(indexi);
		return true;		
	}
	
	public boolean free(int i){
		
		//note that valid delete place starts from 1
		if(i> length+1 || i<1){
			return false;
		}
		innerArray[i].nextIndex = headNode.nextIndex;
		headNode.nextIndex = i;
		return true;
	}	
	
}
