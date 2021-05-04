package com.StudentPoint.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentObject {
    static int count = 0;
    private String name;
    private int id;
    private double point1_1, point1_2, point2, point3;
    private double avengerPoint;

    public void setAvengerPoint() {
        this.avengerPoint = (point1_1 + point1_2 + 2 * point2 + 3 * point3) / 7;
    }

    public double getAvengerPoint() {
        return avengerPoint;
    }

    public int getId() {
        return id;
    }

    public StudentObject(int id, String name, double point1_1, double point1_2, double point2, double point3) {
        this.id = id;
        this.name = name;
        this.point1_1 = point1_1;
        this.point1_2 = point1_2;
        this.point2 = point2;
        this.point3 = point3;
        this.avengerPoint = (point1_1 + point1_2 + 2 * point2 + 3 * point3) / 7;
    }
    public StudentObject() {

    }
    @Override
    public String toString() {

        return "StudentObject{" +
                "id= " + id +
                " , name= " + name +
                " , point1_1= " + point1_1 +
                " , point1_2= " + point1_2 +
                " , point2= " + point2 +
                " , point3= " + point3 +
                " , avengerPoint= " + avengerPoint +
                '}';
    }
    public void makeTheBoard(){
        System.out.format("|%-3s |", id);
        System.out.format("%-15s |", name);
        System.out.format("%-10s |", point1_1);
        System.out.format("%-10s |", point1_2);
        System.out.format("%-10s |", point2);
        System.out.format("%-10s |", point3);
        System.out.format("%-10.1f\n", avengerPoint);
    }

    public String toCSVFormat() {
        return id + ", " + name + ", " + point1_1 + ", "
                + point1_2 + ", " + point2 + ", " + point3 + ", "
                + avengerPoint+"\n";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void parse(String line){

    }

    public void inputStudent() {
      Scanner sc1 = new Scanner(System.in);
      Scanner sc2 = new Scanner(System.in);
      Scanner sc3 = new Scanner(System.in);

        this.id = ++count; //crease ID

        System.out.println("Input name: ");
        name = sc1.nextLine();
        String regex = "^[a-zA-Z]*+\\s+[a-zA-Z]*$|^[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        while(!matcher.find()){

            System.out.println("Please input right format for Name !");
            name= sc2.nextLine();
            matcher = pattern.matcher(name);
        }



        //check point
        do {
            System.out.println("Input Point1-1: ");
            while (!sc2.hasNextDouble()) {
                System.out.println("Please input Point again: ");
               sc2.next();
            }
            point1_1 = sc2.nextDouble();
        } while (point1_1 < 0 || point1_1 > 10);

        do {
            System.out.println("Input Point1-2: ");
            while (!sc3.hasNextDouble()) {
                System.out.println("Please input Point again: ");
                 sc3.next();
            }
            point1_2 = sc3.nextDouble();
        } while (point1_2 < 0 || point1_2 > 10);

        do {
            System.out.println("Input Point2: ");
            while (!sc1.hasNextDouble()) {
                System.out.println("Please input Point again: ");
               sc1.next();
            }
            point2 = sc1.nextDouble();
        } while (point2 < 0 || point2 > 10);

        do {
            System.out.println("Input Point3: ");
            while (!sc2.hasNextDouble()) {
                System.out.println("Please input Point again: ");
                sc2.next();
            }
            point3 = sc2.nextDouble();
        } while (point3 < 0 || point3 > 10);

        this.avengerPoint = (point1_1 + point1_2 + 2 * point2 + 3 * point3) / 7;
    }


}
