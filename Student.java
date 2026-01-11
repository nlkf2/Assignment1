package Assignment1;

public class Student {
    private String sid;
    private String fname;
    private String lname;

    public Student(String sid,String fname,String lname){
        this.sid=sid;
        this.fname=fname;
        this.lname=lname;
    }

    public String Getsid(){
        return sid;
    }

    public String Getfname(){
        return fname;
    }

    public String Getlname(){
        return lname;
    }
}
