package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_18796_R5_이동하기4 {
	static int N;
	static int M;
	static long [] A;
	static long [] B;
	static long min = Long.MAX_VALUE;
	private static int[][] dirs = { { 1, 0 }, { 0, 1 }};

	static int front;
	static int rear;
	static int MAX_N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		A = new long [N+1];
		B = new long [M+1];

		
		temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < N+1; i++) {
			A[i] = Integer.parseInt(temp.nextToken());
		}
		temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < M+1; i++) {
			B[i] = Integer.parseInt(temp.nextToken());	
		}
		MAX_N = (N+1)*(M+1);
		BFS();
		System.out.println(min);
		
	}
	
	static void BFS() {
		queueInit();
		queueEnqueue(new Point(0,0,0));

		while(!queueIsEmpty()) {
			Point t = queueDequeue();
			if(t.i == N && t.j == M) {
				min = Math.min(min, t.count);
			}
			for (int i = 0; i < dirs.length; i++) {
				int x = t.i+dirs[i][0];
				int y = t.j+dirs[i][1];
				if(isIn(x,y)) {
					if(i == 0 && t.count+B[t.j] < min) {
						queueEnqueue(new Point(x,y,t.count+B[t.j]));
					}else if(i == 1 &&t.count+A[t.i] < min){
						queueEnqueue(new Point(x,y,t.count+A[t.i]));
					}
					
				}
			}
		}
	}
	static class Point {
		int i;
		int j;
		long count;

		public Point(int i, int j, long count) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
		}

	}
	private static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i <= N && j <= M;
	}


	static Point queue[];

	static void queueInit()
	{
		front = 0;
		rear = 0;
		queue = new Point[MAX_N];
	}

	static boolean queueIsEmpty()
	{
		return (front == rear);
	}
	
	static int queueSize()
	{
		return rear-front;
	}


	static boolean queueIsFull()
	{
		if ((rear + 1) % MAX_N == front)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	static boolean queueEnqueue(Point point)
	{
		if (queueIsFull())
		{
			System.out.print("queue is full!");
			return false;
		}
		queue[rear] = point;
		rear++;
		if (rear == MAX_N)
		{
			rear = 0;
		}

		return true;
	}

	static Point queueDequeue()
	{
		if (queueIsEmpty()) 
		{
			System.out.print("queue is empty!");
			return null;
		}

		Point value = queue[front];

		front++;
		if (front == MAX_N)
		{
			front = 0;
		}
		return value;
	}

}
