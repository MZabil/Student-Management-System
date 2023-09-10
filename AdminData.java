package sms;
public class AdminData extends SMS{
    //To check if admin login is correct
    private String Name;
    private String Password;
    
    //Creating constructor
    public AdminData(String Name, String password){
        this.Name=Name;
        this.Password=password;
    }
    
    public String getName(){
        return Name;
    }
    public String getPassword(){
        return Password;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
}
