package algo_ad.day01;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class P103_Change_FullSearch {
	private static int[][] coins = {{ 500, 100, 50, 10 },  { 500, 400, 100, 50, 10 } };
	private static int min;
	
	public static void main(String[] args) {
        int price = 1200;
        int money = 2000;
        // 거스름돈을 위한 최소 동전 개수는?
        for (int i = 0; i < coins.length; i++) {
        	int[] coinSet = coins[i];
            min = Integer.MAX_VALUE;
            
            // 시작하는 동전의 위치를 바꿔가면서 테스트
            for (int c = 0; c < coinSet.length; c++) {
                changeMoneyLoop(coinSet, c, money - price, new TreeMap<Integer, Integer>());
            }
            
            System.out.println("for: " + Arrays.toString(coinSet) + "을 썼을 때 최소 동전 개수: " + min);
        }
    }
/**
 * 
 * @param coinSet	사용할 동전 조합
 * @param from		사용을 시작할 동전의 위치
 * @param target	빼줄돈
 * @param tmap		동전 사용 이력
 */
    private static void changeMoneyLoop(int[] coinSet, int from, int target, TreeMap<Integer, Integer> tmap) {
        // map 초기화 후
        int coins = 0;
        for (int ci = from; ci < coinSet.length; ci++) {
            target -= coinSet[ci];
            coins++;
            // System.out.println("사용 동전: " + coinSet[m] + ", 타겟 : " + target);
            if (target == 0) {
                handleMap(tmap, coinSet[ci], 1);
                System.out.printf("loop: map 구성: %s, 동전 개수: %d%n", tmap, coins);
                min = Math.min(min, coins);
                break;
            } else if (target > 0) {
                handleMap(tmap, coinSet[ci], 1);
                ci--;
            } else if (target < 0) {
                // 원상 복귀
                target += coinSet[ci];
                coins--;
            }
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
