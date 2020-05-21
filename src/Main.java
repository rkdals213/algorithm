import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int result = 0;
	static int [] wordBit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(temp.nextToken());
		K = Integer.parseInt(temp.nextToken());
		wordBit = new int [N];
		int defaultBitMask = makeBitMask("antci");
		
		for (int i = 0; i < N; i++) {
			String t = br.readLine();
			wordBit[i] = makeBitMask(t);
		}		
		
		DFS(0, 0, defaultBitMask);
		
		System.out.println(result);
	}
	
	static int makeBitMask(String k) {
		int res = 0;
		int len = k.length();
		for (int i = 0; i < len; i++) {
			res |= 1 << k.charAt(i) - 'a';
		}
		return res;
	}

	static void DFS(int cur, int start, int defaultBitMask) {
		if(cur == K-5) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if((wordBit[i] | defaultBitMask) == defaultBitMask) {
					cnt++;
				}
			}
			result = Math.max(result, cnt);
		}
		for (int i = start; i < 26; i++) {
			if((defaultBitMask & (1<<i)) == 0) {
				DFS(cur+1, i, defaultBitMask | (1<<i));
			}
		}
	}
}
