package com.StudentPoint.service;

import com.StudentPoint.dal.StudentDataBase;
import com.StudentPoint.model.StudentObject;

import java.io.IOException;

import java.util.Scanner;

import static com.StudentPoint.dal.StudentDataBase.studentLinkedList;


public class StudentService  {

      private static StudentDataBase studentDataBase = new StudentDataBase();

    public void loadFileStudent() throws IOException {
        studentDataBase.loadFileStudent();
    }

    public void readFileStudent() throws IOException {
        studentDataBase.readFileStudent();
    }


    public void addStudent() throws IOException {
        StudentObject studentObject = new StudentObject();
        studentObject.inputStudent();
        int count = studentLinkedList.size();
        studentObject.setId(++count);
        studentLinkedList.add(studentObject);
        System.out.println("Add complete!");
        System.out.println("------------");
        studentDataBase.saveFileStudent();


    }

    public void deleteStudent() throws IOException {


        System.out.println("Input ID of student to delete:");
        int id = new Scanner(System.in).nextInt();
        boolean check = true;
        for (StudentObject student : studentLinkedList) {
            if (student.getId() == id) {
                studentLinkedList.remove(student);
                System.out.println("Is't deleted!");
                System.out.println("------------");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Can't not delete!");
            System.out.println("------------");
        }
        studentDataBase.saveFileStudent();
    }

    public void editStudent() throws IOException {
        System.out.println("Input ID of student to edit:");
        int id = new Scanner(System.in).nextInt();
        boolean check = true;
        for (StudentObject student : studentLinkedList) {
            if (student.getId() == id) {
                student.inputStudent();
                student.setId(id);
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Can't not find ID!");
        }
        System.out.println("------------");
        studentDataBase.saveFileStudent();
    }

    public void sortStudentByAvengerPoint() throws IOException {
        studentLinkedList.sort((o2, o1) -> {
            if (o1.getAvengerPoint() < o2.getAvengerPoint()) {
                return -1; //doi cho~
            }
            return 1;
        });
        System.out.println("Is Sorted!");
        System.out.println("------------");
        studentDataBase.saveFileStudent();
    }


}
