package algorithm_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Pro_Line_CodingTest04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] snapshots = {
				{"ACCOUNT1", "100"},
				{"ACCOUNT2", "150"},
				{"ACCOUNT10", "150"}
		};
		String [][] transactions = {
				{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"},
				{"1", "SAVE", "ACCOUNT2", "100"},
				{"4", "SAVE", "ACCOUNT3", "500"},
				{"3", "WITHDRAW", "ACCOUNT2", "30"}
		};
		System.out.println(solution(snapshots, transactions));
	}

	static public String[][] solution(String[][] snapshots, String[][] transactions) {
		String[][] answer = {};
		
		Map<String, Integer> map= new TreeMap<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < snapshots.length; i++) {
			map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
		}
		
		for (int i = 0; i < transactions.length; i++) {
			String id = transactions[i][0];
			String action = transactions[i][1];
			String account = transactions[i][2];
			int money = Integer.parseInt(transactions[i][3]);
			
			if(list.contains(id)) {
				continue;
			}else {
				list.add(id);
				if(map.containsKey(account)) {
					if(action.equals("SAVE")) {
						int temp = map.get(account);
						map.replace(account, temp+money);
					}else {
						int temp = map.get(account);
						map.replace(account, temp-money);
					}
				}else {
					map.put(account, money);
				}
			}
		}
		int c = 0;
		answer = new String[map.size()][2];
		for (Map.Entry<String, Integer> t : map.entrySet()) {
			answer[c][0] = t.getKey();
			answer[c][1] = t.getValue()+"";
			c++;
		}
//		System.out.println(map);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
		return answer;
	}

}
