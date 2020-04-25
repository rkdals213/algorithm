package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_17281_G4_야구 {
	static ArrayList<int []> list = new ArrayList<int []>();
	static ArrayList<int []> batting = new ArrayList<int []>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		for (int i = 0; i <N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int [] bat = new int [9];
			for (int j = 0; j < 9; j++) {
				bat[j] = Integer.parseInt(temp.nextToken());
			}
			batting.add(bat.clone());
		}	

		perm(9, 0, new boolean [8], new int [8]);

		for (int j = 0; j < list.size(); j++) {
			int num = 0;
			int score = 0;
			for (int i = 0; i < N; i++) {
				int outCount = 0;			
				queueInit();
				while(outCount < 3){					
					int hit = batting.get(i)[list.get(j)[num%9]];
					if(hit == 0) {
						outCount++;
					}else if(hit == 1){
						queueEnqueue(1);
						while(queueSize() > 3) {
							score += queueDequeue();
						}
					}else if(hit == 2){
						queueEnqueue(1);
						queueEnqueue(0);
						while(queueSize() > 3) {
							score += queueDequeue();
						}
					}else if(hit == 3){
						queueEnqueue(1);
						queueEnqueue(0);
						queueEnqueue(0);
						while(queueSize() > 3) {
							score += queueDequeue();
						}
					}else if(hit == 4){
						queueEnqueue(1);
						while(!queueIsEmpty()) {
							score += queueDequeue();
						}
					}
					num++;
				}			
			}
			if(score > max) {
				max = score;
			}			
		}
		System.out.println(max);	


	}
	static void perm(int depth, int current, boolean [] visited, int [] result) {
		if(depth-1 == current) {
			int [] result1 = new int [9];
			for (int i = 0; i < 3; i++) {
				result1[i] = result[i];
			}
			for (int i = 4; i < result1.length; i++) {
				result1[i] = result[i-1];
			}
			list.add(result1.clone());
		}else {
			for (int i = 0; i < 8; i++) {
				if(!visited[i]) {
					visited[i] = true;
					result[current] = i+1;
					perm(depth, current+1, visited, result);
					visited[i] = false;
				}
			}
		}
	}


	static final int MAX_N = 100;

	static int front;
	static int rear;
	static int queue[] = new int[MAX_N];

	static void queueInit()
	{
		front = 0;
		rear = 0;
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

	static boolean queueEnqueue(int value)
	{
		if (queueIsFull())
		{
			System.out.print("queue is full!");
			return false;
		}
		queue[rear] = value;
		rear++;
		if (rear == MAX_N)
		{
			rear = 0;
		}

		return true;
	}

	static Integer queueDequeue()
	{
		if (queueIsEmpty()) 
		{
			System.out.print("queue is empty!");
			return null;
		}

		Integer value = new Integer(queue[front]);

		front++;
		if (front == MAX_N)
		{
			front = 0;
		}
		return value;
	}
}
