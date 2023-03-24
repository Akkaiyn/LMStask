package Services;

import Classes.Group;
import Classes.Lesson;
import Classes.Student;

import java.util.List;

public interface LessonService {
Lesson addLessonToGroup(List<Group>groups);
Lesson getLessonByName(List<Group>groups);
    Lesson getAllLessonByGroupName(List<Group>groups);
    Lesson deleteLesson(List<Group>groups);
}
