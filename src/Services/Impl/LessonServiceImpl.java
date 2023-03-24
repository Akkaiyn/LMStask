package Services.Impl;

import Classes.Group;
import Classes.Lesson;
import Services.LessonService;
import Exception.LmsException;

import java.util.List;
import java.util.Scanner;

public class LessonServiceImpl implements LessonService {
    private static int counter;

    @Override
    public Lesson addLessonToGroup(List<Group> groups) {
        boolean isTrue = true;
        try {
            System.out.println("Enter group name");
            String groupName = new Scanner(System.in).nextLine();

            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(groupName)) {
                    System.out.println("Enter lesson name");
                    String lessonName = new Scanner(System.in).nextLine();
                    System.out.println("Enter lesson description");
                    String description = new Scanner(System.in).nextLine();
                    for (Lesson l : g.getLessons()) {
                        if (l.getName().equalsIgnoreCase(lessonName)) {
                            isTrue = false;
                        } else {
                            isTrue = true;
                        }

                    }
                    if (!isTrue) {
                        throw new LmsException("Dublicate lesson name");
                    } else {
                        Lesson lesson = new Lesson(lessonName, ++counter, description);
                        g.getLessons().add(lesson);
                        return lesson;
                    }
                } else {
                    isTrue = false;
                }

            }
            if (!isTrue) {
                throw new LmsException("Such group not found");
            }

        } catch (LmsException lmsException) {
            System.out.println(lmsException.getMessage());
        }
        return null;
    }

    @Override
    public Lesson getLessonByName(List<Group> groups) {
        return null;
    }

    @Override
    public Lesson getAllLessonByGroupName(List<Group> groups) {
        return null;
    }

    @Override
    public Lesson deleteLesson(List<Group> groups) {
        return null;
    }
}
