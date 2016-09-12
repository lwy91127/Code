package Others;

import java.util.*;

/**
 * Created by lwy on 2016/9/8.
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。每门课由平时成绩和考试成绩组成，满分为r。
 * 现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 *
输入例子:
 5 10 9
 0 5
 9 1
 8 1
 0 1
 9 100

 输出例子:
 43
 */
public class Scolarship {
    static class Student{
        private int grade;
        private int learnTime;

        public Student(int grade, int learnTime) {
            this.grade = grade;
            this.learnTime = learnTime;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int r = sc.nextInt();
            int avg = sc.nextInt();
            List<Student> students = new ArrayList<>();
            int sum = 0;
            int total = avg * n;
            for(int i = 0;i<n;i++){
                int grade = sc.nextInt();
                int learnTime = sc.nextInt();
                students.add(new Student(grade,learnTime));
                sum += grade;
            }
            if(sum >= total)
                System.out.println(0);
            else {
                Collections.sort(students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.learnTime - o2.learnTime;
                    }
                });
                long totalTime = 0;
                for (Student s : students) {
                    if((total - sum) <= (r - s.grade)){
                        System.out.println(totalTime + (total - sum) * s.learnTime);
                        break;
                    }else{
                        sum += r - s.grade;
                        totalTime += (r - s.grade) * s.learnTime;
                    }
                }
            }
        }
    }
}
