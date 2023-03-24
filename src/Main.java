import Classes.Group;
import Classes.Lesson;
import Classes.Student;
import Services.GroupService;
import Services.Impl.GroupServiceImpl;
import Services.Impl.LessonServiceImpl;
import Services.Impl.StudentServiceImpl;
import jdk.jshell.Snippet;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Exception.LmsException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String e = "admin@gmail.com";
        String p = "admin1235";
        LocalTime alive = LocalTime.now();
        if (alive.getHour() > 4 && alive.getHour() < 18)
            System.out.println("Good day!" + alive);
        else System.out.println("Good night!" + alive);
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("If you already signed up press 1, if you forgot the password and want change it 2");
            Scanner s = new Scanner(System.in);

            try {
                int f = s.nextInt();
                switch (f) {
                    case 1:
                        System.out.println("hello");
                        isTrue = false;
                        break;
                    default:
                        throw new LmsException("Enter correct password, please");
                }
//                if (f != 1) {
//                    throw new LMSexception();
//                }
            } catch (LmsException ex) {
                System.out.println(ex.getMessage());
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Just number, please");
            }

        }
        boolean isT = true;
        List<Group> groups = new ArrayList<>();
        GroupServiceImpl groupServiceImpl = new GroupServiceImpl();
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        LessonServiceImpl lessonServiceImpl = new LessonServiceImpl();
        while (isT) {

            System.out.println("Choose one command" +
                    "\n1 -> Add new group" +
                    "\n2 -> Get group by name" +
//                    "\n3 -> Update group name" +
//                    "\n4 -> Get all group" +
//                    "\n5 -> Add new student to group" +
//                    "\n6 -> Update student" +
//                    "\n7 -> Find student by first name" +
//                    "\n8 -> Get all students by group name" +
//                    "\n9 -> Get all student's lesson" +
//                    "\n10 -> Delete student" +
//                    "\n11 -> Add new lesson to group" +
//                    "\n12 -> Get lesson by name" +
//                    "\n13 -> Get all lesson by group name" +
//                    "\n14 -> Delete lesson" +
                    "\n15 -> Delete group");

            try {
                int ch;
                ch = new Scanner(System.in).nextInt();
                switch (ch) {
                    case 1 -> System.out.println(groupServiceImpl.addGroup(groups));
                    case 2 -> System.out.println(groupServiceImpl.getGroupByName(groups));
                    case 3 -> System.out.println(groupServiceImpl.updateGroupName(groups));
                    case 4 -> System.out.println(groupServiceImpl.getAllGroup(groups));
                    case 5 -> System.out.println(studentServiceImpl.addStudentToGroup(groups));
                    case 6 -> System.out.println(studentServiceImpl.updateStudent(groups));
                    case 7 -> System.out.println(studentServiceImpl.findStudent(groups));
                    case 8 -> System.out.println(studentServiceImpl.getAllStudentByGroupName(groups));
                    case 9 -> System.out.println(studentServiceImpl.getAllStudentLesson(groups));
                    case 10 -> System.out.println(studentServiceImpl.deleteStudent(groups));
                    case 11 -> System.out.println(lessonServiceImpl.addLessonToGroup(groups));

                    case 15 -> System.out.println(groupServiceImpl.deleteGroup(groups));
                }


            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Only number,please");
            }
        }


    }
}