/*
Author: Ken Henkel
Prof. Smith-Thompson
CUS1116
 */
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args)throws FileNotFoundException{
        Student s = new Student("John","Smith","X007");
        System.out.println(s.toString());
        Student t = new Student("Mary","Smith","X002");
        System.out.println(t.toString());
        Student w = new Student("John", "Smith", "X005");
        System.out.println(s.equals(t));
        System.out.println(s.equals(w));
        if (s.compareTo(t) < 0){
            System.out.println(s.toString());
        }
        else if (s.compareTo(t) > 0){
            System.out.println(t.toString());
        }
        else{
            System.out.println("They are the same!");
        }
    }
}