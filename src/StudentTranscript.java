import java.util.ArrayList;

public class StudentTranscript extends StudentGrades {

    static ArrayList<String> courses = new ArrayList<String>();
//Constructor
    public StudentTranscript(String firstName, String lastName, String idNumber){
        super(firstName, lastName, idNumber);
    }
//Methods
    public static void addCourse(String course){
        courses.add(course);
    }
    @Override
    public String toString(){
        String courseList = "";
        for (int i = 0; i < courses.size(); i++)
            courseList+=courses.get(i);
        return courseList;
    }
}