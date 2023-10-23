package jsonparser;

import org.json.simple.parser.ParseException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<Student> studentList = JsonParser.parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student.json");
            System.out.println("Printing all the students...");
            printStudentList(studentList);
            StudentService studentService =new StudentService(studentList);
            //Example of search a student by name
            String studentName = "Caleb";
            System.out.println("Printing all the students with \"" + studentName + "\" in their name");
            List<Student> byName = studentService.findByName(studentName);
            printStudentList(byName);
            //Example of search a student by gender
            String studentGender = "Male";
            System.out.println("Printing all the students with gender="+studentGender);
            List<Student> byGender = studentService.findByGender(studentGender);
            printStudentList(byGender);
            //This function is for read the data from console
//            readFromConsole(studentList);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFromConsole(List<Student> studentList){
        Scanner scanner = new Scanner(System.in);

        // Read student name from the console
        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();

        // Read student gender from the console
        System.out.print("Enter the student's gender: ");
        String studentGender = scanner.nextLine();

        // Assuming you have a studentList defined somewhere
        StudentService studentService = new StudentService(studentList);

        // Example of searching for a student by name
        System.out.println("Printing all the students with \"" + studentName + "\" in their name");
        List<Student> byName = studentService.findByName(studentName);
        printStudentList(byName);

        // Example of searching for a student by gender
        System.out.println("Printing all the students with gender=" + studentGender);
        List<Student> byGender = studentService.findByGender(studentGender);
        printStudentList(byGender);
    }

    /**
     *
     * @param studentList The list of student to show
     */
    public static void printStudentList(List<Student> studentList){
        for (Student student:studentList) {
            System.out.println(student);
        }
    }
}
