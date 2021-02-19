package NHN_CodingTest;

import java.util.Scanner;

public class test1 {
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers,
                                 int numOfGames, int[] numOfMovesPerGame) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        char[] map = new char[numOfAllPlayers - 1];
        int[] cought = new int[numOfAllPlayers];
        cought[0]++;

        for (int i = 0; i < numOfAllPlayers - 1; i++) {
            map[i] = (char) ('B' + i);
        }

        int k = 0;
        int now = 0;
        for (int j = 0; j < numOfGames; j++) {
            k += numOfMovesPerGame[j];
            k = k % (numOfAllPlayers - 1);
            if (k < 0) {
                k = numOfAllPlayers + k - 1;
            }
            if (find(map[k], namesOfQuickPlayers)) cought[now]++;
            else {
                int temp = now;
                now = map[k] - 'A';
                map[k] = (char) ('A' + temp);
                cought[now]++;
            }
        }

        for (int i = 0; i < numOfAllPlayers - 1; i++) {
            System.out.println(map[i] + " " + cought[map[i] - 'A']);
        }

        System.out.println((char) ('A' + now) + " " + cought[now]);

    }

    static boolean find(char x, char[] namesOfQuickPlayers) {
        for (int i = 0; i < namesOfQuickPlayers.length; i++) {
            if (x == namesOfQuickPlayers[i]) {
                return true;
            }
        }
        return false;
    }

    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
                    inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < inputData.numOfGames; i++) {
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
                inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}
