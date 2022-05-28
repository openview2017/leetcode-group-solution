/*
*mplement a class Class with the following attributes and methods:

1
A public attribute students which is a array of Student instances.

2
A constructor with a parameter n, which is the total number of students in this class.
The constructor should create n Student instances and initialized with student id from 0 ~ n-1


https://www.lintcode.com/problem/455/description?utm_source=sc-libao-cyc

* */

class Student {
    private String name;
    private String age;
    public int id;
    //prefer String for id
    public Student(int id) {
        this.id = id;
    }
}

public class StudentID {
    //1 attribute
    public Student[] students;

    //2constructor
    public StudentID(int n) {
        students = new Student[n];
        int id = 0;
        for (Student stu : students) {
            stu = new Student(id++);
        }
    }
}