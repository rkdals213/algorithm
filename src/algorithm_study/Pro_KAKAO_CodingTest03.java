package algorithm_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro_KAKAO_CodingTest03 {
	static int result;
	static boolean [] pick; 
	static List<int []> set = new ArrayList<>();
	public static void main(String[] args) {
		String [] userid1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String [] userid2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String [] userid3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};

		String [] bannedid1 = {"fr*d*", "abc1**"};
		String [] bannedid2 = {"*rodo", "*rodo", "******"};
		String [] bannedid3 = {"fr*d*", "*rodo", "******", "******"};
		
		System.out.println(solution(userid3, bannedid3));
	}
	static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		pick = new boolean[user_id.length];
		
		List<Integer> [] list = new List[banned_id.length];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < user_id.length; i++) {
			for (int j = 0; j < banned_id.length; j++) {
				if(banned_id[j].length() == user_id[i].length()) {
					boolean f = true;
					for (int k = 0; k < banned_id[j].length(); k++) {
						if(banned_id[j].charAt(k) == '*') continue;
						if(banned_id[j].charAt(k) != user_id[i].charAt(k)) {
							f = false;
							break;
						}
					}
					if(f) {
						list[j].add(i);
					}
				}
			}			
		}
//		System.out.println(Arrays.toString(list));
		DFS(list, 0, new int [list.length]);
//		System.out.println(result);
//		System.out.println(set);
		answer = set.size();
		return answer;
	}
	
	static void DFS(List<Integer> [] list, int count, int [] temp) {
		if(count == list.length) {
			result++;
			int [] t = temp.clone();
			Arrays.sort(t);
//			System.out.println(Arrays.toString(t));		
			
			boolean f = true;
			for (int i = 0; i < set.size(); i++) {
				int c = 0;
				for (int j = 0; j < set.get(i).length; j++) {
					if(t[j] == set.get(i)[j]) {
						c++;
					}
				}
				if(c == set.get(i).length) {
					f = false;
					break;
				}
			}
			if(f) set.add(t);
			return;
		}else {
			for (int i = 0; i < list[count].size(); i++) {
				if(!pick[list[count].get(i)]) {
					pick[list[count].get(i)] = true;
					temp[count] = list[count].get(i);
					DFS(list, count+1, temp);
					pick[list[count].get(i)] = false;
				}
			}
		}
	}

}
