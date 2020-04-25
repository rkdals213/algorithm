package algo_basic.day07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueApi {

	public static void main(String[] args) {
		// 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		
		// 데이터 삽입
		queue.offer(100);
		queue.add(200);		
		System.out.println(queue);
		// 데이터 확인
		System.out.println(queue.peek());
		System.out.println(queue.element());
		// 삭제
		queue.poll();
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		// 비어있니?
		System.out.println(queue.isEmpty());
		
		

	}

}
