package sms;

import javax.swing.JOptionPane;

public class StudentData extends SMS{
    //Creating variables
    private String Name;
    private int age;
    private int course;
    private String section;
    private double SemesterFee=130000;
    private double YearlyFee;
    private double gpa;
    private int attendance;
    private String password;
    
    //Constructor for adding new student with partial data
    public StudentData(String Name, String section, String password){
        this.Name=Name;
        this.section=section;
        this.password=password;
    }
    
    //Constructor for adding new student with full data
    public StudentData(String Name, int age, int course, String section, double gpa, int attendance, String password){
        this.Name=Name;
        this.age=age;
        this.course=course;
        this.section=section;
        this.YearlyFee=SemesterFee*2;
        this.gpa=gpa;
        this.attendance=attendance;
        this.password=password;
    }
    
    //Creating getters
    public String getName(){
        return Name;
    }
    public int getAge(){
        return age;
    }
    public int getCourse(){
        return course;
    }
    public String getSection(){
        return section;
    }
    public double getSemesterFee(){
        return SemesterFee;
    }
    public double getYearlyFee(){
        return YearlyFee;
    }
    public double getGpa(){
        return gpa;
    }
    public int getAttendance(){
        return attendance;
    }
    public String getPassword(){
        return password;
    }
    
    //Creating setters
    public void setName(String Name){
        this.Name=Name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setCourse(int course){
        this.course=course;
    }
    public void setSection(String section){
        this.section=section;
    }
    public void setSemesterFee(double SemesterFee){
        this.SemesterFee=SemesterFee;
    }
    public void setYearlyFee(double YearlyFee){
        this.YearlyFee=YearlyFee;
    }
    public void setGpa(double gpa){
        this.gpa=gpa;
    }
    public void setAttendance(int attendance){
         this.attendance=attendance;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    //Making full report function
    public void fullReport(){
        JOptionPane.showMessageDialog(null, "Name: " + Name + "\nAge: " + age +"\nCourse: " + course + "\nSection: " + section
        + "\nSemester Fee: " + SemesterFee +"\nYearly Fee: " + YearlyFee + "\nGpa: " + gpa +"\nAttendance:" + attendance);   
    }
    
    //Deleting account function
    public void delete(){
        this.Name="";
    }
    
    //Calculating yearly fee function
    public void calculateFee(){
        YearlyFee= SemesterFee*2;
        JOptionPane.showMessageDialog(null, "Your yearly fee is:" + YearlyFee);
    }
}