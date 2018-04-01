import java.util.*;

public class Main {
	
	public static void main(String[] args){
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		l1.add(4);
		BTree root = new BTree(l1,new ArrayList<BTree>());
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		BTree tree1 = new BTree(l2,new ArrayList<BTree>());
		root.addChild(tree1);
		
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(3);
		BTree tree2 = new BTree(l3, new ArrayList<BTree>());
		root.addChild(tree2);
		
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(5);
		l4.add(6);
		BTree tree3 = new BTree(l4,new ArrayList<BTree>());
		root.addChild(tree3);
		
		root.toString(root);
		System.out.println(1/2);
		System.out.println(root.search(8,root));
		
	}

}
