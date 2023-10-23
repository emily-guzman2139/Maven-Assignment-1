package jsonparser;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> studentList;

    public StudentService(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> findByName(String studentName){
        List<Student> students=new ArrayList<>();
        for (Student student: studentList) {
            if (student.getFirst_name().toLowerCase().contains(studentName.toLowerCase())){
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> findByGender(String studentGender){
        List<Student> students=new ArrayList<>();
        for (Student student: studentList) {
            if (student.getGender().equals(studentGender)){
                students.add(student);
            }
        }
        return students;
    }
}
