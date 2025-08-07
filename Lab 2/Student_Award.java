import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Student_Award{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Student> Student_info = new PriorityQueue<>();

        Comparator<Student> compare = new Comparator<>() {
            
            @Override
            public int compare(Student x, Student y){
                return x.getName().compareTo(y.getName());
            }
        };


        String file_path ="C:\\Users\\prana\\OneDrive\\Desktop\\CS214 Labs\\Lab 2\\Student_GPA.CSV";
       
        Populate_PQueue(Student_info,file_path);

        boolean running = true;
        while(running){
            System.out.println("~~~~~~~MENU~~~~~~~~~");
            System.out.println("1. Display all Students");
            System.out.println("2  Display Prize Winners");
            System.out.println("3  Print Students sorted in ABC order");
            System.out.println("4  Exit");
            int option = scanner.nextInt();
            System.out.println("");
            
            switch(option){
                case 1 -> { while(!Student_info.isEmpty()){
                    System.out.println(Student_info.poll());
                    }
                    Populate_PQueue(Student_info,file_path);
                }
                case 2 -> {
                    int count=0;
                    while(!Student_info.isEmpty()){
                        if(Student_info.peek().getGPA()>=4.0&&count!=5){
                            System.out.println(Student_info.poll());
                            count++;
                        }else{
                            Student_info.poll();
                        }
                    }

                    Populate_PQueue(Student_info, file_path);
                }
                case 3 -> {
                    ArrayList<Student> Student = new ArrayList<>();
                    while(!Student_info.isEmpty()){
                        Student.add(Student_info.poll());
                        
                    }
                    Collections.sort(Student, compare);

                    for(Student i: Student){
                        System.out.println(i);
                    }

                }
                case 4 -> {
                    running = false;
                }
                default -> {
                    System.out.println("Invalid Option... Try again");
                }
            }
        }
        scanner.close();
    }

    static void Populate_PQueue(PriorityQueue<Student> Student_info,String file_path){
        try(BufferedReader file_reader = new BufferedReader(new FileReader(file_path))){
            String temp="a";
            while(temp!=null){
                temp = file_reader.readLine();

                if(temp!=null){
                /*
                split is quite unique 0 indicates split towards left
                String student_name=temp.split(",")[0];
                split is quite unique 1 indicates split towards right
                String student_GPA=temp.split(",")[1];
                */
                Student_info.add(new Student(temp.split(",")[0],Double.parseDouble(temp.split(",")[1])));
               
                }
            }
        }catch(Exception e){
            System.out.println("Error, Could not read the CSV File.......");
        }
    }

}
