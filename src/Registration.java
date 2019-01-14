import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Registration {
    //Methods
    public static void storeRoster(Student[] roster) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("C://Users//Ken//IdeaProjects//CUS1116Project//src//Roster.txt");
        for (Student student : roster) {
            output.println(student);
        }
        output.close();
    }

    public static Student[] loadRoster() throws FileNotFoundException {
        File infile = new File("C://Users//Ken//IdeaProjects//CUS1116Project//src//Roster.txt");
        Scanner reader = new Scanner(infile);
        //TODO make it so that roster2 scales up when add student is used
        Student[] roster2 = new Student[5];
        int arrayCounter = 0;
        while (reader.hasNextLine()) {
            String name1 = reader.nextLine();
            String name2 = reader.nextLine();
            String idNum = reader.nextLine();
            roster2[arrayCounter] = new Student(name1, name2, idNum);
            arrayCounter++;
        }
        reader.close();
        return roster2;
    }

    public static void insertionSort(Student[] roster) {
        for (int j = 1; j < roster.length; j++) {
            int i = j;
            Student x = roster[j];
            while ((i > 0) && (x.compareTo(roster[i - 1]) < 0)) {
                roster[i] = roster[i - 1];
                i--;
            }
            roster[i] = x;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Gui.launch(Gui.class, args);
//TODO add input for user to make custom roster size
        /*int rosterSize;
        Scanner kybd = new Scanner(System.in);
        System.out.println("How many students would you like to add to the roster?");
        rosterSize = kybd.nextInt();
        Student[] roster = new Student[rosterSize];
        */
        Scanner kybd = new Scanner(System.in);
        String firstName;
        String lastName;
        String idNumber;
        Student[] roster = new Student[5];
        for (int t = 0; t < roster.length; t++) {
            System.out.println("Enter the Student's First Name: ");
            firstName = kybd.next();
            System.out.println("Enter the Student's Last Name: ");
            lastName = kybd.next();
            System.out.println("Enter the Student's ID Number: ");
            idNumber = kybd.next();
            roster[t] = new Student(firstName, lastName, idNumber);
        }
        insertionSort(roster);
        int menu = -1;
        do {
            System.out.println("Press: \n1. to Load Roster\n2. Store Roster\n3. Add Student\n4. Display Student\n" +
                    "5. Display Roster\n6. Delete Student\nor 999 to exit");
            //FIXME Fix infinite loop if an invalid input is entered
            do {
                try{
                    menu = kybd.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Please enter a valid number");
                }
                kybd.nextLine();
            } while(!kybd.hasNextInt());
            switch (menu) {
                case 1:
                    loadRoster();
                    break;
                case 2:
                    storeRoster(roster);
                    break;
                case 3:
                    int newLength = roster.length + 1;
                    Student[] newRoster = new Student[newLength];
                    for (int d = 0; d < roster.length; d++) {
                        newRoster[d] = roster[d];
                    }
                    System.out.println("Enter the Student's First Name: ");
                    firstName = kybd.next();
                    System.out.println("Enter the Student's Last Name: ");
                    lastName = kybd.next();
                    System.out.println("Enter the Student's ID Number: ");
                    idNumber = kybd.next();
                    newRoster[newLength - 1] = new Student(firstName, lastName, idNumber);
                    roster = newRoster;
                    insertionSort(roster);
                    break;
                case 4:
                    System.out.println("Enter the Id Number of the Student to display: ");
                    String id = kybd.next();
                    for (int i = 0; i < roster.length; i++) {
                        if (id.equals(roster[i].getIdNumber())) {
                            System.out.println(roster[i].toString());
                        }
                    }
                    break;
                case 5:
                    for (Student student : roster) {
                        System.out.println(student.toString());
                    }
                    break;
                case 6:
                    System.out.println("Please enter the Id Number of the student you want to delete:");
                    String del = kybd.next();
                    Student[] roster2 = new Student[roster.length - 1];
                    int a = 0;
                    for (int i = 0; i < roster.length; i++) {
                        if (!roster[i].getIdNumber().equals(del)) {
                            roster2[a++] = roster[i];
                        }
                    }
                    roster = roster2;
                    break;
                default:
                    if (menu != 999) {
                        System.out.println("Invalid number, please try again:");
                    }
                    break;
            }
        } while (menu != 999);
        for (Student student : roster) {
            System.out.println(student.toString());
        }
        storeRoster(roster);
        loadRoster();
        StudentTranscript.addCourse("CUS1115");
        System.out.println(StudentTranscript.courses.toString());
    }
}
