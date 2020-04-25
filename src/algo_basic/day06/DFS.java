package algo_basic.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
	private static int v = 7;
	private static String src = "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
	private static boolean [] visited; // 방문 여부에 대한 저장
	private static List<Integer>[] graph = new List[v+1];
	private static Stack<Integer> stack = new Stack<>(); // 갈림길 저장을 위한  Stack
	private static List<Integer> path;
	
	public static void makeGraph() { // 리스트 단방향 그래프		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String [] splited = src.split(" ");
		
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			graph[a].add(b);
		}
		for (List<Integer> list : graph) {
			System.out.println(list);
		}
	}
	
	public static void dfsStack(int start) {	
		// 필요한 객체를 초기화해보자
		visited = new boolean[v+1];
		stack = new Stack<>();
		path = new ArrayList<>();
		// 출발점에서 시작
		stack.push(start);
		
		while(!stack.isEmpty()) {
			// top 가져온 후 방문 처리
			Integer top = stack.pop();
			// top의 방문 여부에 따라서 다음 동작
			if(visited[top]) {
				continue;
			} 
			// 미방문 --> 방문 처리			
			visited[top] = true;
			path.add(top);
			// top을 통해서 갈 수 있는 다음 정점?
			List<Integer> childs = graph[top]; // 다음으로 탐색할 후보군 확보
			for (int i = childs.size()-1; i >= 0; i--) {
				Integer child = childs.get(i); // 다음에 가볼 집.. 언제나 방문?
				if(!visited[child]) {
					stack.push(child);						
				}
			}						
		}
		System.out.println("탐색 종료 : 경로는 : " + path);
	}
	
	public static void dfsRecur(int start) {
		// top 가져온 후 방문 처리
		if(!visited[start]) {
			// 방문 처리
			visited[start] = true;
			path.add(start);
			List<Integer> childs = graph[start];
			for (int i = 0; i < childs.size(); i++) {
				int child = childs.get(i);
				if(!visited[child]) {
					dfsRecur(child);
				}
			}
		}
	}
	public static void main(String[] args) {
		makeGraph();	
		//dfsStack(1);
		visited = new boolean[v+1];
		path = new ArrayList<>();
		dfsRecur(1);
		System.out.println("탐색 종료 : 경로는 : " + path);
	}
}
