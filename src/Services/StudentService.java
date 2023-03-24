package Services;

import Classes.Group;
import Classes.Lesson;
import Classes.Student;

import java.util.List;

public interface StudentService {
    Student addStudentToGroup(List<Group> group);
    Student updateStudent(List<Group> groups);
    Student  findStudent(List<Group> groups);
    List<Student>  getAllStudentByGroupName(List<Group> groups);
    List<Lesson>  getAllStudentLesson(List<Group> groups);
    Student deleteStudent(List<Group> groups);
}
