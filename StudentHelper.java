/*
 * Michael Karimizadeh 10/12/16
 * Object oriented programming project
 * Creates student object with name, mark, and student number parameters
 * Allows for setting and getting values
 * Provides calculations to find averages
*/
public class StudentHelper{//Creates main Student class
  //Creates private variables relating to students
  public int findStudent(int sNum, Student[] student){
    int location=0;
    int counter=1;
    //Sets values from parameter to private variables
    FileInputStream fs = new FileInputStream("studentdata.txt");
    DataInputStream in = new DataInputStream(fs);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    //tudent.getStuNum();
    br.readLine();
    while(counter<=Student.student(stu).length){
      if(sNum==student[counter].Student.getStuNum){
        location=counter;
      }
    }
    return location;
  }
  
}