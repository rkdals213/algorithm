package algorithm_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BAEK_11003_P5_최솟값찾기 {
	static int N,L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		L = Integer.parseInt(temp.nextToken());
		temp = new StringTokenizer(br.readLine());
		Deque deque = new Deque();

		int k=0;
		for (int i = 0; i < N; i++) {
			k = Integer.parseInt(temp.nextToken());			
			while(!deque.isEmpty() && deque.peekLastValue() > k) deque.removeLast();
			deque.addLast(i,k);
            if(!deque.isEmpty() && deque.peekFirstIdx() <= i-L) deque.removeFirst();
            bw.write(deque.peekFirstValue() + " ");
		}
		bw.flush();
		bw.close();
	}


	static class Deque{
		int [] idx;
		int [] value;
		int left, right;

		Deque(){
			idx = new int [N];
			value = new int [N];
			left = right = 0;
		}
		boolean isEmpty() {
			return left == right;
		}

		int peekLastValue() {
			return value[right - 1];
		}

		int peekFirstIdx() {
			return idx[left];
		}

		int peekFirstValue() {
			return value[left];
		}

		void removeLast() {
			if (--right < 0) {
				right = N - 1;
			}
		}

		void removeFirst() {
			if (++left == N) {
				left = 0;
			}
		}

		void addLast(int I, int V) {
			idx[right] = I;
			value[right] = V;
			if (++right == N) {
				right = 0;
			}
		}
	}
}
