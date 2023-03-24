package Services.Impl;

import Classes.Group;
import Services.GroupService;
import Exception.LmsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupServiceImpl implements GroupService {
    private static int counter;

    @Override
    public Group addGroup(List<Group> groups) {
        Group group = new Group();
        try {
            System.out.println("Enter group name:");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter group description:");
            String description = new Scanner(System.in).nextLine();
            group.setName(name);
            group.setStudents(new ArrayList<>());
            group.setLessons(new ArrayList<>());
            group.setDescription(description);
            if (!groups.isEmpty()) {
                for (Group g : groups) {
                    if (g.getName().equalsIgnoreCase(name)) {
                        throw new LmsException("There is already same name! Please, enter other name!");
                    } else {
                        group.setId(++counter);
                        groups.add(group);

                        return group;
                    }
                }
            } else {
                group.setId(++counter);
                groups.add(group);
            }
        } catch (LmsException lms) {
            System.out.println(lms.getMessage());
        }
        return group;
    }

    @Override
    public Group getGroupByName(List<Group> groups) {
        System.out.println("Enter group ID ");
        int id = new Scanner(System.in).nextInt();
        for (Group g : groups) {
            if (g.getId() == id) {
                return g;
            } else {
                System.out.println("There is no group with this ID ");
            }
        }
        return null;
    }

    @Override
    public Group updateGroupName(List<Group> groups) {
        try {
            System.out.println("Enter group name, that you want to change");
            String name = new Scanner(System.in).nextLine();
            boolean isTrue = true;
            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(name)) {
                    isTrue = true;
                    System.out.println("Enter new name for this group");
                    name = new Scanner(System.in).nextLine();
                    g.setName(name);
                    return g;
                } else {
                    isTrue = false;
                }
            }
            if (!isTrue){
                throw new LmsException("Not found");
            }
        } catch (LmsException lmsException) {
            System.out.println(lmsException.getMessage());
        }
        return null;

    }

    @Override
    public List<Group> getAllGroup(List<Group> groups) {
        return groups;
    }

    @Override
    public Group deleteGroup(List<Group> groups) {
       try {
           System.out.println("Enter group name, that you want to delete");
           String name = new Scanner(System.in).nextLine();
           boolean isTrue = true;
           for (Group g : groups) {
               if (g.getName().equalsIgnoreCase(name)) {
                   isTrue = true;
                   groups.remove(g);
                   return g;
               } else {
                   isTrue = false;
               }
           }  if (!isTrue){
               throw new LmsException("Not found");
           }

       } catch (LmsException lmsException){
           System.out.println(lmsException.getMessage());
       }
        return null;
    }
}
