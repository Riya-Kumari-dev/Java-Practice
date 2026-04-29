package dsa.arrays.array;

import java.util.Arrays;
import java.util.Scanner;

class Student{
    String course;
    int[] marks = new int[5];
    String name;
    double percentage;
    Student(){

    }
    Student(String name, String course, int[] marks){
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.percentage = calculatePercentage();
    }
    double calculatePercentage(){
        double sum = 0;
        for(int ele : marks){
            sum += ele;
        }
        return sum/5.0;
    }
    double getPercentage(){
        return percentage;
    }
}
public class UserDefinedArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Students : ");
        int n = sc.nextInt();
        sc.nextLine(); // fix for next line issue
        Student[] students = new Student[n];
        System.out.println("Kindly enter the details of students  ");
        for(int i=0; i<n; i++){
            Student s = new Student();
            System.out.print("Name : ");
            s.name = sc.nextLine();
            System.out.print("Course : ");
            s.course = sc.nextLine();
            System.out.print("Enter the marks of student (5 subjects) : ");
            for(int j=0; j<5; j++){
                s.marks[j] = sc.nextInt();
            }
            sc.nextLine(); // consume next line after marks
            s.percentage = s.calculatePercentage();
            students[i] = s;
        }

        for(int i=0; i<n; i++){
            System.out.println("Name : "+students[i].name);
            System.out.println("Course : "+students[i].course);
            System.out.println("Percentage of marks obtained  : "+students[i].getPercentage());
        }
        sc.close();
    }
}
