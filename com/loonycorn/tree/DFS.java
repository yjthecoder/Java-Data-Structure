package com.loonycorn.tree;
import com.loonycorn.queue.Queue;
import com.loonycorn.tree.BinaryTreeBreadthFirstTraversal;

public class DFS {

	public static void main(String[] args) throws
		// TODO Auto-generated method stub
		Queue.QueueUnderflowException,Queue.QueueOverflowException {
			Node<Character> a = new Node<>('A');
			Node<Character> b = new Node<>('B');
			Node<Character> c = new Node<>('C');
			Node<Character> d = new Node<>('D');
			Node<Character> e = new Node<>('E');
			Node<Character> f = new Node<>('F');
			Node<Character> g = new Node<>('G');
			Node<Character> h = new Node<>('H');
			Node<Character> x = new Node<>('X');

			a.setLeftChild(b);
			a.setRightChild(c);
			c.setLeftChild(d);
			c.setRightChild(e);
			d.setLeftChild(f);
			d.setRightChild(h);
			e.setRightChild(g);
			b.setLeftChild(x);

			DFS_inOrder(a);
	}

	public static void DFS_inOrder(Node root){
		if (root == null){
			return;
		}
		DFS_inOrder(root.getLeftChild());
		BinaryTreeBreadthFirstTraversal.print(root);
		DFS_inOrder(root.getRightChild());
	}

}
