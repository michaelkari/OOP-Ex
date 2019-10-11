/*
 * Michael Karimizadeh
 * 10/12/16
 * This code Searches for location of student in list based on student number
 */
public class StudentHelper{//Creates main Student Helper class
  public static int findStudent(int sNum,Student[] student){//Uses object array and student number as parameters
    //Returns location of student number in list if student number matches with any object in array
    int counter=0;
    int location=-1;
    while(counter<student.length){
      if(student[counter].getStuNum()== sNum){
        location=counter;
      }
      counter++;
    }
    return location;
  }
}