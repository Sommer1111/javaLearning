//package cn.code.day3_26_collection;
//
//import java.util.*;
//
///**
// * @Auther:sommer1111
// * @date 2020/3/30 15:41
// */
//public class Test3 {
//
//    public static void main(String[] args) {
//
//        TreeSet<Student> treeSet = new TreeSet<>();
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 1;; i++) {
//            int score = 0;
//            System.out.println("请输入第" + i + "位学生的姓名：");
//            String name = scanner.next();
//            System.out.println("请输入第" + i + "位学生的成绩：(输入负数，结束录入)");
//            score = scanner.nextInt();
//            if (score < 0) {
//                break;
//            } else {
//                treeSet.add(new Student(name, score));
//            }
//        }
//
//        System.out.println(treeSet);
//        //遍历添加进的数据
//        for(Student b:treeSet){
//            System.out.println(b.getName()+"==="+b.getScore());
//    }
//
//}
//
//
////单独创建一个学生类，这个类必须是可以比较的。
//class  Student implements Comparable<Student> {
//    private String name;
//    private int score;
//
//    public Student() {
//    }
//
//    public Student(String name, int score) {
//        this.name = name;
//        this.score = score;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return score == student.score &&
//                Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, score);
//    }
//
//
//    @Override
//    public int compareTo(Student student) {
//        int num = this.score - score;
//        if (num != 0) {
//            return num;
//        } else {
//            return this.name.compareTo(name);
//
//        }
//    }
//}
