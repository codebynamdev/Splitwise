package service;

import model.Group;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class GroupService {
    private Map<Integer, Group> groups = new HashMap<>();
    public Group createGroup(int groupId, String groupName) {
        Group group = new Group(groupId, groupName);
        groups.put(groupId, group);
        return group;
    }
    public void addUserToGroup(Group group, User user) {
            group.getMembers().add(user);
    }
    public Group getGroup(int id) {
        return groups.get(id);
    }
}
