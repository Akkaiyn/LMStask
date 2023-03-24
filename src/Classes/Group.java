package Classes;

import java.util.Arrays;
import java.util.List;

public class Group {
    private String name;
    private String description;
    private int id;
    private List<Lesson> lessons;
    private List<Student> students;

    public Group() {
    }

    public Group(String name, String description, int id, List<Lesson> lessons, List<Student> students) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.lessons = lessons;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", lessons=" + lessons +
                ", students=" + students +
                '}';
    }
}
