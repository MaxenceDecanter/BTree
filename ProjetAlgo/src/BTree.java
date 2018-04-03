import java.util.*;

public class BTree {
	
	List<Integer> listKey = new ArrayList<Integer>();
	List<BTree> listChildren = new ArrayList<BTree>();
	int n =2;
	BTree treeToSearchIn;
	boolean res = false;
	BTree returnTree;
	BTree previousTree = null;
	
	public BTree(List<Integer> keys, List<BTree> tree){
		this.listKey = keys;
		this.listChildren = tree;
	}
	
	public void createBTree(int key, BTree tree){
		tree.addKey(key);
	}
	
	public void printBTree(BTree tree){
		System.out.println("Valeurs du noeud:");
		for(int i=0; i<tree.listKey.size();i++){
			System.out.println(tree.getKey(i));
		}
		if(!tree.isLeaf(tree)){
			for(int i=0; i<tree.listChildren.size();i++){
				printBTree(tree.getChild(i));
			}
		}
	}
	
	public void updateOrder(int n){
		this.n = n;
	}
	
	public int getKey(int index){
		return listKey.get(index);
	}
	
	public BTree getChild(int index){
		return listChildren.get(index);
	}
	
	public List<Integer> getKeys(BTree tree){
		return tree.listKey;
	}
	
	public void addKey(int value){
		listKey.add(value);
	}
	
	public void addKeyWithIndex(int key, int index){
		listKey.add(index, key);
	}
	
	public void addChild(BTree child){
		this.listChildren.add(child);
	}
	
	public void addChildWithIndex(int index, BTree tree){
		listChildren.add(index, tree);
	}
	
	public void removeKey(int index){
		listKey.remove(index);
	}
	
	public void removeChild(int index){
		listChildren.remove(index);
	}
	
	public void removeChildTree(BTree tree, BTree treeToRemove){
		for(int i=0; i<tree.listChildren.size(); i++){
			if(tree.getChild(i) == treeToRemove){
				tree.removeChild(i);
			}
		}
	}
	
	public boolean isLeaf(BTree tree){
		if(tree.listChildren.isEmpty()){
			return true;
		}
		return false;
	}
	
	public boolean canAddKey(BTree tree){
		if(tree.listKey.size()<n){
			return true;
		}
		return false;
	}
	
	public boolean canAddChild(BTree tree){
		if(tree.listChildren.size()<n+1){
			return true;
		}
		return false;
	}
	
	public boolean isInKey(int value, BTree tree){
		if(tree.listKey.contains(value)){
			return true;
		}
		return false;
	}
	
	public void toString(BTree tree){
		String res="Valeurs noeud: ";
		int i =0;
		while(i < tree.getKeys(tree).size()){
			res = res + tree.getKey(i);
			i++;
		}
		System.out.println(res);
	}
	
	public boolean search(int key, BTree tree){
		//boolean res=false;
		if(tree == null){
			res=false;
		}else if(key < tree.getKey(0)&& !tree.isLeaf(tree)){
			search(key, tree.getChild(0));
		}else if(key> tree.getKey(tree.listKey.size()-1) && !tree.isLeaf(tree)){
			search(key, tree.getChild(tree.listKey.size()));
		}else if(key> tree.getKey(tree.listKey.size()-1) && tree.isLeaf(tree)){
			return false;
		}else if(searchInNode(key,tree)==true){
			res=true;
		}else{
			if(!tree.isLeaf(tree)){
				search(key,treeToSearchIn);
			}else{
				res = false;
			}
		}
		return res;
	}
	
	public boolean searchInNode(int key, BTree tree){
		int g = 0;
		int d = tree.listKey.size();
		int m = 0;
		
		while(g!=d){
			m = (g+d)/2;
			if(tree.getKey(m) >= key){
				d = m;
			}else{
				g = m+1;
			}
		}
		
		if(tree.getKey(g)==key){
			treeToSearchIn = null;
			return true;
		}else if(!tree.isLeaf(tree)){
			treeToSearchIn = tree.getChild(g);
		}
		return false;
	}
	
	public BTree insertPosition(int key, BTree tree){
		if(tree==null){
			returnTree = tree;
		}
		
		return returnTree;
	}
	
	public void split(BTree tree){
		int medianIndex;
		if(tree.listKey.size()<n){
			previousTree = tree;
			if(!tree.listChildren.isEmpty()){
				for(int i=0; i<tree.listChildren.size(); i++){
					split(tree.getChild(i));
				}
			}
		}else if(tree.listKey.size()==n){
			medianIndex = tree.listKey.size()/2;
			
			BTree left = new BTree(new ArrayList<Integer>(), new ArrayList<BTree>());
			for(int i=0; i<medianIndex; i++){
				left.addKey(tree.getKey(i));
			}
			if(!tree.listChildren.isEmpty()){
				for(int j=0; j<=medianIndex; j++){
					BTree t = tree.getChild(j);
					left.addChild(t);
				}
			}
			
			BTree right = new BTree(new ArrayList<Integer>(), new ArrayList<BTree>());
			for(int i=medianIndex+1; i<tree.listKey.size(); i++){
				right.addKey(tree.getKey(i));
			}
			if(!tree.listChildren.isEmpty()){
				for(int j=medianIndex+1; j<tree.listChildren.size(); j++){
					BTree t = tree.getChild(j);
					right.addChild(t);
				}
			}
			
			if(previousTree == null){
				BTree root = new BTree(new ArrayList<Integer>(), new ArrayList<BTree>());
				root.addKey(tree.getKey(medianIndex));
				root.addChild(left);
				root.addChild(right);
				previousTree = root;
			}else{
				previousTree.addKey(tree.getKey(medianIndex));
				previousTree.removeChildTree(previousTree, tree);
				previousTree.addChild(left);
				previousTree.addChild(right);
			}
		}
	}
	
	public void insertKeyInNode(BTree tree, int key, int index){
		tree.addKeyWithIndex(key, index);
	}
	
	public void insertTreeInNode(BTree tree, BTree treeToInsert, int index){
		tree.addChildWithIndex(index, treeToInsert);
	}
	
	public void insert(int key, BTree tree){
		if(key < tree.getKey(0)&& !tree.isLeaf(tree)){
			insert(key, tree.getChild(0));
		}else if(key> tree.getKey(tree.listKey.size()-1) && !tree.isLeaf(tree)){
			insert(key, tree.getChild(tree.listKey.size()));
		}else if(tree.isLeaf(tree)){
			tree.addKey(key);
		}else{
			for(int i=1; i<tree.listKey.size()-1; i++){
				if(key<tree.getKey(i)){
					tree.getChild(i).addKey(key);
				}else if(key>tree.getKey(i) && i==tree.listKey.size()-2){
					tree.getChild(i+1).addKey(key);
				}
			}
		}
	}

}
