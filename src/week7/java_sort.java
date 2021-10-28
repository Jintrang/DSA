package week7;
import java.util.*;

//https://www.hackerrank.com/challenges/java-sort/problem

public class java_sort {

     public static class Student{
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }

         public boolean less(Student student) {
            if(this.cgpa < student.cgpa) {
                return true;
            } else if (this.cgpa == student.cgpa) {
                if(this.fname.compareTo(student.fname) < 0) {
                    return true;
                } else if(this.fname.compareTo(student.fname) == 0) {
                    if(this.id < student.id) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
         }
     }



    //Complete the code
    public static class Solution
    {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());

            List<Student> studentList = new ArrayList<Student>();
            while(testCases>0){
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();

                Student st = new Student(id, fname, cgpa);
                studentList.add(st);

                testCases--;
            }

            sortList(studentList);

            for(Student st: studentList){
                System.out.println(st.getFname());
            }
        }

        private static void sortList(List<Student> studentList) {
            int n = studentList.size();
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j< n; j++) {
                    if(studentList.get(j).less(studentList.get(i))) {
                        Collections.swap(studentList, i, j);
                    }
                }
            }
        }
    }





}
