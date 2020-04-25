package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_PokerGame {
	// S,D,H,C / A=1,T=10,J=11,Q=12,K=13
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer tokens = new StringTokenizer(br.readLine());
			char[] suits = new char[5];
			int[] ranks = new int[5];
			for(int i=0; i<5; i++) {
				String c = tokens.nextToken();
				suits[i] = c.charAt(0); 
				char cc = c.charAt(1); 
				if(cc=='A')
					ranks[i] = 1;
				else if(cc=='T')
					ranks[i] = 10;
				else if(cc=='J')
					ranks[i] = 11;
				else if(cc=='Q')
					ranks[i] = 12;
				else if(cc=='K')
					ranks[i] = 13;
				else
					ranks[i] = cc-'0'; 
			}

			boolean suit = checkSuit(suits);
			int rank = checkRank(ranks);

			if(suit && rank==0) sb.append("Straight Flush");
			else if(rank==1) sb.append("Four of a Kind");
			else if(rank==2) sb.append("Full House");
			else if(suit) sb.append("Flush");
			else if(!suit && rank==0) sb.append("Straight");
			else if(rank==3) sb.append("Three of a kind");
			else if(rank==4) sb.append("Two pair");
			else if(rank==5) sb.append("One pair");
			else sb.append("High card");
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static boolean checkSuit(char[] suit) {
		for(int i=0; i<4; i++) {
			if(suit[i] != suit[i+1])
				return false;
		}
		return true;
	}

	public static int checkRank(int[] rank) {
		Arrays.sort(rank);
		int f = 0;
		for(int i=0; i<4; i++) {
			if(rank[0]==1 && rank[1]==10)
				continue;
			if(rank[i+1] != rank[i]+1) {
				f = 1;
				break;
			}
		}

		if(f == 1) {
			int[] same = {1, 1, 1, 1, 1};
			int check = 0;
			for(int i=0; i<4; i++) {
				if(rank[i] == rank[i+1])
					same[check]++;
				else
					check++;
			}

			Arrays.sort(same);
			if(same[4] == 4)
				return 1;
			else if(same[4] == 3 && same[3] == 2)
				return 2;
			else if(same[4] == 3)
				return 3;
			else if(same[4] == 2 && same[3] == 2)
				return 4;
			else if(same[4] == 2)
				return 5;
			else
				return 6;
		}
		else
			return 0;
	}
}
