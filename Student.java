/*
 * Michael Karimizadeh 10/12/16
 * Object oriented programming project
 * Creates student object with name, mark, and student number parameters
 * Allows for setting and getting values
 * Provides calculations to find averages
*/
public class Student{//Creates main Student class
  //Creates private variables relating to students
  private String firstName;
  private String lastName;
  private double mathMark;
  private double engMark;
  private double compMark;
  private int stuNum; 
  private double maxMark;
  private double minMark;
  
  public Student(int sNum, String fn, String ln, double mM, double eM, double cM){//Constructor that uses all parameters
    //Sets values from parameter to private variables
    firstName=fn;
    lastName=ln;
    mathMark=mM;
    engMark=eM;
    compMark=cM;
    stuNum=sNum;
  }
  public Student(int sNum, String fn, String ln){//Constructor that doesn't use marks
    //Sets values from parameters and default values to private variables
    firstName=fn;
    lastName=ln;
    mathMark=0.0;
    engMark=0.0;
    compMark=0.0;
    stuNum=sNum;
  }
  public Student(int sNum){//Constructor that only uses student number
    //Sets values from parameters and default values to private variables
    firstName=null;
    lastName=null;
    mathMark=0.0;
    engMark=0.0;
    compMark=0.0;
    stuNum=sNum;
  }
  public boolean setMax(double max){//Sets maximum possible percent grade
    boolean ex;
    maxMark=max;
    ex=true;
    return ex;
  }
  public boolean setMin(double min){//Sets minimum possible percent grade
    boolean ex;
    minMark=min;
    ex=true;
    return ex;
  }
  public String convertToLetter(double mark){//Converts percent grade to letter grade
    String markgg=null;
    if(mark<50.0){
      markgg="Fail";
    }
    else if(mark<=52){
      markgg="D-";
    }
    else if(mark<=56){
      markgg="D";
    }
    else if(mark<=59){
      markgg="D+";
    }
    else if(mark<=62){
      markgg="C-";
    }
    else if(mark<=66){
      markgg="C";
    }
    else if(mark<=69){
      markgg="C+";
    }
    else if(mark<=72){
      markgg="B-";
    }
    else if(mark<=76){
      markgg="B";
    }
    else if(mark<=79){
      markgg="B+";
    }
    else if(mark<=86){
      markgg="A-";
    }
    else if(mark<=89){
      markgg="A";
    }
    else if(mark<=100){
      markgg="A+";
    }
    return markgg;
  }
  public double convertToGPA(String mark){//Converts letter grade to gpa grade
    double markgg=0.0;
    if(mark.equals("Fail")){
      markgg=0.0;
    }
    else if(mark.equals("D-")){
      markgg=0.67;
    }
    else if(mark.equals("D")){
      markgg=1.00;
    }
    else if(mark.equals("D+")){
      markgg=1.33;
    }
    else if(mark.equals("C-")){
      markgg=1.67;
    }
    else if(mark.equals("C")){
      markgg=2.00;
    }
    else if(mark.equals("C+")){
      markgg=2.33;
    }
    else if(mark.equals("B-")){
      markgg=2.67;
    }
    else if(mark.equals("B")){
      markgg=3.00;
    }
    else if(mark.equals("B+")){
      markgg=3.33;
    }
    else if(mark.equals("A-")){
      markgg=3.67;
    }
    else if(mark.equals("A")){
      markgg=4.00;
    }
    else if(mark.equals("A+")){
      markgg=4.00;
    }
    return markgg;
  }
  public String getFName(){//Gets first name
    return firstName;
  }
  public String getLName(){//Gets last name
    return lastName;
  }
  public double getMMark(){//Gets math mark
    return mathMark;
  }
  public double getEMark(){//Gets english mark
    return engMark;
  }
  public double getCMark(){//Gets computer mark
    return compMark;
  }
  public int getStuNum(){//Gets student number
    return stuNum;
  }
  public double getMax(){//Gets max grade
    return maxMark;
  }
  public double getMin(){//Gets min grade
    return minMark;
  }
  public boolean setMath(double math){//Sets math percent grade
    boolean ex;
    mathMark=math;
    ex=true;
    return ex;
  }
  public boolean setEng(double eng){//Sets english percent grade
    boolean ex;
    engMark=eng;
    ex=true;
    return ex;
  }
  public boolean setComp(double comp){//Sets computer percent grade
    boolean ex;
    compMark=comp;
    ex=true;
    return ex;
  }
  public double calcAvg(double m,double e, double c){//Calculates percent average
    double avg;
    avg=(m+e+c)/3;
    return avg;
  }
  public double calcGPA(double m,double e, double c){//Calculates gpa grade
    double avg;
    avg=(m+e+c)/3;
    return avg;
  }
  public String toString(){//Returns all attributes
    return stuNum+" "+firstName+" "+lastName+" Math mark:"+mathMark+" English mark:"+engMark+" Computer mark:"+compMark+" Max mark:"+maxMark+" Min mark:"+minMark;
  }
}