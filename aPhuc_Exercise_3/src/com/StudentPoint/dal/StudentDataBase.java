package com.StudentPoint.dal;

import com.StudentPoint.model.StudentObject;



import java.io.*;
import java.util.LinkedList;

public class StudentDataBase {
    public static LinkedList<StudentObject> studentLinkedList = new LinkedList<>();
    public  void loadFileStudent() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("StudentPoint.csv"));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] arr = line.split(",");
            if(arr[0].equals("ID")){
                continue;
            }
            try{
                StudentObject st = new StudentObject(Integer.parseInt(arr[0]),arr[1],
                        Double.parseDouble(arr[2].trim()) ,Double.parseDouble(arr[3].trim())
                        ,Double.parseDouble(arr[4].trim()) ,Double.parseDouble(arr[5].trim())
                );
                st.setAvengerPoint();
                studentLinkedList.add(st);
            }catch (ArrayIndexOutOfBoundsException ignored){

            }
        }


        bufferedReader.close();
    }

    public  void saveFileStudent() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("StudentPoint.csv"));

        String CSVHeader = "ID, Name, Point1-1, Point1-2, Point2, Point3, AvengerPoint \n";
        bufferedWriter.write(CSVHeader);

        for (StudentObject student : studentLinkedList) {
            String line = student.toCSVFormat();
            bufferedWriter.write(line);
        }
        bufferedWriter.close();

    }

    public  void readFileStudent() throws IOException {
        LinkedList<StudentObject> printStudentList = new LinkedList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("StudentPoint.csv"));
        String line;
        while ((line = bufferedReader.readLine()) != null){



            String[] arr = line.split(",");
            if(arr[0].equals("ID")){
                continue;
            }
            try{
                StudentObject st = new StudentObject(Integer.parseInt(arr[0]),arr[1],
                        Double.parseDouble(arr[2].trim()) ,Double.parseDouble(arr[3].trim())
                        ,Double.parseDouble(arr[4].trim()) ,Double.parseDouble(arr[5].trim())
                       );
                st.setAvengerPoint();
                printStudentList.add(st);
            }catch (ArrayIndexOutOfBoundsException ignored){

            }
        }
        System.out.format("|%-3s |", "ID");
        System.out.format("%-15s |", "T??n");
        System.out.format("%-10s |", "??i???m hs1-1");
        System.out.format("%-10s |", "??i???m hs1-2");
        System.out.format("%-10s |", "??i???m hs2");
        System.out.format("%-10s |", "??i???m hs3");
        System.out.format("%-10.1s \n ", "??i???m TB");
        for (StudentObject student:printStudentList) {
            student.makeTheBoard();
        }

        bufferedReader.close();
        System.out.println("                                          --------------");

    }
}
