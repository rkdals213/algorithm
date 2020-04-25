package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_15684_G5_사다리조작 {
	static int N;
	static int M;
	static int H;
	static boolean [] ladder;
	static List<Point> list;
	static List<Point> list2;
	static int result = Integer.MAX_VALUE;
	static boolean flag;
	static List<int []> permlist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		H = Integer.parseInt(temp.nextToken());
		ladder = new boolean [(N-1)*H];
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(temp.nextToken());
			int start = Integer.parseInt(temp.nextToken());			
			int location = ((x-1)*(N-1))+(start-1);
			if(location+1 < ((location/(N-1))+1)*(N-1)) {
				ladder[location+1] = true;
			}
			if(location-1 >= (location/(N-1))*(N-1)) {
				ladder[location-1] = true;
			}
			ladder[location] = true;
			list.add(new Point(x, start, start+1));
			list.add(new Point(x, start+1, start));
		}

		for (int i = 0; i < 4; i++) {
			
			permlist = new ArrayList<>();
			perm(0, i, new int [i], 0);
			for (int j = 0; j < permlist.size(); j++) {
				list2 = new ArrayList<>();
				for (int a = 0; a < list.size(); a++) {
					list2.add(list.get(a));
				}
				move(permlist.get(j));
				if(flag) {
					System.out.println(i);
					return;
				}
			}
		}
		
		System.out.println(-1);


	}

	static void perm(int r, int depth, int [] result, int start) {
		if(r==depth) {
			int [] a = result.clone();
			permlist.add(a);

		}else {
			for (int i = start; i < ladder.length; i++) {
				if(!ladder[i]) {					
					int location = i;
					if(location+1 < ((location/(N-1))+1)*(N-1)) {
						ladder[location+1] = true;
					}
					if(location-1 >= (location/(N-1))*(N-1)) {
						ladder[location-1] = true;
					}

					ladder[i] = true;
					result[r] = i;
					perm(r+1, depth, result, i);
					ladder[i] = false;
					if(location+1 < ((location/(N-1))+1)*(N-1)) {
						ladder[location+1] = false;
					}
					if(location-1 >= (location/(N-1))*(N-1)) {
						ladder[location-1] = false;
					}
				}
			}
		}
	}

	static void move(int [] input) {		
		for (int i = 0; i < input.length; i++) {
			int x = (input[i] / (N-1)) + 1;
			int y = (input[i] % (N-1)) + 1;
			list2.add(new Point(x, y, y+1));
			list2.add(new Point(x, y+1, y));
		}

		list2.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				Integer x1 = o1.x;
				Integer x2 = o2.x;
				return x1.compareTo(x2);
			}
		});

		int k = list2.size();

		for (int i = 1; i <= N; i++) {
			int startingpoint = i;
			int startingx = -1;
			for (int j = 0; j < k; j++) {
				if(startingx < list2.get(j).x) {
					if(list2.get(j).start == startingpoint) {
						startingpoint = list2.get(j).to;
						startingx = list2.get(j).x;				
					}
				}
			}
			if(startingpoint==i) {
				flag = true;
			}else {
				flag = false;
				return;
			}
		}
	}


	static class Point{
		int x;
		int start;
		int to;

		public Point(int x, int start, int to) {
			super();
			this.x = x;
			this.start = start;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", start=" + start + ", to=" + to + "]";
		}
	}
}
