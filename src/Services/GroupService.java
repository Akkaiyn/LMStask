package Services;

import Classes.Group;

import java.util.List;

public interface GroupService {
   Group addGroup(List<Group>groups);
   Group getGroupByName(List<Group>groups);
   Group updateGroupName(List<Group>groups);
   List<Group> getAllGroup(List<Group>groups);
   Group deleteGroup(List<Group>groups);


}
