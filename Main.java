/*
 * Michael Karimizadeh
 * 10/12/16
 * This code reads data from a file containing student information
 * Determines number of students
 * Splits data
 * Determines correct constructor to use
 * Creates array of student objects
 * Provides options for the user to select
 * Display all Student Numbers and full names(Only)
 * Display all Info (no GPA and average)
 * Display all Info (with overall GPA and average)
 * Display all Info (with each mark and overall average as a letter grade)
 * Enter Marks (given a student number)
 * Set min and max marks
 * Write to file
 */
import java.io.*;//Imports java input output package 
import java.util.*;

public class Main{
  public static void main(String[] args){
    int numberOfStudents=-1;//Used to determine total students 
    int counter=0;//Used as temporary counter
    
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
        //System.out.println(student[counter]);//Prints object just created
        counter+=1;//Add to counter
      }
      String no;
      System.out.println("Do you want to search the location of a student (y/n)");//Gives option to user
      no=sc.nextLine();
      if(no.equals("y")){//Searches and prints the location of a student number
        System.out.println("\nEnter a student number to search the location of");
        int numSearch;
        numSearch=sc.nextInt();
        System.out.println("Student is "+(StudentHelper.findStudent(numSearch,student)+1)+" in the list");
      }
      Scanner sc1=new Scanner(System.in);
      String end;
      System.out.println("\nDo you want the program to end? (y/n)");//Asks the user if they want the program to immedietly end
      end=sc1.nextLine();
      while(!(end.equals("y"))){
        String choice=" ";
        while(!(choice.equals("a")||choice.equals("b")||choice.equals("c")||choice.equals("d")||choice.equals("e")||choice.equals("f")||choice.equals("g"))){
          System.out.println("\nWould you like to:");//Proves menu of options for the user to select
          System.out.println("(a)  Display all Student Numbers and full names(Only)");
          System.out.println("(b)  Display all Info (no GPA and average)");
          System.out.println("(c)  Display all Info (with overall GPA and average)");
          System.out.println("(d)  Display all Info (with each mark and overall average as a letter grade)");
          System.out.println("(e)  Enter Marks (given a student number)");
          System.out.println("(f)  Set min and max marks");
          System.out.println("(g)  Write to file");
          choice=sc.nextLine();
        }
        if(choice.equals("a")){//Displays all student numbers and full names
          for(int i=0;i<numberOfStudents;i++){
            System.out.println(student[i].getStuNum()+" "+student[i].getFName()+" "+student[i].getLName());
          }
        }
        else if(choice.equals("b")){//Displays all Info (no GPA and average)
          for(int i=0;i<numberOfStudents;i++){
            System.out.println(student[i].getStuNum()+" "+student[i].getFName()+" "+student[i].getLName()+" Math mark:"+student[i].getMMark()+" English mark:"+student[i].getEMark()+" Computer mark:"+student[i].getCMark()+" Max mark:"+student[i].getMax()+" Min mark:"+student[i].getMin());
          }
        }
        else if(choice.equals("c")){//Displays all Info (with overall GPA and average)
          for(int i=0;i<numberOfStudents;i++){
            System.out.print(student[i].getStuNum()+" "+student[i].getFName()+" "+student[i].getLName()+" Math mark:"+student[i].getMMark()+" English mark:"+student[i].getEMark()+" Computer mark:"+student[i].getCMark()+" Max mark:"+student[i].getMax()+" Min mark:"+student[i].getMin());
            System.out.print(" GPA:"+student[i].convertToGPA(student[i].convertToLetter((student[i].getMMark()+student[i].getEMark()+student[i].getCMark())/3)));
            System.out.println(" Average:"+Math.round(((student[i].getMMark()+student[i].getEMark()+student[i].getCMark())/3)*100.0)/100.0);
          }
        }
        else if(choice.equals("d")){//Displays all Info (with each mark and overall average as a letter grade)
          for(int i=0;i<numberOfStudents;i++){
            System.out.print(student[i].getStuNum()+" "+student[i].getFName()+" "+student[i].getLName()+" Math mark:"+student[i].getMMark()+" English mark:"+student[i].getEMark()+" Computer mark:"+student[i].getCMark()+" Max mark:"+student[i].getMax()+" Min mark:"+student[i].getMin());
            System.out.println(" Letter Average:"+student[i].convertToLetter(Math.round(((student[i].getMMark()+student[i].getEMark()+student[i].getCMark())/3)*100.0)/100.0));
          }
        }
        else if(choice.equals("e")){//Enter Marks (given a student number)
          int stuS;
          int stuLoc;
          double mMark;
          double eMark;
          double cMark;
          System.out.println("\nEnter a student number to change the marks of");//Find the student location of the student number
          stuS=sc.nextInt();
          stuLoc=StudentHelper.findStudent(stuS,student);
          while(stuLoc==-1){
            System.out.println("\nEnter a student number to change the marks of");//Find the student location of the student number if they input an incorrect value
            stuS=sc.nextInt();
            stuLoc=StudentHelper.findStudent(stuS,student);
          }
          System.out.println("Enter a math mark");//Changes math mark
          mMark=sc.nextInt();
          System.out.println("Enter an english mark");//Changes english mark
          eMark=sc.nextInt();
          System.out.println("Enter a computer mark");//Changes computer mark
          cMark=sc.nextInt();
          student[stuLoc].setMath(mMark);
          student[stuLoc].setEng(eMark);
          student[stuLoc].setComp(cMark);
        }
        else if(choice.equals("f")){//Set min and max marks for all students
          int mx;
          int mn;
          System.out.println("Enter a max mark");//Changes all max marks
          mx=sc.nextInt();
          System.out.println("Enter a min mark");//Changes all min marks
          mn=sc.nextInt();
          for(int i=0;i<numberOfStudents;i++){
            student[i].setMax(mx);
            student[i].setMin(mn);
          }
        }
        else if(choice.equals("g")){//Writes all objects to file
          PrintWriter writer = new PrintWriter("WrittenStudents.txt");
          for(int i=0;i<numberOfStudents;i++){
            writer.println(student[i]);
          }
          writer.close();
        }
        System.out.println("\nDo you want the program to end? (y/n)");//Asks the user if they would like to end the program
        end=sc.nextLine();
      }
    }
    catch(Exception e){//Catches exceptions
      System.out.println ("Error: " + e.getMessage ());//Prints error
      System.out.println ("Error: " + e.toString ());//Prints error
    }
  }
}