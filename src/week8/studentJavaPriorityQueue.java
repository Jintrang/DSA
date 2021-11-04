package week8;

import java.util.*;

public class studentJavaPriorityQueue {
    public class Student {
        public int id;
        public String name;
        double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.cgpa = cgpa;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getId() {
            return id;
        }
    }

    class StudentComparator implements Comparator <Student> {
        //@Override
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.cgpa == o2.cgpa && o1.name.equals(o2.name) && o1.id == o2.id) return 0;
            if(o1.cgpa > o2.cgpa) return 1;
            else {
                if(o1.name.compareTo(o2.name) <0) return 1;
                else {
                    if(o1.id < o2.id) return 1;
                    else return -1;
                }
            }
        }
    }

    public class Priorities {
        List<Student> getStudents(List<String> events) {
            List<Student> xyz =  new ArrayList<>();
            int n = events.size();
            Comparator<Student> com = new StudentComparator();
            PriorityQueue<Student> students = new PriorityQueue<>(n, com);
            //List<Student> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String [] event = events.get(i).split(" ");
                if(Objects.equals(event[0], "SERVED")) students.remove();
                if(Objects.equals(event[0], "ENTER")) students.add(new Student(Integer.parseInt(event[3]),event[1],Double.parseDouble(event[2])));
            }
            for(int i = 0; i< students.size(); i++) {
                xyz.add(students.peek());
            }
            return xyz;
        }
    }
}
