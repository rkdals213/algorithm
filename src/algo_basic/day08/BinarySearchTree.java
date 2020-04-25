package algo_basic.day08;

public class BinarySearchTree {
	private static Node root; // root 노드
	static class Node{
		int v;
		Node left, right, parent;
		
		public Node(int v) {
			super();
			this.v = v;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[" + v + "(");
			if(left!=null) {
				sb.append(left.v).append(",");
			}else {
				sb.append("n").append(",");
			}
			if(right!=null) {
				sb.append(right.v);
			}else {
				sb.append("n");
			}
			sb.append(")]");
			return sb.toString();
		}		
	}
	
	public static boolean addNode(int v) {
		// 새 노드를 추가하려면 검색에 실패해야 한다!		
		
		if(root == null) {
			root = new Node(v);
			return true;
		}
		Node current = root;
		while(true) {
			if(current.v == v) { // 검색 성공은 추가 실패 / 중복
				return false;
			}else if(current.v > v) { // 현재 노드의 값보다 새로 들어온 녀석이 크면, 왼쪽에 관심 갖기
				if(current.left == null) { // 왼쪽 노드가 비어있다면? 삽입될 위치
					Node newNode = new Node(v);
					newNode.parent = current; // 삭제시 부모를 쉽게 찾기 위해 부모 추가
					current.left = newNode;
					return true;
				}else { // 비어있지 않다면 왼쪽 노드를 이용해서 다시 탐색
					current = current.left;
				}				
			}else if(current.v < v) {
				if(current.right == null) { // 왼쪽 노드가 비어있다면? 삽입될 위치
					Node newNode = new Node(v);
					newNode.parent = current;
					current.right = newNode;
					return true;
				}else { // 비어있지 않다면 왼쪽 노드를 이용해서 다시 탐색
					current = current.right;
				}	
			}
		}
	}
	
	public static Node search(int v) {		
		if(root == null) {
			return null;
		}
		
		Node current = root;
		while(true) {
			if(current == null) {
				return null;
			}
			if(current.v == v) { // 검색 성공
				return current;
			}else if(current.v > v) {				
				current = current.left;			
			}else if(current.v < v) {					
				current = current.right;							
			}
		}
	}
	
	public static boolean deleteNode(int v) {
		Node target = search(v);
		if(target == null) {
			return false;
		}else {			
			if(target.left == null && target.right == null) { // 자식이 없는 경우
				if(target.parent.left == target) {
					target.parent.left = null;
				}else {
					target.parent.right = null;
				}
			}else if(target.left == null || target.right == null) { // 자식이 하나만 있는 경우
				Node child = target.left==null? target.right: target.left;
				// 부모에게 자식 위탁
				if(target.parent.left == target) {
					target.parent.left = child;
				}else {
					target.parent.right = child;
				}
			}else { // 자식이 둘인 경우
				// 1. 왼쪽 트리에서 가장 큰놈을 찾는다 - 왼쪽의 서브트리에서 right가 null인 노드
				Node max = target.left;
				while(max.right != null) {
					max = max.right;
				}
				// 2. 대상 노드를 지워버리고 
				deleteNode(max.v);
				// 3. 삭제 대상 노드의 값을 최대 노드의 값으로 변경
				target.v = max.v;
			}			
		}
		return true;
	}
	
	public static void main(String[] args) {
		addNode(10);
		addNode(5);
		System.out.println(search(3));
		addNode(6);
		addNode(2);
		addNode(4);
		addNode(0);
		addNode(3);
		System.out.println(search(5));
		System.out.println(search(1));
		System.out.println(search(10));
		deleteNode(5);
		System.out.println(search(4));
		System.out.println(search(2));
	}
}
