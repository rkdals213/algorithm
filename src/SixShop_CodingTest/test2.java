package SixShop_CodingTest;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        int[] grade = {3,2,1,2};
        System.out.println(solution(grade));
    }

    static public List<Integer> solution(int[] grade) {
        PriorityQueue<Grade> gradeQueue = new PriorityQueue<>();
        PriorityQueue<Result> resultQueue = new PriorityQueue<>();
        for (int i = 0; i < grade.length; i++) {
            gradeQueue.add(new Grade(i, grade[i]));
        }

        Grade now = gradeQueue.poll();
        int nowGrade = now.grade;
        int nowPlace = 1;
        resultQueue.add(new Result(now.id, nowPlace));
        int count = 1;
        while (!gradeQueue.isEmpty()) {
            Grade poll = gradeQueue.poll();
            if (poll.grade == nowGrade) {
                count++;
                resultQueue.add(new Result(poll.id, nowPlace));
            } else {
                nowPlace += count;
                count = 1;
                nowGrade = poll.grade;
                resultQueue.add(new Result(poll.id, nowPlace));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!resultQueue.isEmpty()) {
            Result poll = resultQueue.poll();
            result.add(poll.grade);
        }

        return result;
    }

    static class Grade implements Comparable<Grade> {
        int id;
        int grade;

        public Grade(int id, int grade) {
            this.id = id;
            this.grade = grade;
        }

        @Override
        public int compareTo(Grade o) {
            return Integer.compare(o.grade, this.grade);
        }
    }

    static class Result implements Comparable<Result> {
        int id;
        int grade;

        public Result(int id, int grade) {
            this.id = id;
            this.grade = grade;
        }

        @Override
        public int compareTo(Result o) {
            return Integer.compare(this.id, o.id);
        }
    }
}
