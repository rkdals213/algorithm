package algorithm_study;


public class Pro_KAKAO_CodingTest05 {
	static int [] jump;
	public static void main(String[] args) {
		int [] stones = {2,4,5,3,2,1,4,2,5,1};
		int k = 3;
		System.out.println(solution(stones, k));
	}
	
	static int solution(int[] stones, int k) {
        int answer = 0;
        int N = stones.length;
        jump = new int [N];
        boolean f = true;
        while(f) {
        	for (int i = 0; i < N; i++) {
				if(stones[i] != 0) {
					stones[i]--;
				}else {
					f = false;
					int s = jump[i] + 1;
					for (int j = s; j < k; j++) {
						if(i+j >= N) {
							f = true;
							break;
						}
						if(stones[i+j] != 0) {
							f = true;
							break;
						}
						jump[i]++;
					}
					if(!f) {
						return answer;
					}
				}
			}
        	answer++;
        }
        return answer;
    }
	
}
