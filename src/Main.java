import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][]map;
	static List<Integer> result;
	static int answer;
	static int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}}; // 사방 탐색
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  null;
		N = Integer.parseInt(br.readLine());
		answer = 0;
		map = new int[N][N];
		int min = 100;
		int max = 0; // 읽어 들이는 map에서 가장 높은 영역
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j]) {
					max = map[i][j];
				}
				
			}
		}
		for(int k = 1; k <max; k++) { // 최소 높이부터 최대 높이까지 침수 되는 영역을 전부 파악하여 최대 큰 값을 answer에 대입.
			List<Integer>tlist = new ArrayList<>(); // 장마로 인해 침수되는 높이가 k일대 안전영역의 개수를 구하기 위한 리스트
			boolean visited[][] = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > k && !visited[i][j]) {
						int temp = dfs(k, visited,new Dot(i,j));
						tlist.add(temp);
					}
				}
			}
			//System.out.println("k:" + k + "영역 크기" + tlist.size());
			// tlist의 사이즈가 침수 높이가 k 일때 나오는 안정영역의 개수
			if(answer < tlist.size()) {
				answer = tlist.size();
			}
		}
		System.out.println(answer);
	}
	// 물의 높이보다 높은 영역만 찾는 dfs 리턴 값으로 살아 남은 한 영역의 크기
	static int dfs(int height, boolean[][]visited, Dot d) {
		Stack<Dot> s = new Stack<>();
		s.push(d);
		List<Dot>list = new ArrayList<>(); // 영역을 임시로 저장하기 위한 리스트
		list.add(d);
		visited[d.r][d.c] = true;
		
		while(!s.isEmpty()) {
			Dot top = s.pop();
			
			for(int i = 0; i < 4; i++) {
				int nr = top.r + dirs[i][0];
				int nc = top.c + dirs[i][1];
				
				if(isIn(nr,nc) && !visited[nr][nc] &&map[nr][nc] > height) {
					s.push(new Dot(nr,nc));
					visited[nr][nc] = true;
					list.add(new Dot(nr, nc));
				}
			}
		}
		
		return list.size();
	}
	
	static boolean isIn(int r, int c ) {
		return 0<= r && r<N && 0<=c && c<N;
	}
	
	static class Dot{
		int r;
		int c;
		public Dot(int r, int c) {
			
			this.r = r;
			this.c = c;
		}
		@Override
		
		public String toString() {
			return "Dot [r=" + r + ", c=" + c + "]";
		}
		
	}
}