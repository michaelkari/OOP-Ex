/*
 * Michael Karimizadeh
 * 10/12/16
 * This code reads data from a file containing student information
 * Determins number of students
 * Splits data
 * Determines correct constructor to use
 * Creates array of student objects
*/
import java.io.*;//Imports java input output package 
import java.util.*;

public class Main{
  public static void main(String[] args){
    int numberOfStudents=-1;//Used to determine total students 
    int counter=0;//Used as temporary counter
    int stuNo=0;
    
    try{//Tries code and prepares for error
      Scanner sc=new Scanner(System.in);
      FileInputStream fs = new FileInputStream("studentdata.txt");//Creates stream of input from txt file
      FileInputStream fs1 = new FileInputStream("studentdata.txt");//Creates second stream of input from txt file
      DataInputStream in = new DataInputStream(fs);//Creates data set to be used
      DataInputStream in1 = new DataInputStream(fs1);//Creates second data set to be used
      BufferedReader br = new BufferedReader(new InputStreamReader(in));//Reads set of data to be processed
      BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));//Reads second set of data to be processed
      String sLine,sLine1;//Creates temporary string holders
      while ((sLine = br.readLine()) != null)   {//Counts number of lines in file
        numberOfStudents+=1;
      }
      System.out.println("Number of students: "+numberOfStudents);//Prints number of students in file
      Student[] student=new Student[numberOfStudents];//Creates array of student objects
      br1.readLine();//Skips first line of file
      while ((sLine1 = br1.readLine()) != null)   {//Creates objects for each line
        String[] part = sLine1.replaceAll("^[,\\s]+", "").split("[,\\s]+");//Regex for splitting string into appropriate array of parts
        if(part[1].equals("-")){//Use constructor that needs only student number if no name is available
          student[counter] = new Student(Integer.parseInt(part[0]));//Creates object from object array
        }
        else if(part[3].equals("-")){//Use constructor that needs only student number and name if no marks available
          student[counter] = new Student(Integer.parseInt(part[0]),part[1],part[2]);//Creates object from object array
        }
        else{//Use constructor that uses all parameters
          student[counter] = new Student(Integer.parseInt(part[0]),part[1],part[2],Double.parseDouble(part[3]),Double.parseDouble(part[4]),Double.parseDouble(part[5]));//Creates object from object array
        }
        System.out.println(student[counter]);//Prints object just created
        counter+=1;//Add to counter
      }
      System.out.println("Enter a student number in order to find their location");
      stuNo=sc.nextInt();
      System.out.prinltn(StudentHelper.findStudent(stuNo,Student[]student));
    }
    catch(Exception e){//Catches exceptions
      System.out.println ("Error: " + e.getMessage ());//Prints error
      System.out.println ("Error: " + e.toString ());//Prints error
    }
  }
}