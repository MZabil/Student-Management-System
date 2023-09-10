package sms;

//Adding packages needed for handling files
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SMS {
    public static void main(String[] args) {
        //To check if user is admin or student
        boolean adminStatus=false;
        boolean studentStatus=false;
        int loginChoice;
        String checkName;
        String checkPass;
        String currentName;
        String currentPass;
        
        //Creating some admin accounts
        AdminData SirNauman= new AdminData("Nauman", "abc123");
        AdminData SirAsif= new AdminData("Asif","abc123");
        
        //Creating array to store admin accounts to make searching easier
        int size=2;
        AdminData[] accounts= new AdminData[size];
        accounts[0]=SirNauman;
        accounts[1]=SirAsif;
        
        //Creating some student accounts
        StudentData Zabil= new StudentData("Zabil",19,28,"C",3.76,92,"abc123" );
        StudentData Haris= new StudentData("Haris","C","abc123");
        
         //Creating array to store student accounts to make searching easier
        int Size=2;
        StudentData[] account= new StudentData[Size];
        account[0]=Zabil;
        account[1]=Haris;
        
        JOptionPane.showMessageDialog(null,"Welcome.");
        loginChoice= Integer.parseInt( JOptionPane.showInputDialog(null,"Press 1 for admin login, else sign in normally if you're a student "));
        
        //Admin sign in
        if(loginChoice==1){
            checkName= JOptionPane.showInputDialog(null,"Enter your Name ");
            checkPass= JOptionPane.showInputDialog(null,"Enter your password");
            for(int count=0; count<size; count++){
                currentName= accounts[count].getName();
                currentPass= accounts[count].getPassword();
                if(checkName == null ? currentName == null : checkName.equals(currentName)){
                    if(checkPass == null ? currentPass == null : checkPass.equals(currentPass)){
                        JOptionPane.showMessageDialog(null,"Login successful. Welcome Admin!");
                        adminStatus=true;
                    }
                    
                }
        }
            if(adminStatus==false)
            JOptionPane.showMessageDialog(null,"Incorrect name or password!");
            else{
                //Adding functions
        int choice;
        choice= Integer.parseInt( JOptionPane.showInputDialog("""
                                                              What would you like to do? 
                                                              1: Generate full student report 
                                                               2: Edit student data
                                                               3: Add student 
                                                               4: Delete student"""));
        
        //Report choice
        if(choice==1){
            String reportName;
            boolean found=false;
            
            reportName= JOptionPane.showInputDialog("Enter student name for full report");
            for(int count=0; count<Size; count++){
                String checkingName;
                checkingName= account[count].getName();
                if(reportName == null ? checkingName == null : reportName.equals(checkingName)){
                    account[count].fullReport();
                    found=true;
                }
            }
            if(found==false){
                JOptionPane.showMessageDialog(null,"No such student found");
            }
        }
        
        //Edit data choice
        if(choice==2){
            String reportName;
            boolean found=false;
            
            reportName= JOptionPane.showInputDialog("Enter student name for editting data");
            for(int count=0; count<Size; count++){
                String checkingName;
                checkingName= account[count].getName();
                if(reportName == null ? checkingName == null : reportName.equals(checkingName)){
                    choice= Integer.parseInt(JOptionPane.showInputDialog("What would you like to change? \n 1: Section \n 2: Attendance"));
                    found=true;
                    
                    //Changing sections
                    if(choice==1){
                        account[count].setSection(JOptionPane.showInputDialog("Enter new section"));
                    }
                     //Changing attendance
                    if(choice==2){
                        account[count].setAttendance(Integer.parseInt(JOptionPane.showInputDialog("Enter new attendance")));
                }
            }
            if(found==false){
                JOptionPane.showMessageDialog(null,"No such student found");
            }
        }
        
}
        
         //Adding student choice
         if(choice==3){
             String newName, newSection, newPass;
             newName= JOptionPane.showInputDialog("Enter student name: ");
             newSection= JOptionPane.showInputDialog("Enter student section: ");
             newPass= JOptionPane.showInputDialog("Enter student password: ");
              StudentData newStudent= new StudentData(newName,newSection,newPass);
              JOptionPane.showMessageDialog(null, "New account set!");
              
            try {
                BufferedWriter writer= new BufferedWriter(new FileWriter("NewStudentData.txt"));
                //Add new student to end of file for storing
                writer.write(newStudent.getName());
                writer.write("\n" +newStudent.getAge());
                writer.write("\n" +newStudent.getCourse());
                writer.write("\n" +newStudent.getSection());
                writer.write("\n" +newStudent.getSemesterFee());
                writer.write("\n" +newStudent.getYearlyFee());
                writer.write("\n" +newStudent.getGpa());
                writer.write("\n" +newStudent.getAttendance());
                writer.write("\n" +newStudent.getPassword() + "\n\n");
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(SMS.class.getName()).log(Level.SEVERE, null, ex);
            }
               
         }
         
         //Deleting student choice
         if(choice==4){
            String reportName;
            boolean found=false;
            
            reportName= JOptionPane.showInputDialog("Enter student name for deleting data");
             for(int count=0; count<Size; count++){
                String checkingName;
                checkingName= account[count].getName();
                if(reportName == null ? checkingName == null : reportName.equals(checkingName)){
                    account[count].delete();
                    found=true;
                    JOptionPane.showMessageDialog(null, "Account deleted!");
                }
         }
}
            }
    }
        
        //Student sign in
        else{
            int currentAccount=0;
            checkName= JOptionPane.showInputDialog(null,"Enter your Name ");
            checkPass= JOptionPane.showInputDialog(null,"Enter your password");
            for(int count=0; count<Size; count++){
                currentName= account[count].getName();
                currentPass= account[count].getPassword();
                if(checkName == null ? currentName == null : checkName.equals(currentName)){
                    if(checkPass == null ? currentPass == null : checkPass.equals(currentPass)){
                        JOptionPane.showMessageDialog(null,"Login successful. Welcome Student!");
                        studentStatus=true;
                        currentAccount=count;
                    }
                    
                }
        }
            if(studentStatus==false){
                JOptionPane.showMessageDialog(null, "Incorrect name or password");
            }
            else{
                int choice;
                choice= Integer.parseInt(JOptionPane.showInputDialog("What would you like to do? \n1: Edit password \n2: Generate full report \n3: Show yearly fee"));
                
                //Edit password choice
                if(choice==1){
                    account[currentAccount].setPassword(JOptionPane.showInputDialog("Enter new pass"));
                }
                
                //Generate full report
                if(choice==2){
                    account[currentAccount].fullReport();
                }
                
                //Show yearly fee
                if(choice==3){
                    account[currentAccount].calculateFee();
                }
            }
        }
        
        //Writing the edited student data back to file for storage
        try {
            BufferedWriter writer= new BufferedWriter(new FileWriter("StudentData.txt"));
            for(int count=0; count<size; count++){
                
                //If accounted deleted, do not add data to file (use of next line)
                if(!"".equals(account[count].getName())){
                writer.write(account[count].getName());
                writer.write("\n" +account[count].getAge());
                writer.write("\n" +account[count].getCourse());
                writer.write("\n" +account[count].getSection());
                writer.write("\n" +account[count].getSemesterFee());
                writer.write("\n" +account[count].getYearlyFee());
                writer.write("\n" +account[count].getGpa());
                writer.write("\n" +account[count].getAttendance());
                writer.write("\n" +account[count].getPassword() + "\n\n");
            }
            }    
             //Adding new student account to file if created
            BufferedReader reader= new BufferedReader(new FileReader("NewStudentData.txt"));    
            String line;
            while((line= reader.readLine()) !=null){
                writer.write(line+ "\n");
            }
            reader.close();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SMS.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}