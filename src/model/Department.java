package model;

import java.util.ArrayList;
import java.util.List;

public class Department implements Manageable {
    private String name;
    private Human head;
    private List<Group> groups = new ArrayList<>();

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Human getHead() {
        return head;
    }
}
