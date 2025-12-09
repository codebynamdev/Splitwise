package model;
import java.util.ArrayList;
import java.util.List;
public class Group {
    int groupId;
    String GroupName;
    List<User> members;
    List<Expense>expenses;
    public Group(int groupId, String GroupName) {
        this.groupId = groupId;
        this.GroupName = GroupName;
        members = new ArrayList<>();
        expenses = new ArrayList<>();
    }
    public void addMember(int groupId, String GroupName, User user) {
        members.add(user);
        return;
    }
}