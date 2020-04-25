package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_5014_G5_스타트링크 {
	static int F; // 건물의 층수 : 10
	static int S; // 현재 위치 : 1
	static int G; // 타겟 위치 : 10
	static int U; // 위로가는 층수
	static int D; // 내려가는 충수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		F = Integer.parseInt(temp.nextToken());
		S = Integer.parseInt(temp.nextToken());
		G = Integer.parseInt(temp.nextToken());
		U = Integer.parseInt(temp.nextToken());
		D = Integer.parseInt(temp.nextToken());
		boolean [] visited = new boolean[F+1];
		visited[0] = true;
		if(S==G) {
			System.out.println(0);
			return;
		}
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(S,0));
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			if(t.x == G) {
				System.out.println(t.y);
				return;
			}
			if(t.x+U <= F && !visited[t.x+U]) {
				queue.add(new Point(t.x+U, t.y+1));
				visited[t.x+U] = true;
			}
			if(t.x-D>0 && !visited[t.x-D]) {
				queue.add(new Point(t.x-D, t.y+1));
				visited[t.x-D] = true;
			}
		}
		System.out.println("use the stairs");		
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}

}
