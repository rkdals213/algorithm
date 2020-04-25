package algo_basic.day08;

import java.io.IOException;
import java.util.Scanner;


public class SWEA_1231_D4_중위순회 {
	private static Node [] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
			
		for (int a = 0; a < 10; a++) {
			int TC = s.nextInt();	
			sb.append("#").append(a+1).append(" ");
			tree = new Node[TC + 1];
			for (int i = 0; i <= TC; i++) {
				String input = s.nextLine();
				String [] split = input.split(" ");
				if(split.length == 4){
					int no = Integer.parseInt(split[0]);
					String word = split[1];
					int cno1 = Integer.parseInt(split[2]);
					int cno2 = Integer.parseInt(split[3]);				
					
					Node pNode = getNode(no);
					pNode.src = word;
					Node cNode1 = getNode(cno1);
					Node cNode2 = getNode(cno2);
					
					pNode.left = cNode1;
					pNode.right = cNode2;
					
				}else if(split.length == 3){
					int no = Integer.parseInt(split[0]);
					String word = split[1];
					int cno1 = Integer.parseInt(split[2]);
					
					Node pNode = getNode(no);
					pNode.src = word;
					Node cNode1 = getNode(cno1);
					
					pNode.left = cNode1;
				}else if(split.length == 2){
					int no = Integer.parseInt(split[0]);
					String word = split[1];
					
					Node pNode = getNode(no);	
					pNode.src = word;
				}		
				
				
			}
			inOrder(tree[1]);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	private static void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);					
		sb.append(node.src);	
		inOrder(node.right);
	}
	
	static class Node {
		Node left;
		Node right;
		int v;
		String src;
		public Node(int v) {
			super();
			this.v = v;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[" + v + "(");
			sb.append(src);
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
	
	private static Node getNode(int idx)  {
		if(tree[idx] == null) {
			tree[idx] = new Node(idx);
		}
		return tree[idx];
	}
}
