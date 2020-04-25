package algo_ad.day01;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class P103_Change_Greedy {
	private static int [][] coins = {{500,100,50,10},{500,400,100,50,10}};
	public static void main(String[] args) {
		int price = 1200;
		int money = 2000;
		// 거스름돈을 위한 최소 동전 개수는?
		int target = money - price;
		for (int i = 0; i < coins.length; i++) {
			int [] coinSet = coins[i];
			System.out.println("사용할 동전 조합 : " + Arrays.toString(coinSet));
			// 바꿔준 돈
			int change = 0;
			// 사용한 동전 저장용
			TreeMap<Integer, Integer>  tmap = new TreeMap<>();
			for (int j = 0; j < coinSet.length; j++) {
				// step 1 : 해 선택 - 가장 큰 단위의 동전부터 빼본다
				change += coinSet[j];
				handleMap(tmap, coinSet[j], 1);
				// step 2 : 실행 가능성 검사	
				if(change > target) { // 너무 많이 빼줌 - 동전 회수 및 다음 동전 시도
					change -= coinSet[j];
					handleMap(tmap, coinSet[j], -1);
					continue;
				}
				// step 3 : 해검사
				if(change < target) { // 아직 덜 빼줌
					j--;
				}else {
					break;
				}
			}
			System.out.println(tmap);
		}
	}
	
	public static void handleMap(Map<Integer, Integer> map, Integer key, Integer val) {
		if(map.containsKey(key)) {
			map.put(key, map.get(key) + val);
		}else {
			map.put(key, val);
		}
	}
	
}
