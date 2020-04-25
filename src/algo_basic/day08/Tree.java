package algo_basic.day08;

import java.util.Arrays;

public class Tree {
	private static Node [] tree;
	private static String data = "1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
	private static int V = 13;

	static class Node {
		Node left;
		Node right;
		int v;
		public Node(int v) {
			super();
			this.v = v;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[" + v + "(");
			if(left!=null) {
				sb.append(left.v).append(",");
			}
			if(right!=null) {
				sb.append(right.v);
			}
			sb.append(")]");
			return sb.toString();
		}		
	}
	
	public static void main(String[] args) {
		makeTree();
		System.out.println(Arrays.toString(tree));
		System.out.println("preorder");
		preOrder(tree[1]);
		System.out.println();
		System.out.println("postorder");
		postOrder(tree[1]);
		System.out.println();
		System.out.println("inorder");
		inOrder(tree[1]);		
	}
	
	private static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);					
		System.out.print(node.v + " ");		
		inOrder(node.right);
	}

	private static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);		
		postOrder(node.right);	
		System.out.print(node.v + " ");		
	}

	private static void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.v + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void makeTree() {
		tree = new Node[V + 1];
		String [] splited = data.split(" ");
		for (int i = 0; i < splited.length; i+=2) {
			
			int parent = Integer.parseInt(splited[i]);
			int child = Integer.parseInt(splited[i+1]);
			
			Node pNode = getNode(parent);
			Node cNode = getNode(child);
			
			if(pNode.left==null){
				pNode.left = cNode;
			}else {
				pNode.right = cNode;
			}
		}
	}
	
	private static Node getNode(int idx)  {
		if(tree[idx] == null) {
			tree[idx] = new Node(idx);
		}
		return tree[idx];
	}

}
