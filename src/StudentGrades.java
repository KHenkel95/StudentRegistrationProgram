public class StudentGrades extends Student {

    private double totalCredits;
    private double currentGPA;
//Constructor
    public StudentGrades(String firstName, String lastName, String idNumber){
        super(firstName, lastName, idNumber);
    }
    //Get and Set total credits
    public double getTotalCredits(){
        return this.totalCredits;
    }
    public void setTotalCredits(int credNum){
        this.totalCredits=credNum;
    }
    //Get and Set Current GPA
    public double getCurrentGPA(){
        return this.currentGPA;
    }
    public void setCurrentGPA(int cGpa){
        this.currentGPA=cGpa;
    }
//Methods
    public String toString(){
        return "totalCredits+\n+currentGPA";
    }
}
