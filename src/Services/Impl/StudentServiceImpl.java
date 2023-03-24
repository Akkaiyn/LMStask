package Services.Impl;

import Classes.Group;
import Classes.Lesson;
import Classes.Student;
import Services.StudentService;
import Exception.LmsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    private static int counter;

    @Override
    public Student addStudentToGroup(List<Group> groups) {
        // List<Student> students = new ArrayList<>();

        boolean isTrue = true;

        try {
            System.out.println("Enter group name");
            String groupName = new Scanner(System.in).nextLine();
            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(groupName)) {
                    System.out.println("Enter student name");
                    String studentName = new Scanner(System.in).nextLine();
                    System.out.println("Enter student's email");
                    String email = new Scanner(System.in).nextLine();
                    if (!email.contains("@")) {
                        throw new LmsException("email must have '@'");
                    }

                    for (Student s : g.getStudents()) {
                        isTrue = !s.getEmail().equalsIgnoreCase(email);
                    }
                    if (!isTrue) {
                        throw new LmsException("Same email");
                    } else {
                        Student student = new Student(studentName, email, ++counter);
                        g.getStudents().add(student);
                        return student;
                    }

                } else {
                    isTrue = false;
                }

            }
            if (!isTrue) {
                throw new LmsException("Group not found");
            }
        } catch (LmsException lmsException) {
            System.out.println(lmsException.getMessage());
        }
        return null;
    }


    @Override
    public Student updateStudent(List<Group> groups) {
        boolean isTrue = true;
        try{
            System.out.println("Enter students email");
            String email = new Scanner(System.in).nextLine();
            for (Group g: groups) {
                for (Student s : g.getStudents()) {
                    if (s.getEmail().equalsIgnoreCase(email)){
                        isTrue = true;
                        System.out.println("Enter new name");
                        String name = new Scanner(System.in).nextLine();
                        s.setName(name);
                        System.out.println("Student's name successful changed! ");
                        return s;
                    }else {
                        isTrue = false;
                    }
                }
            }
            if (!isTrue){
                throw new LmsException("Wrong email");
            }
        }catch (LmsException lmsException){
            System.out.println(lmsException.getMessage());
        }
        return null;
    }

    @Override
    public Student findStudent(List<Group> groups) {
        boolean isTrue = true;
        try {
            System.out.println("Enter student's email");
            String email = new Scanner(System.in).nextLine();
            for (Group g: groups){
                for (Student s : g.getStudents()) {
                    if (s.getEmail().equalsIgnoreCase(email)){
                        return s;
                    }else {
                        isTrue = false;
                    }
                }
            } if (!isTrue){
                throw new LmsException("There is no student with  email " + email + "!" );
            }
        }catch (LmsException lmsException) {
            System.out.println(lmsException.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentByGroupName(List<Group> groups) {
        boolean isTrue = true;
        try {
            System.out.println("Enter group name");
            String name = new Scanner(System.in).nextLine();
            for (Group g: groups){
                if (g.getName().equalsIgnoreCase(name)){
                    return g.getStudents();
                }else {
                    isTrue = false;
                }
            }if (!isTrue){
                throw new LmsException("There isn't  such group name! ");
            }

        } catch (LmsException lmsException){
            System.out.println(lmsException.getMessage());
        }
        return null;
    }

    @Override
    public List<Lesson> getAllStudentLesson(List<Group> groups) {
        boolean isTrue = true;
        try {
            System.out.println("Enter student's email");
            String email = new Scanner(System.in).nextLine();
            for (Group g: groups){
                for (Student s: g.getStudents()){
                    if (s.getEmail().equalsIgnoreCase(email)){
                       return g.getLessons();
                    }else {
                        isTrue = false;
                    }
                }
            }
            if (!isTrue){
                throw new LmsException("There is no student with  email " + email + "!");
            }
        }catch (LmsException lmsException){
            System.out.println(lmsException.getMessage());
        }
        return null;
    }

    @Override
    public Student deleteStudent(List<Group> groups) {
        boolean isTrue = true;
        try {
            System.out.println("Enter student's email");
            String email = new Scanner(System.in).nextLine();
            for (Group g : groups) {
                    for (int i = 0; i < g.getStudents().size(); i++) {
                        if (g.getStudents().get(i).getEmail().equalsIgnoreCase(email)){
                            g.getStudents().remove(g.getStudents().get(i));
                        }else {
                            isTrue = false;
                        }
                    }
            }

            if (!isTrue){
                throw new LmsException("\"There is no student with  email " + email + "!");
            }
        }catch (LmsException lmsException){
            System.out.println(lmsException.getMessage());
        }
        return null;
    }
}
