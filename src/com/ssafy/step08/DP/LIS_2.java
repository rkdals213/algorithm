package com.ssafy.step08.DP;

import java.util.Arrays;

/**
 * 시간복잡도 : O(nlogn)
 */
public class LIS_2 {

    public static void main(String[] args) {
        int[] a = {8, 2, 4, 3, 6, 11, 7, 10, 14, 5};
        int[] C = new int[a.length]; // LIS로 사용가능한 숫자를 저장, index를 저장
        int[] path = new int[a.length];  // 결로를 역추적할 index를 저장
        int size = 0; // LIS의 개수

        path[size] = -1;  // 첫번재 숫자라는 의미
        C[size++] = 0; // 첫번째 숫자의 index 반영
        for (int i = 1; i < C.length; i++) {
            // C배열의 마지막 숫자와 수열값을 비교
            if (a[C[size - 1]] < a[i]) {
                path[i] = C[size - 1];
                C[size++] = i;
            } else { // LIS 마지막 숫자보다 크지않으면 LIS의 값을 업데이트
                int temp = binarySearch0(a, C, 0, size, a[i]);  // 삽입할 위치
                if (temp < 0) temp = -temp - 1;
                path[i] = path[C[temp]];  // 덮어쓸 위치의 index를 내껄로 복사
                C[temp] = i; // 수열의 값을 LIS에 덮어쓰기
            }
        }

//		System.out.println(Arrays.toString(C));
        System.out.println("LIS의 개수 : " + size);
        String result = "";
        for (int i = C[size - 1]; i != -1; i = path[i]) {
            result = a[i] + " " + result;
        }
        System.out.println(result);


    }


    private static int binarySearch0(int[] a, int[] C, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[C[mid]];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }


}
