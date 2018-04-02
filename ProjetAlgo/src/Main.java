import java.util.*;

public class Main {
	
	public static void main(String[] args){
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(51);
		BTree root = new BTree(l1,new ArrayList<BTree>());
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(11);
		l2.add(30);
		BTree tree1 = new BTree(l2,new ArrayList<BTree>());
		root.addChild(tree1);
		
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(66);
		l3.add(71);
		l3.add(78);
		BTree tree2 = new BTree(l3, new ArrayList<BTree>());
		root.addChild(tree2);
		
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(2);
		l4.add(7);
		BTree tree3 = new BTree(l4,new ArrayList<BTree>());
		tree1.addChild(tree3);
		
		List<Integer> l5 = new ArrayList<Integer>();
		l5.add(12);
		l5.add(15);
		l5.add(22);
		BTree tree4 = new BTree(l5,new ArrayList<BTree>());
		tree1.addChild(tree4);
		
		List<Integer> l6 = new ArrayList<Integer>();
		l6.add(35);
		l6.add(41);
		BTree tree5 = new BTree(l6,new ArrayList<BTree>());
		tree1.addChild(tree5);
		
		List<Integer> l7 = new ArrayList<Integer>();
		l7.add(53);
		l7.add(54);
		l7.add(63);
		BTree tree6 = new BTree(l7,new ArrayList<BTree>());
		tree2.addChild(tree6);
		
		List<Integer> l8 = new ArrayList<Integer>();
		l8.add(68);
		l8.add(69);
		BTree tree7 = new BTree(l8,new ArrayList<BTree>());
		tree2.addChild(tree7);
		
		List<Integer> l9 = new ArrayList<Integer>();
		l9.add(75);
		l9.add(76);
		BTree tree8 = new BTree(l9,new ArrayList<BTree>());
		tree2.addChild(tree8);
		
		List<Integer> l10 = new ArrayList<Integer>();
		l10.add(79);
		l10.add(84);
		l10.add(93);
		BTree tree9 = new BTree(l10,new ArrayList<BTree>());
		tree2.addChild(tree9);
		
		//root.toString(root);
		root.printBTree(root);
		System.out.println(root.search(8,root));
		root.insert(70, root);
		root.insert(77, root);
		root.printBTree(root);
		//root.split(root);
		
		
	}

}
