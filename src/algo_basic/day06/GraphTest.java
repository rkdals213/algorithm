package algo_basic.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphTest {
	private static int v = 6;
	private static int v1 = 7;
	private static String src = "1 2 1 5 2 5 5 4 2 4 4 3 4 6 2 6";
	private static String src2 = "1 2 2 1 5 7 2 5 5 5 4 7 2 4 4 4 3 1 4 6 3 2 3 2";
	private static String src3 = "1 2 1 3 1 6 1 7 6 4 6 5 5 4 7 5";
	private static String src4 = "1 2 2 1 3 4 1 6 1 1 7 3 6 4 6 6 5 1 5 4 2 7 5 4";
	private static int [][] graph = new int [v+1][v+1];
	
	public static void makeGraph1() { // 양방향 그래프
		String [] splited = src.split(" ");
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
	}
	public static void makeGraph2() { // 단방향 그래프
		String [] splited = src.split(" ");
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			
			graph[a][b] = 1;
		}
	}
	public static void makeGraph3() { // 단방향 가중치 그래프
		String [] splited = src2.split(" ");
		for (int i = 0; i < splited.length; i+=3) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			int c = Integer.parseInt(splited[i+1]);
			
			graph[a][b] = c;
		}
	}
	public static void makeGraph4() { // 리스트 양방향 그래프
		List<Integer>[] graph = new List[v1+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String [] splited = src3.split(" ");
		
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		for (List<Integer> list : graph) {
			System.out.println(list);
		}
	}
	public static void makeGraph5() { // 리스트 단방향 그래프
		List<Integer>[] graph = new List[v1+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String [] splited = src3.split(" ");
		
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			graph[a].add(b);
		}
		for (List<Integer> list : graph) {
			System.out.println(list);
		}
	}
	public static void makeGraph6() { // 리스트 단방향 가중치 ,그래프
		List<Point>[] graph = new List[v1+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String [] splited = src4.split(" ");
		
		for (int i = 0; i < splited.length; i+=3) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			int w = Integer.parseInt(splited[i+2]);
			graph[a].add(new Point(b, w)); // 단순 Integer가 아닌 Point를 저장
		}
		for (List<Point> list : graph) {
			System.out.println(list);
		}
	}
	
	 // 정점과 가중치 정보를 저장할 사용자 정의 클래스
	static class Point{
		int vId;
		int weight;
		public Point(int vId, int weight) {
			super();
			this.vId = vId;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "[vId=" + vId + ", weight=" + weight + "]";
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		makeGraph6();
//		for (int [] row : graph) {
//			System.out.println(Arrays.toString(row));
//		}

	}

}
