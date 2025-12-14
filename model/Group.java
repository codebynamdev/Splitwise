package model;
import java.util.ArrayList;
import java.util.List;
public class Group {
    int groupId;
    String groupName ;
    List<User> members;
    List<Expense>expenses;
    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        members = new ArrayList<>();
        expenses = new ArrayList<>();
    }
    public void addMember(User user) {
        members.add(user);
        return;
    }
}