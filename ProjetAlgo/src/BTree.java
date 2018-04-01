import java.util.*;

public class BTree {
	
	List<Integer> listKey = new ArrayList<Integer>();
	List<BTree> listChildren = new ArrayList<BTree>();
	int n =2;
	BTree treeToSearchIn;
	boolean res = false;
	
	public BTree(List<Integer> keys, List<BTree> tree){
		this.listKey = keys;
		this.listChildren = tree;
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
	
	public void addChild(BTree child){
		this.listChildren.add(child);
	}
	
	public void removeKey(int index){
		listKey.remove(index);
	}
	
	public void removeChild(int index){
		listChildren.remove(index);
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
			System.out.println("Parcours du fils 0");
			search(key, tree.getChild(0));
		}else if(key> tree.getKey(tree.listKey.size()-1) && !tree.isLeaf(tree)){
			System.out.println("Parcours du fils n");
			search(key, tree.getChild(tree.listKey.size()));
		}else if(key> tree.getKey(tree.listKey.size()-1) && tree.isLeaf(tree)){
			return false;
		}else if(searchInNode(key,tree)==true){
			System.out.println("Clause search vraie");
			res=true;
		}else{
			if(!tree.isLeaf(tree)){
				System.out.println(treeToSearchIn);
				search(key,treeToSearchIn);
			}else{
				res = false;
			}
		}
		System.out.println("res="+res);
		return res;
	}
	
	public boolean searchInNode(int key, BTree tree){
		System.out.println("Recherche dans noeud");
		int g = 0;
		int d = tree.listKey.size();
		System.out.println("d init="+d);
		int m = 0;
		
		while(g!=d){
			m = (g+d)/2;
			System.out.println("m="+m);
			if(tree.getKey(m) >= key){
				d = m;
				System.out.println("d="+d);
			}else{
				g = m+1;
				System.out.println("g="+g);
			}
		}
		
		if(tree.getKey(g)==key){
			System.out.println("Clause dans noeud vrai");
			treeToSearchIn = null;
			return true;
		}else if(!tree.isLeaf(tree)){
			System.out.println("Abre a parcourir");
			treeToSearchIn = tree.getChild(g);
			System.out.println(treeToSearchIn);
		}
		return false;
	}

}
