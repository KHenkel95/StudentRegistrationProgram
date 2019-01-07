public class Student {
    private String firstName;
    private String lastName;
    private String idNumber;

    //Constructors
    public Student(){
        firstName = "";
    }
    public Student(String firstName, String lastName, String idNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }
    //Get and Set first name
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    //Get and Set last name
    public String getLastNameName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    //Get and Set idNumber
    public String getIdNumber(){
        return this.idNumber;
    }
    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    //Methods
    public Boolean equals(Student other){
        return this.idNumber.equals(other.idNumber);
    }

    public String toString(){
        return firstName+"\n"+lastName+"\n"+idNumber;
    }

    public int compareTo(Student other){
        int x = this.lastName.compareTo(other.lastName);
        if(x==0) {
            x = this.firstName.compareTo(other.firstName);
        }
        return x;
    }
}