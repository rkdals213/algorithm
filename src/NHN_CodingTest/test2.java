package NHN_CodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        int cnt = 0;

        int[] height = new int[width];

        for (int i = 0; i < day; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                height[j] += blocks[i][j];
            }
            System.out.println("벽돌쌓기");
            System.out.println(Arrays.toString(height));
            for (int x = 0; x < width - 1; x++) {
                for (int y = x + 1; y < width; y++) {
                    if (height[x] <= height[y]) {
                        if (x + 1 == y) {
                            x++;
                            continue;
                        }
                        for (int j = x + 1; j < y; j++) {
                            cnt += height[x] - height[j];
                            height[j] = height[x];
                        }
                        break;

                    } else {
                        if (x + 1 == y) {
                            continue;
                        }
                        int temp = y;
                        boolean f = true;
                        for (int j = y + 1; j < width; j++) {
                            if (height[j] >= height[x]) {
                                f = false;
                                break;
                            }
                            if (height[temp] <= height[j]) {
                                temp = j;
                            }
                        }
                        System.out.println(temp);
                        if (f) {
                            for (int j = x + 1; j < temp; j++) {
                                cnt += height[temp] - height[j];
                                height[j] = height[temp];
                            }
                            break;
                        }
                    }
                }
            }

            System.out.println("시멘트 부음");
            System.out.println(Arrays.toString(height));

        }

        System.out.println(cnt);

    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}
