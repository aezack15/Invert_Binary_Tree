//Grind 75 problem 6
//makes a BST with user generated list and inverts it

import java.util.*;

class Invert_Binary_Tree_6{

	public TreeNode root;
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val;
			this.right = right;
			this.left = left;
		}
	}

	public static void main(String[] args){
		Invert_Binary_Tree_6 ibt = new Invert_Binary_Tree_6();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Binary tree data '[x,y,z]': root = ");
		String s = in.next();
		s = s.toLowerCase();
		char[] tree = s.toCharArray();
		ArrayList<Integer> x = new ArrayList<Integer>();
		for(int i = 0; i<tree.length; i++){
			if(Character.isDigit(tree[i])){
				x.add(Character.digit(tree[i],10));
			}
		}
		for(int i=0; i<x.size(); i++){
			ibt.makeTree(x.get(i));
		}
		System.out.print("Normal BST: ");
		ibt.print();
		System.out.println();
		ibt.invertTree();
		System.out.print("Now iverted: ");
		ibt.print();
		System.out.println();
	}
	
	private void makeTree(int x){
		root = makeTreeBST(root, x);
	}
	
	private TreeNode makeTreeBST(TreeNode root, int x){
		if(root == null){
			root = new TreeNode(x, null, null);
			return root;
		}
		if(x < root.val){ 
			root.left = makeTreeBST(root.left, x);
		}
		if(x > root.val){
			root.right = makeTreeBST(root.right, x);
		}
		return root;
	}
	
	private void print(){
		if(root != null){
			System.out.print(root.val + " ");
		}
		printTreeBST(root);
	}
	
	private void printTreeBST(TreeNode root){
		if(root != null){
			if(root.left != null){
				System.out.print(root.left.val + " ");
			}
			if(root.right != null){
				System.out.print(root.right.val + " ");
			}
			printTreeBST(root.left);
			printTreeBST(root.right);
		}
	}
	
	private void invertTree(){
		root = invertTreeBST(root);
	}
	
	private TreeNode invertTreeBST(TreeNode root){
		if(root != null){
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = temp;
			invertTreeBST(root.left);
			invertTreeBST(root.right);
		}
		return root;
	}
}
