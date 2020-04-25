package algo_basic.day03;

import java.util.Arrays;

public class Babygin {
	public static boolean flag;
	public static void main(String[] args) {
		String [] data = {"667767", "054060", "101123", "235777"};
		int r = 6;
		
		for (int i = 0; i < data.length; i++) {
			boolean [] visited = new boolean[6];
			flag = false;
			getGin(data[i], r, new char [6], 0, visited);
			if(flag) {
				System.out.println(i + "번째 data : babygin");
			}else {
				System.out.println("실패");
			}
		}		
	}
	public static void getGin(String data, int r, char [] temp, int current, boolean [] visited) {
		if(current == r) {
			char[] tem1 = Arrays.copyOfRange(temp, 0, 3);
			char[] tem2 = Arrays.copyOfRange(temp, 3, 6);
			if((run(tem1) || triplet(tem1)) && (run(tem2) || triplet(tem2))) flag = true;
			
		}else {
			for (int i = 0; i < data.length(); i++) {
				if(!visited[i]) {
					visited[i] = true;
					temp[current] = data.charAt(i);					
					getGin(data, r, temp, current+1, visited);
					visited[i] = false;
				}
			}
		}
	}
	public static boolean run(char [] k) {
		if((int)(k[0]) == ((int)(k[1]) + 1) && (int)(k[1]) == ((int)(k[2]) + 1)) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean triplet(char [] k) {
		if(k[0] == k[1] && k[1] == k[2]) {
			return true;
		}
		else {
			return false;
		}
	}
}
